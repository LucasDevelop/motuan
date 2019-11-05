package com.futrue.huomai.main.my.praise.look

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class MyPraiseLookPresenter @Inject constructor(v: MyPraiseLookFragment, apiServer: ApiServer) :
    BasePresenter<MyPraiseLookFragment>(v, apiServer) {
}

