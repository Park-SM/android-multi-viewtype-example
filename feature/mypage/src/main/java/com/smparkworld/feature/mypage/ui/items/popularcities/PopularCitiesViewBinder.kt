package com.smparkworld.feature.mypage.ui.items.popularcities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.common.base.recyclerview.SectionViewBinder
import com.smparkworld.feature.mypage.R
import com.smparkworld.feature.mypage.databinding.ItemMyPagePopularCiteisBinding
import com.smparkworld.feature.mypage.ui.base.MyPageViewHolder

class PopularCitiesViewBinder
    : SectionViewBinder<PopularCitiesUiModel, PopularCitiesViewHolder>(PopularCitiesUiModel::class) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemMyPagePopularCiteisBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::PopularCitiesViewHolder)
    }

    override fun bindViewHolder(model: PopularCitiesUiModel, holder: PopularCitiesViewHolder) {
        holder.bind(model)
    }

    override fun getSectionItemType(): Int {
        return R.layout.item_my_page_popular_citeis
    }

    override fun areItemsTheSame(oldItem: PopularCitiesUiModel, newItem: PopularCitiesUiModel): Boolean =
        true

    override fun areContentsTheSame(oldItem: PopularCitiesUiModel, newItem: PopularCitiesUiModel): Boolean =
        oldItem == newItem
}

class PopularCitiesViewHolder(
    private val binding: ItemMyPagePopularCiteisBinding
) : MyPageViewHolder<PopularCitiesUiModel>(binding.root) {

    override fun bind(model: PopularCitiesUiModel) {
        binding.response.text = model.toString()
    }
}