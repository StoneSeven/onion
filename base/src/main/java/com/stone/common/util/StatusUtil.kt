package com.stone.common.util

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager


/**
 *   created by stone
 *   on 2020/7/13
 */
object StatusUtil {

    /**
     * 修改状态栏颜色，支持4.4以上版本
     *
     * @param activity
     * @param colorId
     */
    fun setStatusBarColor(activity: Activity, colorId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = activity.resources.getColor(colorId)
        }
    }

    /**
     * 修改状态栏文字颜色，这里小米，魅族区别对待。
     */
    fun setLightStatusBar(activity: Activity, dark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            when (RomUtils.getLightStatusBarAvailableRomType()) {
                RomUtils.AvailableRomType.MIUI -> statusBarMi(activity, dark)
                RomUtils.AvailableRomType.ANDROID_NATIVE -> setAndroidNativeLightStatusBar(
                    activity,
                    dark
                )
            }
        }
    }


    private fun statusBarMi(activity: Activity, dark: Boolean): Boolean {
        var result = false
        val window: Window? = activity.window
        if (window != null) {
            val clazz: Class<*> = window::class.java
            try {
                var darkModeFlag = 0
                val layoutParams =
                    Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                darkModeFlag = field.getInt(layoutParams)
                val extraFlagField = clazz.getMethod(
                    "setExtraFlags",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType
                )
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag) //状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag) //清除黑色字体
                }
                result = true
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && RomUtils.isMiUIV7OrAbove()) {
                    //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
                    if (dark) {
                        activity.window.decorView.systemUiVisibility =
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    } else {
                        activity.window.decorView.systemUiVisibility =
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    }
                }
            } catch (e: Exception) {
            }
        }
        return result
    }


    private fun setAndroidNativeLightStatusBar(
        activity: Activity,
        dark: Boolean
    ) {
        val decor: View = activity.window.decorView
        if (dark) {
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}
