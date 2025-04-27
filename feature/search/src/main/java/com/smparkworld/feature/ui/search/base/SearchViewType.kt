package com.smparkworld.feature.ui.search.base

import com.smparkworld.common.base.compose.SectionComposable
import com.smparkworld.feature.ui.search.items.popularcities.PopularCitiesSectionComposable
import com.smparkworld.feature.ui.search.items.popularcities.PopularCitiesUiModelMapper
import com.smparkworld.feature.ui.search.items.products.ProductsSectionComposable
import com.smparkworld.feature.ui.search.items.products.ProductsUiModelMapper
import com.smparkworld.feature.ui.search.items.userinfo.UserInfoSectionComposable
import com.smparkworld.feature.ui.search.items.userinfo.UserInfoUiModelMapper
import com.smparkworld.feature.ui.search.model.SearchAction

enum class SearchViewType(
    private val composable: SectionComposable<out SearchUiModel, out SearchAction>,
    private val uiModelMapper: SearchUiModelMapper<out SearchUiModel>
) {
    POPULAR_CITIES(PopularCitiesSectionComposable(), PopularCitiesUiModelMapper()),
    USER_INFO(UserInfoSectionComposable(), UserInfoUiModelMapper()),
    PRODUCT(ProductsSectionComposable(), ProductsUiModelMapper()),

    ;
    companion object {

        @JvmStatic
        fun of(type: String): SearchViewType? =
            entries.find { it.name == type }

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun findComposableBy(type: SearchViewType): SectionComposable<SearchUiModel, SearchAction> =
            type.composable as SectionComposable<SearchUiModel, SearchAction>

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun createUiModelMappers(): List<SearchUiModelMapper<SearchUiModel>> =
            entries.map { it.uiModelMapper as SearchUiModelMapper<SearchUiModel> }
    }
}