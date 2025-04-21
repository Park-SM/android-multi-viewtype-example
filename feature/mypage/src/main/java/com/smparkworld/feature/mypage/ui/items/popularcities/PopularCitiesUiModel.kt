package com.smparkworld.feature.mypage.ui.items.popularcities

import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import com.smparkworld.feature.mypage.ui.base.MyPageViewType

data class PopularCitiesUiModel(
    override val viewType: MyPageViewType = MyPageViewType.POPULAR_CITIES,
    val cities: List<PopularCityUiModel>
) : MyPageUiModel

data class PopularCityUiModel(
    val label: String,
    val backgroundColor: String
)