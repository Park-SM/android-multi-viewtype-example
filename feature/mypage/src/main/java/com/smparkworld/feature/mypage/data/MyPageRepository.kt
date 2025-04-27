package com.smparkworld.feature.mypage.data

import com.smparkworld.common.datamodel.response.mypage.MyPagePopularCity
import com.smparkworld.common.datamodel.response.mypage.MyPageProduct
import com.smparkworld.common.datamodel.response.mypage.MyPageResponse
import com.smparkworld.common.datamodel.response.mypage.MyPageUser
import javax.inject.Inject

interface MyPageRepository {

    suspend fun requestSections(): Result<MyPageResponse>
}

class FakeMyPageRepositoryImpl @Inject constructor(

) : MyPageRepository {

    override suspend fun requestSections(): Result<MyPageResponse> {
        val response = MyPageResponse(
            title = "Views 내 정보 화면",
            popularCities = listOf(
                MyPagePopularCity(label = "키즈", backgroundColor = "#00EEFF"),
                MyPagePopularCity(label = "도쿄", backgroundColor = "#EEFF00"),
                MyPagePopularCity(label = "파리", backgroundColor = "#FF00EE")
            ),
            user = MyPageUser(
                name = "박상민",
                description = "I'm Iron-man.\npark97.sm@gmail.com",
                point = 626000,
                coupon = 0,
                follower = 12
            ),
            products = listOf(
                MyPageProduct(
                    id = 123,
                    title = "파리 16구 라 세느",
                    review = "5.0 (23)",
                    price = "225,000원"
                ),
                MyPageProduct(
                    id = 125,
                    title = "파리 바로에펠_1주년 감사 특별할인",
                    review = "5.0 (196)",
                    price = "57,230원"
                )
            )
        )
        return Result.success(response)
    }
}