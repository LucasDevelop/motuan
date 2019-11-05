package com.futrue.huomai.main.message.chat

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class Presenter @Inject constructor(v: ChatActivity, apiServer: ApiServer) :
    BasePresenter<ChatActivity>(v, apiServer) {
}

