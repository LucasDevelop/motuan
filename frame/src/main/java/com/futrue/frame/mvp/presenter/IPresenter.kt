package com.futrue.frame.mvp.presenter

import android.app.Activity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.mvp.view.IRequestView

/**
 * 控制器
 */
abstract class IPresenter<out V : IRequestView>(val v: V) {

    fun request(init: BaseModel.() -> Unit) {
        //每个请求都使用新的BaseModel保证请求不冲突
        BaseModel(v).request(init)

    }

    //关闭页面
    fun finish() {
        (v as? Activity)?.finish()
    }
}