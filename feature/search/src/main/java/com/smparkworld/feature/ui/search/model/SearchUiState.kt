package com.smparkworld.feature.ui.search.model

import com.smparkworld.feature.ui.search.base.SearchUiModel

sealed interface SearchUiState {

    data object Loading : SearchUiState

    data object Error : SearchUiState

    data class Success(
        val title: String,
        val items: List<SearchUiModel>,
    ) : SearchUiState
}