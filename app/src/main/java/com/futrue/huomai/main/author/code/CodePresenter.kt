package com.futrue.huomai.main.author.code

import com.futrue.huomai.mvp.BaseUserPresenter
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.UserInfo
import javax.inject.Inject

class CodePresenter @Inject constructor(v: CodeActivity, apiServer: ApiServer, userInfo: UserInfo) :
    BaseUserPresenter<CodeActivity>(v, apiServer, userInfo) {
}

