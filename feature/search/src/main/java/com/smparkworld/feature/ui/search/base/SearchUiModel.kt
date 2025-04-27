package com.smparkworld.feature.ui.search.base

import android.os.Parcelable
import androidx.compose.runtime.Stable

@Stable
interface SearchUiModel : Parcelable {
    val viewType: SearchViewType
}