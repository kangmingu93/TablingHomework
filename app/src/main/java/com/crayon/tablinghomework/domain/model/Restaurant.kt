package com.crayon.tablinghomework.domain.model

data class Restaurant(
    val classification: String,
    val isNew: Boolean,
    val isQuickBooking: Boolean,
    val isRemoteWaiting: Boolean,
    val rating: Double,
    val restaurantIdx: Int,
    val restaurantName: String,
    val reviewCount: Int,
    val summaryAddress: String,
    val thumbnail: String,
    val useBooking: Boolean,
    val useWaiting: Boolean,
    val waitingCount: Int
)