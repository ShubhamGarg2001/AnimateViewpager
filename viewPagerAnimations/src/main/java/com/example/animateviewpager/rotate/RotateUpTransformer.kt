package com.example.animateviewpager.rotate

import android.view.View
import com.example.animateviewpager.base.BaseTransformer

class RotateUpTransformer : BaseTransformer() {

    override val isPagingEnabled: Boolean
        get() = true

    override fun onTransform(page: View, position: Float) {
        val width = page.width.toFloat()
        val rotation = ROT_MOD * position

        page.pivotX = width * 0.5f
        page.pivotY = 0f
        page.translationX = 0f
        page.rotation = rotation
    }

    companion object {
        private const val ROT_MOD = -15f
    }

}