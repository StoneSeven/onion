package com.stone.common.util

import android.os.Build
import android.os.Environment
import android.text.TextUtils
import java.io.File
import java.io.FileInputStream
import java.util.*


/**
 *   created by stone
 *   on 2020/7/13
 */
object RomUtils {

    internal object AvailableRomType {
        const val MIUI = 1
        const val ANDROID_NATIVE = 3
        const val NA = 4
    }

    fun getLightStatusBarAvailableRomType(): Int {
        //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错
        if (isMiUIV7OrAbove()) {
            return AvailableRomType.ANDROID_NATIVE
        }
        if (isMiUIV6OrAbove()) {
            return AvailableRomType.MIUI
        }
        return if (isAndroidMOrAbove()) {
            AvailableRomType.ANDROID_NATIVE
        } else AvailableRomType.NA
    }

    //Android Api 23以上
    private fun isAndroidMOrAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    private const val KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code"

    private fun isMiUIV6OrAbove(): Boolean {
        return try {
            val properties = Properties()
            properties.load(FileInputStream(File(Environment.getRootDirectory(), "build.prop")))
            val uiCode: String = properties.getProperty(KEY_MIUI_VERSION_CODE, null)
            if (uiCode != null) {
                val code = uiCode.toInt()
                code >= 4
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    fun isMiUIV7OrAbove(): Boolean {
        return try {
            val properties = Properties()
            properties.load(FileInputStream(File(Environment.getRootDirectory(), "build.prop")))
            val uiCode: String = properties.getProperty(KEY_MIUI_VERSION_CODE, null)
            if (uiCode != null) {
                val code = uiCode.toInt()
                code >= 5
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }
}