package com.smparkworld.feature.mypage.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MyPageViewHolder<MODEL : MyPageUiModel>(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(model: MODEL)
}