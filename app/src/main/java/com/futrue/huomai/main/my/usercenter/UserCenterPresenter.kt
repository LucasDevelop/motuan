package com.futrue.huomai.main.my.usercenter

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class UserCenterPresenter @Inject constructor(v: UserCenterActivity, apiServer: ApiServer) :
    BasePresenter<UserCenterActivity>(v, apiServer) {
}

