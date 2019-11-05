package com.futrue.huomai.main.home.attention


import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class AttentionPresenter @Inject constructor(v: AttentionFragment, apiServer: ApiServer) :
    BasePresenter<AttentionFragment>(v, apiServer) {
}

