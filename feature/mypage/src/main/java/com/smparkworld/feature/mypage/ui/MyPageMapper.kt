package com.smparkworld.feature.mypage.ui

import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.feature.mypage.ui.base.MyPageUiModel
import com.smparkworld.feature.mypage.ui.base.MyPageViewType

class MyPageMapper {

    private val itemUiModelMappers = MyPageViewType.createUiModelMappers()

    fun mapTitle(dto: MyPageResponse): String {
        return dto.title.orEmpty()
    }

    fun mapItemUiModels(dto: MyPageResponse): List<MyPageUiModel> {
        return itemUiModelMappers.mapNotNull { it.mapToUiModel(dto) }
    }
}