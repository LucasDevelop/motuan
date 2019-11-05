package com.futrue.huomai.main.message.priselist

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class PriseListPresenter @Inject constructor(v: PriseListActivity, apiServer: ApiServer) :
    BasePresenter<PriseListActivity>(v, apiServer) {
}

