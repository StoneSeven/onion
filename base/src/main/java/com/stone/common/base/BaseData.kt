package com.stone.common.base


/**
 *   created by stone
 *   on 2020/7/17
 */
data class BaseData<T> (

    var mData: T,

    val code: Int,

    val msg: String
)