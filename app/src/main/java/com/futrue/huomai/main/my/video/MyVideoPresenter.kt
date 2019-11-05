package com.futrue.huomai.main.my.video

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class MyVideoPresenter @Inject constructor(v: MyVideoFragment, apiServer: ApiServer) :
    BasePresenter<MyVideoFragment>(v, apiServer) {
}

