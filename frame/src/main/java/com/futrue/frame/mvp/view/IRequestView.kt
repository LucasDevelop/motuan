package com.futrue.frame.mvp.view

import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean

/**
 * 请求视图
 */
interface IRequestView :IView{
    //请求成功
    fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any)

    //请求失败
    fun requestFail(bean: IBean, code: Int, requestTag: Any)

    //请求错误
    fun requestError(msg: String, exception: Throwable?, requestTag: Any)

    //token 过期
    fun tokenOverdue()

    //显示原有布局
    fun refreshView()

    //显示加载中布局
    fun showLoadingView()

    //显示空布局
    fun showEmptyView()

    //显示网络错误布局
    fun showNetErrorView()

    //显示服务器错误布局
    fun showServerErrorView(hint:String)

}