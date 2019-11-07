package com.futrue.huomai.main.home.video.videolist

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class VideoListPresenter @Inject constructor(
    v: VideoListActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<VideoListActivity>(v, apiServer, userInfo) {
}

