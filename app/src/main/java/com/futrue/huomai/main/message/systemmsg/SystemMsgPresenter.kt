package com.futrue.huomai.main.message.systemmsg

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class SystemMsgPresenter @Inject constructor(
    v: SystemMsgActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<SystemMsgActivity>(v, apiServer, userInfo) {
}

