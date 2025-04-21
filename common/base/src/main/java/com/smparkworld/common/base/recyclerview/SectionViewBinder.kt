package com.smparkworld.common.base.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.reflect.KClass

abstract class SectionViewBinder<M : Any, VH : ViewHolder>(
    val modelClass: KClass<out M>
) : DiffUtil.ItemCallback<M>() {

    abstract fun createViewHolder(parent: ViewGroup): ViewHolder
    abstract fun bindViewHolder(model: M, holder: VH)
    abstract fun getSectionItemType(): Int

    open fun getSectionItemDecoration(): SectionTargetItemDecoration? = null
}