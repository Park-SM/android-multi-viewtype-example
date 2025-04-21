package com.smparkworld.feature.mypage.ui.items.popularcities

import com.smparkworld.common.datamodel.response.mypage.MyPagePopularCity
import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.feature.mypage.ui.base.MyPageUiModelMapper

class PopularCitiesUiModelMapper : MyPageUiModelMapper<PopularCitiesUiModel> {

    override fun mapToUiModel(origin: MyPageResponse): PopularCitiesUiModel? {
        return PopularCitiesUiModel(
            cities = origin.popularCities?.mapNotNull(::mapToItemUiModel) ?: return null
        )
    }

    private fun mapToItemUiModel(origin: MyPagePopularCity): PopularCityUiModel? {
        return PopularCityUiModel(
            label = origin.label ?: return null,
            backgroundColor = origin.backgroundColor ?: return null
        )
    }
}