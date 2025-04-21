package com.smparkworld.common.datamodel.response.mypage

import com.smparkworld.common.datamodel.response.DTO

data class MyPageResponse(
    val title: String? = null,
    val popularCities: List<MyPagePopularCity>? = null,
    val user: MyPageUser? = null,
    val products: List<MyPageProduct>? = null
) : DTO

data class MyPagePopularCity(
    val label: String? = null,
    val backgroundColor: String? = null
) : DTO

data class MyPageUser(
    val name: String? = null,
    val description: String? = null,
    val point: Int? = null,
    val coupon: Int? = null,
    val follower: Int? = null
) : DTO

data class MyPageProduct(
    val id: Int? = null,
    val title: String? = null,
    val review: String? = null,
    val price: String? = null
) : DTO