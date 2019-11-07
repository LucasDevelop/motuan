package com.futrue.huomai.main.look.recommend

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class DynamicPresenter @Inject constructor(v: DynamicFragment, apiServer: ApiServer) :
    BasePresenter<DynamicFragment>(v, apiServer) {
}

