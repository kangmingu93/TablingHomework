package com.crayon.tablinghomework.presentation.navigation.store_interest.recent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.crayon.tablinghomework.R
import com.crayon.tablinghomework.databinding.FragmentRecentStoreBinding
import com.crayon.tablinghomework.di.viewmodel.ViewModelFactory
import com.crayon.tablinghomework.presentation.navigation.store_interest.StoreAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RecentStoreFragment : DaggerFragment() {

    @Inject lateinit var factory: ViewModelFactory
    @Inject lateinit var mAdapter: StoreAdapter
    private lateinit var viewModel: RecentStoreViewModel
    private var _binding: FragmentRecentStoreBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recent_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecentStoreBinding.bind(view)

        viewModel = ViewModelProvider(this, factory).get(RecentStoreViewModel::class.java)
        setUpRecyclerView()
        subscribeObservers()
        viewModel.loadStores()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        viewModel.run {
            clearDisposable()
        }
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = mAdapter
    }

    private fun subscribeObservers() {
        viewModel.storesReceivedLiveData.observe(this, {
            it?.let { result ->
                mAdapter.addData(result.list)
            }
        })
    }

}