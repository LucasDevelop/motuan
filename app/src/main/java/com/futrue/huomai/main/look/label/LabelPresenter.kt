package com.futrue.huomai.main.look.label

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class LabelPresenter @Inject constructor(v: LabelActivity, apiServer: ApiServer) :
    BasePresenter<LabelActivity>(v, apiServer) {
}

