README.md



# AnimateViewPager

This library consists of all the viewpager animations that can be set with viewpager.





## List Of Animations:

    - BackgroundToForegroundTransformer
    - CubeInTransformer
    - CubeOutTransformer
    - DepthPageTransformer
    - RotateDownTransformer
    - RotateUpTransformer
    - ZoomInTransformer
    - ZoomOutTransformer





## To use this libraray


Add libarary dependency to the app level build.gradle file.

```bash
  dependencies {
    implementation 'com.github.ShubhamGarg2001:AnimateViewpager:<version>'
}
```
Add the following to the settings.gradle file..

```bash
  dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```




# Sample Example
    yourViewPager.setPageTransformer(DepthPageTransformer())

    yourViewPager.setSideTransformer(
            this,
            true,
            R.dimen.viewpager_next_item_visible,
            R.dimen.viewpager_current_item_horizontal_margin,
            R.dimen.viewpager_current_item_horizontal_margin
        )


