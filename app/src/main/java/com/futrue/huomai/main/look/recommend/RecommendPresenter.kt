package com.futrue.huomai.main.look.recommend

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class RecommendPresenter @Inject constructor(v: RecommendFragment, apiServer: ApiServer) :
    BasePresenter<RecommendFragment>(v, apiServer) {
}

