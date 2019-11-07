package com.futrue.huomai.main.message.activitymsg

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class ActivityMsgPresenter @Inject constructor(
    v: ActivityMsgActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<ActivityMsgActivity>(v, apiServer, userInfo) {
}

