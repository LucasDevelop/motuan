package com.futrue.huomai.main.my

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class MyPresenter @Inject constructor(v: MyFragment, apiServer: ApiServer) :
    BasePresenter<MyFragment>(v, apiServer) {
}

