package com.futrue.huomai.main.message.selectgroup

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SelectGroupPresenter @Inject constructor(v: SelectGroupActivity, apiServer: ApiServer) :
    BasePresenter<SelectGroupActivity>(v, apiServer) {
}

