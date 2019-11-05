package com.futrue.huomai.main.message.chat.groupinfo.changename

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class ChangeNamePresenter @Inject constructor(v: ChangeNameActivity, apiServer: ApiServer) :
    BasePresenter<ChangeNameActivity>(v, apiServer) {
}

