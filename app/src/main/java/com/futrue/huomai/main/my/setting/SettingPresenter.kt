package com.futrue.huomai.main.my.setting

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SettingPresenter @Inject constructor(v: SettingActivity, apiServer: ApiServer) :
    BasePresenter<SettingActivity>(v, apiServer) {
}

