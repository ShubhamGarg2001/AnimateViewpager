package com.example.animateviewpager.cube

import android.view.View
import com.example.animateviewpager.base.BaseTransformer

class CubeOutTransformer(
    private val distanceMultiplier: Int = 20
) : BaseTransformer() {

    public override val isPagingEnabled: Boolean
        get() = true

    override fun onTransform(page: View, position: Float) {
        page.cameraDistance = (page.width * distanceMultiplier).toFloat()
        page.pivotX = if (position < 0f) page.width.toFloat() else 0f
        page.pivotY = page.height * 0.5f
        page.rotationY = 90f * position
    }

}