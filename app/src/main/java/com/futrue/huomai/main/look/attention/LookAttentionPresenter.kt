package com.futrue.huomai.main.look.attention

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class LookAttentionPresenter @Inject constructor(v: LookAttentionFragment, apiServer: ApiServer) :
    BasePresenter<LookAttentionFragment>(v, apiServer) {
}

