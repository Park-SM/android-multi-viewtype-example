package com.smparkworld.feature.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smparkworld.common.base.extensions.sendAt
import com.smparkworld.common.base.framework.ActionHandler
import com.smparkworld.feature.data.search.SearchRepository
import com.smparkworld.feature.ui.search.model.SearchAction
import com.smparkworld.feature.ui.search.model.SearchEvent
import com.smparkworld.feature.ui.search.model.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : ViewModel() {

    private val _event = Channel<SearchEvent>(Channel.BUFFERED)
    val event = _event.receiveAsFlow()

    private val _state = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val state = _state.asStateFlow()

    val actionHandler = ActionHandler<SearchAction> { action ->
        when (action) {
            is SearchAction.OnClickClose -> {
                _event.sendAt(viewModelScope, SearchEvent.Close)
            }
        }
    }

    private val mapper = SearchMapper()

    init {
        requestSections()
    }

    private fun requestSections() {
        _state.value = SearchUiState.Loading

        viewModelScope.launch {

            val response = repository.requestSections()
            val body = response.getOrNull()
            if (response.isSuccess && body != null) {
                _state.value = SearchUiState.Success(
                    title = mapper.mapTitle(body),
                    items = mapper.mapItemUiModels(body)
                )
            } else {
                _state.value = SearchUiState.Error
            }
        }
    }
}