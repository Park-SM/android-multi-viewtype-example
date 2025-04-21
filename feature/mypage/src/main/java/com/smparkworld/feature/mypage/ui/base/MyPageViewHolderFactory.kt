package com.smparkworld.feature.mypage.ui.base

import android.view.ViewGroup

interface MyPageViewHolderFactory<VHF : MyPageViewHolder<out MyPageUiModel>> {

    fun createViewHolder(parent: ViewGroup): VHF
}