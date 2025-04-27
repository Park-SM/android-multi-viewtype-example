package com.smparkworld.common.design

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

inline fun ComponentActivity.setContentWithTheme(
    crossinline content: @Composable () -> Unit
) {
    setContent {
        AppTheme {
            content()
        }
    }
}