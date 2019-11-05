package com.futrue.huomai.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

/**
 * @package    EventRecyclerView.kt
 * @author     luan
 * @date       2019-11-05
 * @des        处理事件
 */
class EventRecyclerView :RecyclerView{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("lucas","dispatchTouchEvent")
        parent.requestDisallowInterceptTouchEvent(true)//解除父控件的限制
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        Log.d("lucas","onInterceptTouchEvent")
        return super.onInterceptTouchEvent(e)
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        Log.d("lucas","onTouchEvent")
        return super.onTouchEvent(e)
    }
}
