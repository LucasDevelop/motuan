package com.futrue.huomai.main.home.video.topic

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class TopicInfoPresenter @Inject constructor(
    v: TopicInfoActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<TopicInfoActivity>(v, apiServer, userInfo) {
}

