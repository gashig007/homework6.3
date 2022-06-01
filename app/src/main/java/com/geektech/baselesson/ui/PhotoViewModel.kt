package com.geektech.baselesson.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.baselesson.model.Image

class PhotoViewModel : ViewModel() {

    private val _listState = MutableLiveData<List<Image>>()
    var listState: LiveData<List<Image>> = _listState

    fun putPicture(list: List<Image>) {
        _listState.postValue(list)
    }
}