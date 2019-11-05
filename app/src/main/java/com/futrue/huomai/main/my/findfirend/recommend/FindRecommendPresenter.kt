package com.futrue.huomai.main.my.findfirend.recommend

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class FindRecommendPresenter @Inject constructor(v: FindRecommendFragment, apiServer: ApiServer) :
    BasePresenter<FindRecommendFragment>(v, apiServer) {
}

