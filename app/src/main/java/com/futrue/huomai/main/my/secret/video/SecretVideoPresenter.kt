package com.futrue.huomai.main.my.secret.video

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SecretVideoPresenter @Inject constructor(v: SecretVideoFragment, apiServer: ApiServer) :
    BasePresenter<SecretVideoFragment>(v, apiServer) {
}

