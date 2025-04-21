package com.smparkworld.feature.mypage.ui

import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import com.smparkworld.feature.mypage.ui.base.MyPageViewType

class MyPageMapper {

    private val mappers = MyPageViewType.createMappers()

    fun mapTitle(dto: MyPageResponse): String {
        return dto.title.orEmpty()
    }

    fun mapUiModels(dto: MyPageResponse): List<MyPageUiModel> {
        return mappers.mapNotNull { it.mapToUiModel(dto) }
    }
}