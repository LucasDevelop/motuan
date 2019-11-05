package com.futrue.huomai.main.look.detail

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class LookDetailPresenter @Inject constructor(v: LookDetailActivity, apiServer: ApiServer) :
    BasePresenter<LookDetailActivity>(v, apiServer) {
}

