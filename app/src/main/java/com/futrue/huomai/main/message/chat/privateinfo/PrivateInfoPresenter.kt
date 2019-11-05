package com.futrue.huomai.main.message.chat.privateinfo

import com.futrue.huomai.UserInfo
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BaseUserPresenter
import javax.inject.Inject

class PrivateInfoPresenter @Inject constructor(v: PrivateInfoActivity, apiServer: ApiServer, userInfo: UserInfo) :
    BaseUserPresenter<PrivateInfoActivity>(v, apiServer, userInfo) {
}

