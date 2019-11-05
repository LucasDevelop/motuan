package com.futrue.frame.base.fragment

import android.app.Activity
import android.os.Handler
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * 提供注入功能且无网络请求的界面
 */
abstract class BaseDaggerFragment : BaseFragment() {
    @Inject
    lateinit var mHandler: Handler

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        //如果这里运行报错，请检查fragment对应的presenter是否在构造添加的@inject注入
        AndroidSupportInjection.inject(this)
    }
}