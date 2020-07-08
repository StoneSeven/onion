package com.stone.base.util

import android.util.Log
import java.util.*

/**
 *   created by stone
 *   on 2020/7/8
 */
object LogUtil {

    private var defaultTag = "LogStone"
    private const val MIN_STACK_OFFSET = 3
    private const val D = Log.DEBUG
    private const val I = Log.INFO
    private const val E = Log.ERROR
    private const val MAX_LEN = 1000

    fun i(msg: String) {
        processMsgBody(msg, I, defaultTag)
    }

    fun d(msg: String) {
        processMsgBody(msg, D, defaultTag)
    }

    fun e(msg: String) {
        processMsgBody(msg, E, defaultTag)
    }

    private fun printLog(flag: Int, tag: String, msg: String = processTagAndHead()) {
        Log.println(flag, tag, msg)
    }

    private fun processTagAndHead(): String {
        val elements = Thread.currentThread().stackTrace
        val offset = getStackOffset(elements)
        val targetElement = elements[offset]
        val head = Formatter().format("%s [%s(%s:%d)]",
            "Thread: " + Thread.currentThread().name,
            targetElement.methodName,
            targetElement.fileName,
            targetElement.lineNumber)
        return head.toString()
    }

    private fun processMsgBody(msg: String, flag: Int, tag: String = defaultTag) {
        printLog(flag, tag)
        val lineCount = msg.length / MAX_LEN
        if (lineCount == 0) {
            printLog(flag, tag, msg)
        } else {
            var index = 0
            var i = 0
            while (true) {
                printLog(flag, tag, msg.substring(index, index + MAX_LEN))
                index += MAX_LEN
                if ((++i) >= lineCount)
                    break
            }
        }
    }

    private fun getStackOffset(trace: Array<StackTraceElement>): Int {
        var i = MIN_STACK_OFFSET
        while (i < trace.size) {
            val e = trace[i]
            val name = e.className
            if (name != LogUtil::class.java.name) {
                return i
            }
            i++
        }
        return 2
    }
}
