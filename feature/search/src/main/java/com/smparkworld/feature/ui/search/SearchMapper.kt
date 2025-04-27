package com.smparkworld.feature.ui.search

import com.smparkworld.common.datamodel.response.search.SearchResponse
import com.smparkworld.feature.ui.search.base.SearchUiModel
import com.smparkworld.feature.ui.search.base.SearchViewType

class SearchMapper {

    private val itemUiModelMappers = SearchViewType.createUiModelMappers()

    fun mapTitle(dto: SearchResponse): String {
        return dto.title.orEmpty()
    }

    fun mapItemUiModels(dto: SearchResponse): List<SearchUiModel> {
        return itemUiModelMappers.mapNotNull { it.mapToUiModel(dto) }
    }
}