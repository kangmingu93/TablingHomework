package com.crayon.tablinghomework.presentation.navigation.store_interest

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.crayon.tablinghomework.R
import javax.inject.Inject

class StoreBindingAdapter @Inject constructor(
    private val glide: RequestManager
) {

    @BindingAdapter(value = ["loadImageUrl"])
    fun ImageView.loadImage(imageUrl: String?) {
        glide.load(imageUrl ?: "")
            .placeholder(R.drawable.default_image)
            .error(R.drawable.default_image)
            .thumbnail(0.1f)
            .into(this)
    }

    @BindingAdapter(value = ["isRemoteWaiting", "waitingCount"])
    fun TextView.waitingCount(isRemoteWaiting: Boolean?, waitingCount: Int?) {
        val cnt = waitingCount ?: 0
        this.visibility = if (isRemoteWaiting == true) View.VISIBLE else View.GONE
        this.text = if (cnt != 0) "대기 ${cnt}팀" else "대기 없음"
    }

    @BindingAdapter(value = ["rating"])
    fun TextView.rating(rating: Double?) {
        this.text = String.format("%.1f", rating ?: 0.0)
    }

    @BindingAdapter(value = ["reviewCount"])
    fun TextView.reviewCount(reviewCount: Int?) {
        val cnt = reviewCount ?: 0
        this.text = if (cnt >= 300) "(300+)" else "(${cnt})"
    }

    @BindingAdapter(value = ["useView"])
    fun TextView.useView(use: Boolean?) {
        this.visibility = if (use == true) View.VISIBLE else View.GONE
    }

}