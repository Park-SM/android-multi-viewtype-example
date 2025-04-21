package com.smparkworld.feature.mypage.ui.base

import com.smparkworld.common.datamodel.response.mypage.MyPageResponse

interface MyPageUiModelMapper<TO : MyPageUiModel> {

    fun mapToUiModel(origin: MyPageResponse): TO?
}