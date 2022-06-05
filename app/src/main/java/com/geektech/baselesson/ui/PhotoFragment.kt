package com.geektech.baselesson.ui

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.baselesson.R
import com.geektech.baselesson.adapter.PhotoAdapter
import com.geektech.baselesson.adapter.submitData
import com.geektech.baselesson.base.BaseFragment
import com.geektech.baselesson.common.extensions.navigateSafely
import com.geektech.baselesson.databinding.ActivityMainBinding.bind
import com.geektech.baselesson.databinding.FragmentPhotoBinding
import com.geektech.baselesson.model.Image

class PhotoFragment : BaseFragment<FragmentPhotoBinding>(R.layout.fragment_photo) {

    override val binding by viewBinding(FragmentPhotoBinding::bind)
    private val photoAdapter = PhotoAdapter()
    private val viewModel: PhotoViewModel by activityViewModels()
    private val list = arrayListOf<Image>()

    private fun addImage(): List<Image> {
        list.apply {
            add(Image(image = "https://w7.pngwing.com/pngs/580/422/png-transparent-butterfly-pink-free-butterflies-pics-purple-blue-image-file-formats.png"))
            add(Image(image = "https://img1.freepng.ru/20180703/pte/kisspng-football-player-american-football-kickball-clip-ar-5b3be0b0aeb612.4759032915306508007156.jpg"))
            add(Image(image = "https://www.pngmart.com/files/1/Claw-Scratch-Red-Vector-PNG.png"))
        }
        return list
    }

    override fun initViews() {
        setupAdapter()
        photoAdapter.submitData(addImage())

    }

    private fun setupAdapter() {
        binding.recycler.overScrollMode = View.OVER_SCROLL_NEVER
        binding.recycler.adapter = photoAdapter
        binding.recycler.layoutManager = GridLayoutManager(context, 3)
    }

    override fun initListeners() {
        binding.fabNext.setOnClickListener {
            println(photoAdapter.secondList)
            viewModel.putPicture(photoAdapter.secondList)
            findNavController().navigateSafely(R.id.action_photoFragment_to_secondFragment)
        }
    }
}
