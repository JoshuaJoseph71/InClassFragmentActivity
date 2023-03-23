package edu.temple.inclassactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // we will change the thing inside the MutableLiveData, so val is valid with declaration
    private val imageIds = MutableLiveData<IntArray>()

    // set the thing inside the LiveData
    fun setImageIds(imagesIds: IntArray){
        this.imageIds.value = imagesIds
    }

    // MutableLiveData is LiveData, if I inherit from that thing, I am that thing
    fun getImageIds(): LiveData<IntArray>{
        return imageIds
    }


}