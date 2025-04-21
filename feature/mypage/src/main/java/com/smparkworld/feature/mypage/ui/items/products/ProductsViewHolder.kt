package com.smparkworld.feature.mypage.ui.items.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.common.base.recyclerview.SectionViewBinder
import com.smparkworld.feature.mypage.ui.base.MyPageViewHolder
import com.smparkworld.feature.mypage.R
import com.smparkworld.feature.mypage.databinding.ItemMyPageProductsBinding

class ProductsViewBinder
    : SectionViewBinder<ProductsUiModel, ProductsViewHolder>(ProductsUiModel::class) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemMyPageProductsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::ProductsViewHolder)
    }

    override fun bindViewHolder(model: ProductsUiModel, holder: ProductsViewHolder) {
        holder.bind(model)
    }

    override fun getSectionItemType(): Int =
        R.layout.item_my_page_products

    override fun areItemsTheSame(oldItem: ProductsUiModel, newItem: ProductsUiModel): Boolean =
        true

    override fun areContentsTheSame(oldItem: ProductsUiModel, newItem: ProductsUiModel): Boolean =
        oldItem == newItem
}

class ProductsViewHolder(
    private val binding: ItemMyPageProductsBinding
) : MyPageViewHolder<ProductsUiModel>(binding.root) {

    override fun bind(model: ProductsUiModel) {
        binding.response.text = model.toString()
    }
}