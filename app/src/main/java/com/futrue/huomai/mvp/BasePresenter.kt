package com.futrue.huomai.mvp

import com.futrue.huomai.data.ApiServer
import com.futrue.frame.mvp.presenter.IPresenter
import com.futrue.frame.mvp.view.IRequestView

/**
 * @package     com.zhongde.tinglishi.base.mvp
 * @author      lucas
 * @date        2018/12/5
 * @des
 */
abstract class BasePresenter<out V : IRequestView>(v: V, var apiServer: ApiServer) : IPresenter<V>(v)