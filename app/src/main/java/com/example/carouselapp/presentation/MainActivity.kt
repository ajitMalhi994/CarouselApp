package com.example.carouselapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.carouselapp.R
import com.example.carouselapp.presentation.adapter.DeviceListAdapter
import com.example.carouselapp.base.BaseActivity
import com.example.carouselapp.databinding.ActivityMainBinding
import com.example.carouselapp.presentation.adapter.CarouselMainAdapter
import com.example.carouselapp.utils.visibleOrGone
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    private val carouselAdapter = CarouselMainAdapter()
    private val deviceListAdapter = DeviceListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setUpObservers()
        setupOnClickListeners()
    }

    private fun initViews() {
        with(binding) {
            viewpagerCarousel.adapter = carouselAdapter
            TabLayoutMediator(
                tabLayoutDotIndicator,
                viewpagerCarousel
            ) { _, _ -> }.attach()

            rvCarouselSubItemList.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCarouselSubItemList.adapter = deviceListAdapter
            viewpagerCarousel.registerOnPageChangeCallback(onCarouselPageChanged)
            searchText.setOnQueryTextListener(searchTextListener)
        }
    }

    private val searchTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            binding.searchText.clearFocus()
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let {
                viewModel.onSearchValueChange(newText)
            }
            return true
        }
    }

    private val onCarouselPageChanged = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            binding.searchText.clearFocus()
            viewModel.onCarouselChanged(position)
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                with(viewModel){
                    launch {
                        searchQuery.collectLatest {
                            binding.searchText.setQuery(it, false)
                        }
                    }
                    launch {
                        carouselItemList.collectLatest {
                            carouselAdapter.submitList(it.data)
                        }
                    }
                    launch {
                        deviceItemList.collectLatest {
                            deviceListAdapter.submitList(it.data)
                            with(binding.errorLayout) {
                                root.visibleOrGone(it.data.isNullOrEmpty())
                                tvStatus.text =
                                    if (it.data.isNullOrEmpty()) getString(R.string.loading) else getString(
                                        R.string.failed
                                    )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setupOnClickListeners() {
        with(binding.searchText) {
            setOnClickListener {
                isIconified = false
                requestFocus()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.viewpagerCarousel.unregisterOnPageChangeCallback(onCarouselPageChanged)
    }
}
