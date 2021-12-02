package com.crayon.tablinghomework.domain.usecase

import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import com.crayon.tablinghomework.domain.repository.RestaurantsRepository
import com.crayon.tablinghomework.domain.usecase.base.SingleUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetSaveRestaurantsUseCase @Inject constructor(
    private val repository: RestaurantsRepository
) : SingleUseCase<RestaurantsResponse>() {

    override fun buildUseCaseSingle(): Single<RestaurantsResponse> {
        return repository.getSaveRestaurants()
    }

}