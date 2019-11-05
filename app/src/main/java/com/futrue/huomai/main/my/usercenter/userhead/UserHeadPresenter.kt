package com.futrue.huomai.main.my.usercenter.userhead

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class UserHeadPresenter @Inject constructor(v: UserHeadActivity, apiServer: ApiServer) :
    BasePresenter<UserHeadActivity>(v, apiServer) {
}

