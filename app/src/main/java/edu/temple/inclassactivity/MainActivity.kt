package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get instance of ViewModel
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        //put the information inside the ViewModel'
        mainViewModel.setImageIds(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method
        //val fragment = ImageDisplayFragment.newInstance(imageArray)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, ImageDisplayFragment()).commit()


    }
}