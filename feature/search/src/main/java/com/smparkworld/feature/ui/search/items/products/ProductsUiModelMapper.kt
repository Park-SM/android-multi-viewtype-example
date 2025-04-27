package com.smparkworld.feature.ui.search.items.products

import com.smparkworld.common.datamodel.response.search.SearchProduct
import com.smparkworld.common.datamodel.response.search.SearchResponse
import com.smparkworld.feature.ui.search.base.SearchUiModelMapper

class ProductsUiModelMapper : SearchUiModelMapper<ProductsUiModel> {

    override fun mapToUiModel(origin: SearchResponse): ProductsUiModel? {
        return ProductsUiModel(
            products = origin.products?.mapNotNull(::mapToItemUiModel) ?: return null
        )
    }

    private fun mapToItemUiModel(origin: SearchProduct): ProductUiModel? {
        return ProductUiModel(
            title = origin.title ?: return null,
            review = origin.review,
            price = origin.price ?: return null
        )
    }
}