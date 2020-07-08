package com.stone.onion.startup

import android.content.Context
import androidx.startup.Initializer
import com.stone.base.util.LogUtil
import java.util.*

class LibraryInitial : Initializer<LibraryInitial> {

    override fun create(context: Context): LibraryInitial {
        LogUtil.i("create")
        return LibraryInitial()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return  mutableListOf()
    }
}