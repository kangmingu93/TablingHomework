package com.crayon.tablinghomework.presentation.navigation.store_interest

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crayon.tablinghomework.databinding.ItemStoreBinding
import com.crayon.tablinghomework.domain.model.Restaurant
import javax.inject.Inject

class StoreAdapter @Inject constructor() : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    private val restaurants: MutableList<Restaurant> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreBinding.inflate(layoutInflater, parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        when (position) {
            0 -> holder.onBind(restaurants[position], 45)
            else -> holder.onBind(restaurants[position], 12)
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun addData(list: List<Restaurant>) {
        clear()
        restaurants.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    private fun clear() {
        val size = restaurants.size
        restaurants.clear()
        notifyItemRangeRemoved(0, size)
    }

    inner class StoreViewHolder(private val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(restaurant: Restaurant, margin: Int) {
            binding.item = restaurant
            val params = (binding.root.layoutParams as ViewGroup.MarginLayoutParams).apply {
                this.topMargin = dpToPx(binding.root.context, margin)
            }
            binding.root.layoutParams = params
        }

        private fun dpToPx(context: Context, dp: Int): Int = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()

    }

}