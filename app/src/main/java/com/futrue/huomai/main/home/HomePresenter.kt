package com.futrue.huomai.main.home

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class HomePresenter @Inject constructor(v: HomeFragment, apiServer: ApiServer) :
    BasePresenter<HomeFragment>(v, apiServer) {
}

