package com.smparkworld.feature.mypage.ui.items.products

import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import com.smparkworld.feature.mypage.ui.base.MyPageViewType

data class ProductsUiModel(
    override val viewType: MyPageViewType = MyPageViewType.PRODUCT,
    val products: List<ProductUiModel>
) : MyPageUiModel

data class ProductUiModel(
    val title: String,
    val review: String?,
    val price: String
)