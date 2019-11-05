package com.futrue.huomai.main.home.shop.dynamic

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class ShopDynamicPresenter @Inject constructor(v: ShopDynamicActivity, apiServer: ApiServer) :
    BasePresenter<ShopDynamicActivity>(v, apiServer) {
}

