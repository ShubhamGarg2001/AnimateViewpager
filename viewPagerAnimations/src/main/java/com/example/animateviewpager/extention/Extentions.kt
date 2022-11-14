package com.example.animateviewpager.extention
import android.content.Context
import android.view.View
import androidx.annotation.DimenRes
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.animateviewpager.itemDecoration.HorizontalMarginItemDecoration
import kotlin.math.abs

fun ViewPager2.setSideTransformer(
    context: Context,
    bothSide: Boolean,
    @DimenRes nextItemVisiblePxInDp: Int,
    @DimenRes currentItemHorizontalMarginPxInDp: Int,
    @DimenRes viewPagerItemHorizontalMarginInDp: Int
) {
    if (bothSide)
        this.offscreenPageLimit = 1
    val nextItemVisiblePx =
        context.resources.getDimension(nextItemVisiblePxInDp)
    val currentItemHorizontalMarginPx =
        context.resources.getDimension(currentItemHorizontalMarginPxInDp)
    val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
    val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
        page.translationX = -pageTranslationX * position
        page.scaleY = 1 - (0.25f * abs(position))
        page.alpha = 0.25f + (1 - abs(position))
    }
    this.setPageTransformer(pageTransformer)
    val itemDecoration = HorizontalMarginItemDecoration(
        context,
        viewPagerItemHorizontalMarginInDp
    )
    this.addItemDecoration(itemDecoration)

}
fun ViewPager2.setCarMediaTransformer(
) {
    clipToPadding = false
    clipChildren = false
    setPadding(300, 0, 300, 0)
    offscreenPageLimit = 3
    val compositePageTransformer = CompositePageTransformer()
    compositePageTransformer.addTransformer(MarginPageTransformer(4))
    compositePageTransformer.addTransformer { page, position ->
        val r = 1.minus(abs(position))
        page.scaleY = 0.85f + r * 0.15f
        page.alpha = 0.25f + (1 - abs(position))
    }
    setPageTransformer(compositePageTransformer)

}
fun ViewPager2.setSeeOneSideTransformer(
    context: Context,
    @DimenRes nextItemVisiblePxInDp: Int,
    @DimenRes currentItemHorizontalMarginPxInDp: Int,
    @DimenRes viewPagerItemHorizontalMarginInDp: Int
) {
    this.offscreenPageLimit = 1
    val nextItemVisiblePx =
        context.resources.getDimension(nextItemVisiblePxInDp)
    val currentItemHorizontalMarginPx =
        context.resources.getDimension(currentItemHorizontalMarginPxInDp)
    val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
    val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
        page.translationX = -pageTranslationX * (position + 1)
        page.scaleY = 1 - (0.15f * abs(position))
        page.alpha = 0.25f + (1 - abs(position))
    }
    this.setPageTransformer(pageTransformer)
    val itemDecoration = HorizontalMarginItemDecoration(
        context,
        viewPagerItemHorizontalMarginInDp
    )
    this.addItemDecoration(itemDecoration)

}