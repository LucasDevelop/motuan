package com.futrue.huomai.main.my.findfirend

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class FindFirendPresenter @Inject constructor(v: FindFirendActivity, apiServer: ApiServer) :
    BasePresenter<FindFirendActivity>(v, apiServer) {
}

