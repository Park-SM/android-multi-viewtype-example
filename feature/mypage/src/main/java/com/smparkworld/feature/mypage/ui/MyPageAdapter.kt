package com.smparkworld.feature.mypage.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.smparkworld.common.base.recyclerview.SectionDiffCallback
import com.smparkworld.common.base.recyclerview.SectionViewBinder
import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import kotlin.reflect.KClass

private typealias MyPageViewBinder = SectionViewBinder<MyPageUiModel, ViewHolder>

class MyPageAdapter(
    private val viewBinders: Map<KClass<out MyPageUiModel>, MyPageViewBinder>
) : ListAdapter<MyPageUiModel, ViewHolder>(SectionDiffCallback(viewBinders)) {

    private val viewTypeToBinder = viewBinders.mapKeys { it.value.getSectionItemType() }

    override fun getItemViewType(position: Int): Int =
        viewBinders.getValue(getItem(position)::class).getSectionItemType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        viewTypeToBinder.getValue(viewType).createViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit =
        viewTypeToBinder.getValue(getItemViewType(position)).bindViewHolder(getItem(position), holder)
}