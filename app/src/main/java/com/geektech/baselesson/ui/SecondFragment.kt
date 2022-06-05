package com.geektech.baselesson.ui

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.baselesson.R
import com.geektech.baselesson.adapter.PhotoAdapter
import com.geektech.baselesson.adapter.submitData
import com.geektech.baselesson.base.BaseFragment
import com.geektech.baselesson.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch

class SecondFragment :
    BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {
    override val binding by viewBinding(FragmentSecondBinding::bind)
    private val viewModel: PhotoViewModel by activityViewModels()
    private val photoAdapter = PhotoAdapter()

    override fun initViews() {
        setupAdapter()
    }

    override fun initListeners() {
        binding.btnArrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setupAdapter() {
        binding.recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        binding.recyclerview.adapter = photoAdapter
        binding.recyclerview.layoutManager = GridLayoutManager(context, 3)
    }

    override fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listState.observe(viewLifecycleOwner) { list ->
                println(list.toString())
                photoAdapter.submitData(list)
            }
        }
    }
}