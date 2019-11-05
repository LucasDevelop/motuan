package com.futrue.huomai.main.look

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class LookPresenter @Inject constructor(v: LookFragment, apiServer: ApiServer) :
    BasePresenter<LookFragment>(v, apiServer) {
}

