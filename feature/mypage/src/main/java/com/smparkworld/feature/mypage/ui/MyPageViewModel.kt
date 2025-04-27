package com.smparkworld.feature.mypage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smparkworld.feature.mypage.data.MyPageRepository
import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val repository: MyPageRepository
) : ViewModel() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    private val _items = MutableStateFlow<List<MyPageUiModel>>(emptyList())
    val items: StateFlow<List<MyPageUiModel>> = _items.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val mapper = MyPageMapper()

    init {
        requestSections()
    }

    private fun requestSections() {
        if (isLoading.value) return
        _isLoading.value = true

        viewModelScope.launch {
            val response = repository.requestSections()
            if (response.isSuccess) {
                response.getOrNull()?.let { dto ->
                    _title.emit(mapper.mapTitle(dto))
                    _items.emit(mapper.mapItemUiModels(dto))
                }
            } else {
                // Handle error
            }
            _isLoading.value = false
        }
    }
}