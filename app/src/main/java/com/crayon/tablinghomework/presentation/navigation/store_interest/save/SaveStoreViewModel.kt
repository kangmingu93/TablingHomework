package com.crayon.tablinghomework.presentation.navigation.store_interest.save

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import com.crayon.tablinghomework.domain.usecase.GetSaveRestaurantsUseCase
import javax.inject.Inject

class SaveStoreViewModel @Inject constructor(
    private val useCase: GetSaveRestaurantsUseCase
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