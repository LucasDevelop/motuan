package com.futrue.huomai.main.my.secret.look

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SecretLookPresenter @Inject constructor(v: SecretLookFragment, apiServer: ApiServer) :
    BasePresenter<SecretLookFragment>(v, apiServer) {
}

