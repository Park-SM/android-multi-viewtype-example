package com.smparkworld.common.base.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.smparkworld.common.base.framework.ActionHandler

interface SectionComposable<T, A : SectionAction> {

    @Composable
    fun Section(
        modifier: Modifier,
        model: T,
        actionHandler: ActionHandler<A>
    )
}

interface SectionAction