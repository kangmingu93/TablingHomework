package com.crayon.tablinghomework.presentation.navigation.store_interest.recent

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import com.crayon.tablinghomework.domain.usecase.GetRecentRestaurantsUseCase
import javax.inject.Inject

class RecentStoreViewModel @Inject constructor(
    private val useCase: GetRecentRestaurantsUseCase
) : ViewModel() {

    val storesReceivedLiveData = MutableLiveData<RestaurantsResponse>()

    fun loadStores() {
        useCase.execute(
            onSuccess = {
                storesReceivedLiveData.value = it
            },
            onError = {
                Log.e("TAG", "${it.message}")
            }
        )
    }

}