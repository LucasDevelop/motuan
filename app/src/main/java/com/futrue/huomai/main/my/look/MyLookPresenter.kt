package com.futrue.huomai.main.my.look

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class MyLookPresenter @Inject constructor(v: MyLookFragment, apiServer: ApiServer) :
    BasePresenter<MyLookFragment>(v, apiServer) {
}

