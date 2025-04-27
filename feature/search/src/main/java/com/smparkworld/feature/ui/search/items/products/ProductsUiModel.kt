package com.smparkworld.feature.ui.search.items.products

import android.os.Parcelable
import com.smparkworld.feature.ui.search.base.SearchUiModel
import com.smparkworld.feature.ui.search.base.SearchViewType
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsUiModel(
    override val viewType: SearchViewType = SearchViewType.PRODUCT,
    val products: List<ProductUiModel>
) : SearchUiModel, Parcelable

@Parcelize
data class ProductUiModel(
    val title: String,
    val review: String?,
    val price: String
) : Parcelable