package com.smparkworld.feature.mypage.ui.items.userinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smparkworld.common.base.recyclerview.SectionViewBinder
import com.smparkworld.feature.mypage.ui.base.MyPageViewHolder
import com.smparkworld.feature.mypage.R
import com.smparkworld.feature.mypage.databinding.ItemMyPageUserInfoBinding

class UserInfoViewBinder
    : SectionViewBinder<UserInfoUiModel, UserInfoViewHolder>(UserInfoUiModel::class) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemMyPageUserInfoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let(::UserInfoViewHolder)
    }

    override fun bindViewHolder(model: UserInfoUiModel, holder: UserInfoViewHolder) {
        holder.bind(model)
    }

    override fun getSectionItemType(): Int =
        R.layout.item_my_page_user_info

    override fun areItemsTheSame(oldItem: UserInfoUiModel, newItem: UserInfoUiModel): Boolean =
        true

    override fun areContentsTheSame(oldItem: UserInfoUiModel, newItem: UserInfoUiModel): Boolean =
        oldItem == newItem
}

class UserInfoViewHolder(
    private val binding: ItemMyPageUserInfoBinding
) : MyPageViewHolder<UserInfoUiModel>(binding.root) {

    override fun bind(model: UserInfoUiModel) {
        binding.response.text = model.toString()
    }
}