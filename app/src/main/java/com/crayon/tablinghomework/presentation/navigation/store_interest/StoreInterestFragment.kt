package com.crayon.tablinghomework.presentation.navigation.store_interest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.crayon.tablinghomework.R
import com.crayon.tablinghomework.databinding.FragmentStoreInterestBinding
import com.crayon.tablinghomework.presentation.navigation.store_interest.recent.RecentStoreFragment
import com.crayon.tablinghomework.presentation.navigation.store_interest.save.SaveStoreFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerFragment

class StoreInterestFragment : DaggerFragment() {

    private var _binding: FragmentStoreInterestBinding? = null
    private val binding
        get() = _binding!!

    private val title = arrayOf("저장", "최근본")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store_interest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreInterestBinding.bind(view)

        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        binding.viewPager.apply {
            offscreenPageLimit = 2
            adapter = object : FragmentStateAdapter(requireActivity()) {
                override fun getItemCount(): Int {
                    return title.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> SaveStoreFragment()
                        else -> RecentStoreFragment()
                    }
                }
            }
        }
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = title[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}