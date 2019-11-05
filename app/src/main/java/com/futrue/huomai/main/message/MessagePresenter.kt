package com.futrue.huomai.main.message

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class MessagePresenter @Inject constructor(v: MessageFragment, apiServer: ApiServer) :
    BasePresenter<MessageFragment>(v, apiServer) {
}

