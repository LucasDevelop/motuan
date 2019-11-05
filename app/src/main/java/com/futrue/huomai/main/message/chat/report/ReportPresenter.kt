package com.futrue.huomai.main.message.chat.report

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class ReportPresenter @Inject constructor(v: ReportActivity, apiServer: ApiServer) :
    BasePresenter<ReportActivity>(v, apiServer) {
}

