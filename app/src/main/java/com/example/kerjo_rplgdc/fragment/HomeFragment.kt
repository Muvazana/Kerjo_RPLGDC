package com.example.kerjo_rplgdc.fragment

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kerjo_rplgdc.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var images = arrayOf(R.drawable.header_pic1, R.drawable.header_pic2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.setImageListener(imageListener)

        carouselView.pageCount = images.size
    }

    val imageListener = ImageListener { position, imageView -> imageView?.setImageResource(images[position]) }

    override fun onResume() {
        super.onResume()
        search_bar.clearFocus()
    }

}
