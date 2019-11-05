package com.futrue.huomai.main.my.usercenter.intro

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class IntroPresenter @Inject constructor(v: IntroActivity, apiServer: ApiServer) :
    BasePresenter<IntroActivity>(v, apiServer) {
}

