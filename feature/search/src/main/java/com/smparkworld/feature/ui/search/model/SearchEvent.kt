package com.smparkworld.feature.ui.search.model

sealed interface SearchEvent {

    data object Close : SearchEvent
}