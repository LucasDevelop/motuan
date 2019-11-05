package com.bananafish.coupon.widget

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.TextView

/**
 * @package     com.goume.heyding.widget
 * @author      lucas
 * @date        2018/9/25
 * @des    倒计时
 */
class TimingTextView(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
    //时长
    open var currentTime: Long = 60
    //倒计时结束回调
    var onStopTime: (TimingTextView) -> Unit = {}
    //倒计时开始回调
    var onStartTime: (TimingTextView) -> Unit = {}
    val timeHandler = Handler()
    //计时任务
    val task = Task()
    //控件文本前缀
    var prefix = "重新发送("
    //后缀
    var suffix = "s)"
    //运行状态
    var isRunning = false

    inner class Task : Runnable {
        override fun run() {
            if (currentTime <= 0L) {
                //计时结束
                onStopTime(this@TimingTextView)
                isRunning = false
                return
            }
            text = StringBuilder().append(prefix).append(currentTime).append(suffix).toString()

            currentTime--
            //每间隔一秒更新文本
            timeHandler.postDelayed(this, 1000)
        }

        //开始计时
        fun start() {
            currentTime = 60
            onStartTime(this@TimingTextView)
            isRunning = true
            timeHandler.post(this)
        }

        //结束
        fun stop() {
            isRunning = false
            timeHandler.removeCallbacks(this)
        }
    }
}