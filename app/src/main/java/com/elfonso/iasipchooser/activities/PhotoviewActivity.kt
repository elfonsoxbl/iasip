package com.elfonso.iasipchooser.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

import com.elfonso.iasipchooser.R

import com.github.chrisbanes.photoview.PhotoView

class PhotoviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photoview)
        val viewPager = findViewById<ViewPager2>(R.id.photoview_pager)
        val photoView = findViewById<PhotoView>(R.id.photo_view)
        // photoView.setImageResource(R.drawable.image) // Use this to set the image
    }
}