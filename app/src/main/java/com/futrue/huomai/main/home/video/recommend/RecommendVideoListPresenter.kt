package com.futrue.huomai.main.home.video.recommend

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class RecommendVideoListPresenter @Inject constructor(
    v: RecommendVideoListFragment,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<RecommendVideoListFragment>(v, apiServer, userInfo) {
}

