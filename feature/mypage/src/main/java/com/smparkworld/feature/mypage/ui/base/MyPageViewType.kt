package com.smparkworld.feature.mypage.ui.base

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.smparkworld.common.base.extensions.defaultConstructor
import com.smparkworld.common.base.extensions.filterNonNullValues
import com.smparkworld.common.base.recyclerview.SectionViewBinder
import com.smparkworld.feature.mypage.ui.items.popularcities.PopularCitiesUiModelMapper
import com.smparkworld.feature.mypage.ui.items.popularcities.PopularCitiesViewBinder
import com.smparkworld.feature.mypage.ui.items.products.ProductsUiModelMapper
import com.smparkworld.feature.mypage.ui.items.products.ProductsViewBinder
import com.smparkworld.feature.mypage.ui.items.userinfo.UserInfoUiModelMapper
import com.smparkworld.feature.mypage.ui.items.userinfo.UserInfoViewBinder
import kotlin.reflect.KClass

private typealias ViewBinder      = SectionViewBinder<MyPageUiModel, ViewHolder>
private typealias ViewBinderUpper = SectionViewBinder<out MyPageUiModel, out ViewHolder>

private typealias UiModelMapper      = MyPageUiModelMapper<MyPageUiModel>
private typealias UiModelMapperUpper = MyPageUiModelMapper<out MyPageUiModel>

enum class MyPageViewType(
    private val binder: KClass<out ViewBinderUpper>,
    private val mapper: KClass<out UiModelMapperUpper>
) {
    POPULAR_CITIES(PopularCitiesViewBinder::class, PopularCitiesUiModelMapper::class),
    USER_INFO(UserInfoViewBinder::class, UserInfoUiModelMapper::class),
    PRODUCT(ProductsViewBinder::class, ProductsUiModelMapper::class),

    ;
    companion object {

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun createMappers(): List<UiModelMapper> {
            return entries
                .mapNotNull { it.mapper.defaultConstructor?.call() as? UiModelMapper }
        }

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun createViewBinders(): Map<KClass<out MyPageUiModel>, ViewBinder> {
            return entries
                .mapNotNull { it.binder.defaultConstructor?.call() as? ViewBinder }
                .associateBy { it.modelClass }
                .filterNonNullValues()
        }
    }
}

fun RecyclerView.addItemDecorations(binders: Map<KClass<out MyPageUiModel>, ViewBinder>) {
    binders.mapNotNull { it.value.getSectionItemDecoration() }
        .forEach { addItemDecoration(it) }
}
