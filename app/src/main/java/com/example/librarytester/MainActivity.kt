package com.example.librarytester

import SetTransformer.Companion.setSideTransformer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.animateviewpager.*
import com.example.librarytester.SetTransformer.Companion.setSeeBothSideTransformer
import com.example.librarytester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter=CarouselAdapter(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cubeoutViewPager.adapter=adapter
        binding.cubeoutViewPager.setPageTransformer(CubeOutTransformer())

        binding.cubeinViewpager.adapter=adapter
        binding.cubeinViewpager.setPageTransformer(CubeInTransformer())

        binding.rotateupViewpager.adapter=adapter
        binding.rotateupViewpager.setPageTransformer(RotateUpTransformer())

        binding.rotatedownViewpager.adapter=adapter
        binding.rotatedownViewpager.setPageTransformer(RotateDownTransformer())

        binding.zoominViewpager.adapter=adapter
        binding.zoominViewpager.setPageTransformer(ZoomInTransformer())

        binding.zoomoutViewpager.adapter=adapter
        binding.zoomoutViewpager.setPageTransformer(ZoomOutTransformer())

        binding.depthpageViewpager.adapter=adapter
        binding.depthpageViewpager.setPageTransformer(DepthPageTransformer())

        binding.backgroundToForegroundViewpager.adapter=adapter
        binding.backgroundToForegroundViewpager.setPageTransformer(BackgroundToForegroundTransformer())

        binding.seeBothSideViewpager.adapter=adapter
        binding.seeBothSideViewpager.setSideTransformer(
            this,
            true,
            R.dimen.viewpager_next_item_visible,
            R.dimen.viewpager_current_item_horizontal_margin,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.seeOneSideViewpager.adapter=adapter
        binding.seeOneSideViewpager.setSideTransformer(
            this,
            false,
            R.dimen.viewpager_next_item_visible,
            R.dimen.viewpager_current_item_horizontal_margin,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.seeOneSideViewpagerMore.adapter=adapter
        binding.seeOneSideViewpagerMore.setSeeBothSideTransformer(
            this,
            R.dimen.viewpager_next_item_visible,
            R.dimen.viewpager_current_item_horizontal_margin,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible_two)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin_two)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin_two
        )
        binding.carmediaTypeViewPager.apply {
            clipToPadding = false
            clipChildren = false
            setPadding(300, 0, 300, 0)
            offscreenPageLimit = 3
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(4))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1.minus(Math.abs(position))
            page.scaleY = 0.85f + r * 0.15f
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        binding.carmediaTypeViewPager.setPageTransformer(compositePageTransformer)

       binding.carmediaTypeViewPager.adapter = CarouselAdapters(this)



    }
}