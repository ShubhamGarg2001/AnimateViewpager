import android.content.Context
import android.view.View
import androidx.annotation.DimenRes
import androidx.viewpager2.widget.ViewPager2
import com.example.animateviewpager.HorizontalMarginItemDecoration

class SetTransformer {
    companion object {
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
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
                page.alpha = 0.25f + (1 - kotlin.math.abs(position))
            }
            this.setPageTransformer(pageTransformer)
            val itemDecoration = HorizontalMarginItemDecoration(
                context,
                viewPagerItemHorizontalMarginInDp
            )
            this.addItemDecoration(itemDecoration)

        }
    }
}