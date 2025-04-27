package com.smparkworld.feature.ui.search.model

import com.smparkworld.common.base.compose.SectionAction

sealed interface SearchAction : SectionAction {

    data object OnClickClose : SearchAction
}