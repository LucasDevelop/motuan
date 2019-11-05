package com.futrue.huomai.main.home.shop

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class ShopPresenter @Inject constructor(v: ShopActivity, apiServer: ApiServer) :
    BasePresenter<ShopActivity>(v, apiServer) {
}

