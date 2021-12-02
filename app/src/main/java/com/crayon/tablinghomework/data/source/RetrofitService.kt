package com.crayon.tablinghomework.data.source

import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("save/")
    fun getSaveRestaurants(): Single<RestaurantsResponse>

    @GET("recent/")
    fun getRecentRestaurants(): Single<RestaurantsResponse>

}