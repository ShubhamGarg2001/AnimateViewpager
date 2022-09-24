package com.example.animateviewpager

import android.content.Context
import android.view.View
import androidx.annotation.DimenRes


class CarMediaTransformer(
    private val context: Context, @DimenRes val nextItemVisiblePxInDp:Int, @DimenRes val currentItemHorizontalMarginPxInDp:Int
) : BaseTransformer() {

    public override val isPagingEnabled: Boolean
        get() = true

    override fun onTransform(page: View, position: Float) {
        val pageTranslationX =  context.resources.getDimension(nextItemVisiblePxInDp) + context.resources.getDimension(currentItemHorizontalMarginPxInDp)
        page.translationX = -pageTranslationX * position
        page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        page.alpha = 0.25f + (1 - kotlin.math.abs(position))
    }

}