package com.smparkworld.feature.data.search

import com.smparkworld.common.datamodel.response.search.SearchPopularCity
import com.smparkworld.common.datamodel.response.search.SearchProduct
import com.smparkworld.common.datamodel.response.search.SearchResponse
import com.smparkworld.common.datamodel.response.search.SearchUser
import javax.inject.Inject

interface SearchRepository {

    suspend fun requestSections(): Result<SearchResponse>
}

class FakeSearchRepositoryImpl @Inject constructor(

) : SearchRepository {

    override suspend fun requestSections(): Result<SearchResponse> {
        val response = SearchResponse(
            title = "Compose 검색 화면",
            popularCities = listOf(
                SearchPopularCity(label = "키즈", backgroundColor = "#00EEFF"),
                SearchPopularCity(label = "도쿄", backgroundColor = "#EEFF00"),
                SearchPopularCity(label = "파리", backgroundColor = "#FF00EE")
            ),
            user = SearchUser(
                name = "박상민",
                description = "I'm Iron-man.\npark97.sm@gmail.com",
                point = 626000,
                coupon = 0,
                follower = 12
            ),
            products = listOf(
                SearchProduct(
                    id = 123,
                    title = "파리 16구 라 세느",
                    review = "5.0 (23)",
                    price = "225,000원"
                ),
                SearchProduct(
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