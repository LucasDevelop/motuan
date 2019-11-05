package com.futrue.huomai.main.message.prviateadd

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class PrviateAddPresenter @Inject constructor(v: PrviateAddActivity, apiServer: ApiServer) :
    BasePresenter<PrviateAddActivity>(v, apiServer) {
}

