package com.example.animateviewpager.base

import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

/**
 * Base transformer for all transitions.
 * Works fore both Viewpager and ViewPager2
 */
abstract class BaseTransformer : ViewPager2.PageTransformer,ViewPager.PageTransformer {
    protected open val isPagingEnabled: Boolean
        get() = false

    protected abstract fun onTransform(page: View, position: Float)

    /**
     * The place where we have to define our transition
     */
    override fun transformPage(page: View, position: Float) {
        val clampedPosition = clampPosition(position)
        onPreTransform(page, clampedPosition)
        onTransform(page, clampedPosition)
        onPostTransform(page, clampedPosition)
    }

    private fun clampPosition(position: Float): Float {
        return when {
            position < -1f -> -1f
            position > 1f -> 1f
            position.isNaN() -> 0f
            else -> position
        }
    }

    protected open fun hideOffscreenPages(): Boolean {
        return true
    }
    protected open fun onPreTransform(page: View, position: Float) {
        val width = page.width.toFloat()

        page.rotationX = 0f
        page.rotationY = 0f
        page.rotation = 0f
        page.scaleX = 1f
        page.scaleY = 1f
        page.pivotX = 0f
        page.pivotY = 0f
        page.translationY = 0f
        page.translationX = if (isPagingEnabled) 0f else -width * position

        if (hideOffscreenPages()) {
            page.alpha = if (position <= -1f || position >= 1f) 0f else 1f
            page.isEnabled = false
        } else {
            page.isEnabled = true
            page.alpha = 1f
        }
    }

    protected open fun onPostTransform(page: View, position: Float) {
        //nothing here
    }

    companion object {
        @JvmStatic
        protected fun min(value: Float, min: Float): Float {
            return if (value < min) min else value
        }
    }

}