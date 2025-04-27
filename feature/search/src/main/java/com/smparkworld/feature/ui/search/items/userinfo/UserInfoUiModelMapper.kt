package com.smparkworld.feature.ui.search.items.userinfo

import com.smparkworld.common.datamodel.response.search.SearchResponse
import com.smparkworld.feature.ui.search.base.SearchUiModelMapper

class UserInfoUiModelMapper : SearchUiModelMapper<UserInfoUiModel> {

    override fun mapToUiModel(origin: SearchResponse): UserInfoUiModel? {
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