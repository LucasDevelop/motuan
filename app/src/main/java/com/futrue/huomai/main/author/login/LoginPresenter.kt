package com.futrue.huomai.main.author.login

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    v: LoginActivity,
    apiServer: ApiServer,
    userInfo: UserInfo
) : BaseUserPresenter<LoginActivity>(v, apiServer, userInfo) {
}

