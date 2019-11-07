package com.futrue.huomai.main.home.video.topic.byvideos

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class TopicByVideoPresenter @Inject constructor(
    v: TopicByVideoFragment,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<TopicByVideoFragment>(v, apiServer, userInfo) {
}

