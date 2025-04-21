package com.smparkworld.feature.mypage.ui.items.userinfo

import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.feature.mypage.ui.base.MyPageUiModelMapper

class UserInfoUiModelMapper : MyPageUiModelMapper<UserInfoUiModel> {

    override fun mapToUiModel(origin: MyPageResponse): UserInfoUiModel? {
        return UserInfoUiModel(
            name = origin.user?.name ?: return null,
            description = origin.user?.description,
            point = origin.user?.point?.let(::convertToCommaSeparatedNumber) ?: "0",
            coupon = origin.user?.coupon?.let(::convertToCommaSeparatedNumber) ?: "0",
            follower = origin.user?.follower?.let(::convertToCommaSeparatedNumber) ?: "0",
        )
    }

    private fun convertToCommaSeparatedNumber(num: Int?): String? {
        if (num == null) return null
        return try {
            num.toString()
                .reversed()
                .chunked(3)
                .joinToString(",")
                .reversed()
        } catch (e: Exception) {
            num.toString()
        }
    }
}