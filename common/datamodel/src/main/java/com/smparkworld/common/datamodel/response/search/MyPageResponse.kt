package com.smparkworld.common.datamodel.response.search

import com.smparkworld.common.datamodel.response.DTO

data class SearchResponse(
    val title: String? = null,
    val popularCities: List<SearchPopularCity>? = null,
    val user: SearchUser? = null,
    val products: List<SearchProduct>? = null
) : DTO

data class SearchPopularCity(
    val label: String? = null,
    val backgroundColor: String? = null
) : DTO

data class SearchUser(
    val name: String? = null,
    val description: String? = null,
    val point: Int? = null,
    val coupon: Int? = null,
    val follower: Int? = null
) : DTO

data class SearchProduct(
    val id: Int? = null,
    val title: String? = null,
    val review: String? = null,
    val price: String? = null
) : DTO