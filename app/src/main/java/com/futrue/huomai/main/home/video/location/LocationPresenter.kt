package com.futrue.huomai.main.home.video.location

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class LocationPresenter @Inject constructor(
    v: LocationActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<LocationActivity>(v, apiServer, userInfo) {
}

