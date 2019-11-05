package com.futrue.huomai.main.my.usercenter.settext

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SetTextPresenter @Inject constructor(v: SetTextActivity, apiServer: ApiServer) :
    BasePresenter<SetTextActivity>(v, apiServer) {
}

