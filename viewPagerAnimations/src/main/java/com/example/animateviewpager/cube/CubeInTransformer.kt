package com.example.animateviewpager.cube

import android.view.View
import com.example.animateviewpager.base.BaseTransformer

open class CubeInTransformer : BaseTransformer() {

    public override val isPagingEnabled: Boolean
        get() = true

    override fun onTransform(page: View, position: Float) {
        page.pivotX = if (position > 0) 0f else page.width.toFloat()
        page.pivotY = 0f
        page.rotationY = -90f * position
    }

}