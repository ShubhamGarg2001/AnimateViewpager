package com.example.librarytester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animateviewpager.background.BackgroundToForegroundTransformer
import com.example.animateviewpager.cube.CubeInTransformer
import com.example.animateviewpager.cube.CubeOutTransformer
import com.example.animateviewpager.depth.DepthPageTransformer
import com.example.animateviewpager.extention.setCarMediaTransformer
import com.example.animateviewpager.extention.setSeeOneSideTransformer
import com.example.animateviewpager.extention.setSideTransformer
import com.example.animateviewpager.rotate.RotateDownTransformer
import com.example.animateviewpager.rotate.RotateUpTransformer
import com.example.animateviewpager.zoom.ZoomInTransformer
import com.example.animateviewpager.zoom.ZoomOutTransformer
import com.example.librarytester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = CarouselAdapter(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            cubeoutViewPager.adapter = adapter
            cubeoutViewPager.setPageTransformer(CubeOutTransformer())

            cubeinViewpager.adapter = adapter
            cubeinViewpager.setPageTransformer(CubeInTransformer())

            rotateupViewpager.adapter = adapter
            rotateupViewpager.setPageTransformer(RotateUpTransformer())

            rotatedownViewpager.adapter = adapter
            rotatedownViewpager.setPageTransformer(RotateDownTransformer())

            zoominViewpager.adapter = adapter
            zoominViewpager.setPageTransformer(ZoomInTransformer())

            zoomoutViewpager.adapter = adapter
            zoomoutViewpager.setPageTransformer(ZoomOutTransformer())

            depthpageViewpager.adapter = adapter
            depthpageViewpager.setPageTransformer(DepthPageTransformer())

            backgroundToForegroundViewpager.adapter = adapter
            backgroundToForegroundViewpager.setPageTransformer(BackgroundToForegroundTransformer())

            seeBothSideViewpager.adapter = adapter
            seeBothSideViewpager.setSideTransformer(this@MainActivity, true, R.dimen.viewpager_next_item_visible, R.dimen.viewpager_current_item_horizontal_margin, R.dimen.viewpager_current_item_horizontal_margin)

            seeOneSideViewpager.adapter = adapter
            seeOneSideViewpager.setSideTransformer(this@MainActivity, false, R.dimen.viewpager_next_item_visible, R.dimen.viewpager_current_item_horizontal_margin, R.dimen.viewpager_current_item_horizontal_margin)

            seeOneSideViewpagerMore.adapter = adapter
            seeOneSideViewpagerMore.setSeeOneSideTransformer(this@MainActivity, R.dimen.viewpager_next_item_visible, R.dimen.viewpager_current_item_horizontal_margin, R.dimen.viewpager_current_item_horizontal_margin)

            carmediaTypeViewPager.adapter = CarouselAdapters(this@MainActivity)
            carmediaTypeViewPager.setCarMediaTransformer()
        }

    }
}