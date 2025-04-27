package com.smparkworld.feature.ui.search.items.popularcities

import com.smparkworld.common.datamodel.response.search.SearchPopularCity
import com.smparkworld.common.datamodel.response.search.SearchResponse
import com.smparkworld.feature.ui.search.base.SearchUiModelMapper

class PopularCitiesUiModelMapper : SearchUiModelMapper<PopularCitiesUiModel> {

    override fun mapToUiModel(origin: SearchResponse): PopularCitiesUiModel? {
        return PopularCitiesUiModel(
            cities = origin.popularCities?.mapNotNull(::mapToItemUiModel) ?: return null
        )
    }

    private fun mapToItemUiModel(origin: SearchPopularCity): PopularCityUiModel? {
        return PopularCityUiModel(
            label = origin.label ?: return null,
            backgroundColor = origin.backgroundColor ?: return null
        )
    }
}