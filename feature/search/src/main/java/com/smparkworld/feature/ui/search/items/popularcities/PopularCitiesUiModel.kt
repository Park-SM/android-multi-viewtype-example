package com.smparkworld.feature.ui.search.items.popularcities

import android.os.Parcelable
import com.smparkworld.feature.ui.search.base.SearchUiModel
import com.smparkworld.feature.ui.search.base.SearchViewType
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularCitiesUiModel(
    override val viewType: SearchViewType = SearchViewType.POPULAR_CITIES,
    val cities: List<PopularCityUiModel>
) : SearchUiModel, Parcelable

@Parcelize
data class PopularCityUiModel(
    val label: String,
    val backgroundColor: String
) : Parcelable