package com.futrue.huomai.main.home.video

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class VideoPlayerPresenter @Inject constructor(v: VideoPlayerActivity, apiServer: ApiServer) :
    BasePresenter<VideoPlayerActivity>(v, apiServer) {
}

