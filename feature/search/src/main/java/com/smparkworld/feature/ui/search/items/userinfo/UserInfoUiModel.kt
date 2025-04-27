package com.smparkworld.feature.ui.search.items.userinfo

import android.os.Parcelable
import com.smparkworld.feature.ui.search.base.SearchUiModel
import com.smparkworld.feature.ui.search.base.SearchViewType
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfoUiModel(
    override val viewType: SearchViewType = SearchViewType.USER_INFO,
    val name: String,
    val description: String?,
    val point: String,
    val coupon: String,
    val follower: String
) : SearchUiModel, Parcelable