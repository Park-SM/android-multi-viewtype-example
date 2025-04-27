package com.smparkworld.feature.ui.search.base

import com.smparkworld.common.datamodel.response.search.SearchResponse

interface SearchUiModelMapper<TO : SearchUiModel> {

    fun mapToUiModel(origin: SearchResponse): TO?
}