package com.smparkworld.common.base.recyclerview

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.reflect.KClass

class SectionDiffCallback<M : Any>(
    viewBinders: Map<KClass<out M>, SectionViewBinder<M, ViewHolder>>
) : DiffUtil.ItemCallback<M>() {

    // (modelClass to ViewBinder)
    private val binders = viewBinders.mapKeys { it.value.modelClass }

    override fun areItemsTheSame(oldItem: M, newItem: M): Boolean {
        if (oldItem::class != newItem::class) return false
        return binders[oldItem::class]?.areItemsTheSame(oldItem, newItem) ?: false
    }

    override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
        return binders[oldItem::class]?.areContentsTheSame(oldItem, newItem) ?: false
    }
}