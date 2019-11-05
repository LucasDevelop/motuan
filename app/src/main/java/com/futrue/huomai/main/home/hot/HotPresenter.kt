package com.futrue.huomai.main.home.hot

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class HotPresenter @Inject constructor(v: HotFragment, apiServer: ApiServer) :
    BasePresenter<HotFragment>(v, apiServer) {
}

