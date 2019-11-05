package com.futrue.huomai.main.message.prviatelist

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class PrviateListPresenter @Inject constructor(v: PrviateListActivity, apiServer: ApiServer) :
    BasePresenter<PrviateListActivity>(v, apiServer) {
}

