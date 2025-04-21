package com.smparkworld.common.base.recyclerview

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class SectionTargetItemDecoration(
    private val targetItemType: Int
) : RecyclerView.ItemDecoration() {

    open fun onDrawOnTarget(c: Canvas, child: View, parent: RecyclerView, state: RecyclerView.State) {}
    open fun onDrawOverOnTarget(c: Canvas, child: View, parent: RecyclerView, state: RecyclerView.State) {}
    open fun getItemOffsetsOnTarget(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {}

    final override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if (isTargetView(child, parent)) {
                onDrawOnTarget(c, child, parent, state)
            }
        }
    }

    final override fun onDraw(c: Canvas, parent: RecyclerView) {
        super.onDraw(c, parent)
    }

    final override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if (isTargetView(child, parent)) {
                onDrawOverOnTarget(c, child, parent, state)
            }
        }
    }

    final override fun onDrawOver(c: Canvas, parent: RecyclerView) {
        super.onDrawOver(c, parent)
    }

    final override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (isTargetView(view, parent)) {
            getItemOffsetsOnTarget(outRect, view, parent, state)
        }
    }

    final override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)
    }

    protected fun getViewPosition(view: View, parent: RecyclerView): Int? =
        parent.getChildAdapterPosition(view).takeIf { it != RecyclerView.NO_POSITION }

    private fun isTargetView(view: View, parent: RecyclerView): Boolean {
        val adapter = (parent.adapter as? ListAdapter<*, *>) ?: return true

        val position = getViewPosition(view, parent) ?: return true
        if (position !in 0 until adapter.itemCount) return true

        return (adapter.getItemViewType(position) == targetItemType)
    }
}