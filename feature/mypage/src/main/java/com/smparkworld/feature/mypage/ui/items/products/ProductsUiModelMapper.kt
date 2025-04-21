package com.smparkworld.feature.mypage.ui.items.products

import com.smparkworld.common.datamodel.response.mypage.MyPageProduct
import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.feature.mypage.ui.base.MyPageUiModelMapper

class ProductsUiModelMapper : MyPageUiModelMapper<ProductsUiModel> {

    override fun mapToUiModel(origin: MyPageResponse): ProductsUiModel? {
        return ProductsUiModel(
            products = origin.products?.mapNotNull(::mapToItemUiModel) ?: return null
        )
    }

    private fun mapToItemUiModel(origin: MyPageProduct): ProductUiModel? {
        return ProductUiModel(
            title = origin.title ?: return null,
            review = origin.review,
            price = origin.price ?: return null
        )
    }
}