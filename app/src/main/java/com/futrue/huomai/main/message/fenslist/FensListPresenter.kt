package com.futrue.huomai.main.message.fenslist

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class FensListPresenter @Inject constructor(v: FensListActivity, apiServer: ApiServer) :
    BasePresenter<FensListActivity>(v, apiServer) {
}

