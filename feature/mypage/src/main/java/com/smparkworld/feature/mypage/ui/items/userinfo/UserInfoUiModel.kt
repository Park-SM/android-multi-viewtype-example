package com.smparkworld.feature.mypage.ui.items.userinfo

import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import com.smparkworld.feature.mypage.ui.base.MyPageViewType

data class UserInfoUiModel(
    override val viewType: MyPageViewType = MyPageViewType.USER_INFO,
    val name: String,
    val description: String?,
    val point: String,
    val coupon: String,
    val follower: String
) : MyPageUiModel