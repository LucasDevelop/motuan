package com.futrue.huomai.main.look.write

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class WritePresenter @Inject constructor(v: WriteActivity, apiServer: ApiServer) :
    BasePresenter<WriteActivity>(v, apiServer) {
}

