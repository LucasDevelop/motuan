package com.futrue.frame.base.dialog

import android.app.Activity
import android.app.Dialog
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.os.Bundle
import android.support.annotation.StyleRes
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import com.futrue.frame.R
import com.futrue.frame.helper.CommentHelper

/**
 * @package     com.heid.frame.base
 * @author      lucas
 * @date        2018/11/24
 * @des         dialog基类
 */
abstract class BaseDialog(context: Context, @StyleRes themeResId: Int= R.style.frame_Custom_Progress) : Dialog(context,themeResId), CommentHelper {
    lateinit var rootView: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindLifeCycle(context)
        baseInit()
        initView()
    }

    private fun baseInit() {
        if (getLayoutID() != null) {
            rootView = LayoutInflater.from(context).inflate(getLayoutID()!!, null) as ViewGroup
            setContentView(rootView)
        }
        //居中
        window?.attributes?.apply {
            gravity = Gravity.CENTER
            //宽度包裹
            width = resetWidth()
            height = resetHeight()
        }

    }

    abstract fun initView()

    abstract fun getLayoutID(): Int?

    open fun resetWidth() = WindowManager.LayoutParams.WRAP_CONTENT
    open fun resetHeight() = WindowManager.LayoutParams.WRAP_CONTENT
    open fun resetGravity() = Gravity.CENTER

    override fun show() {
        //界面关闭不再显示dialog避免空指针
        if (context is Activity && (context as Activity).isDestroyed)
            return
        super.show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        if (isShowing) dismiss()
        unbindLifeCycle(context)
    }
}