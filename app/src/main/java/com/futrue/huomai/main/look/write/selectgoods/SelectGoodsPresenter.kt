package com.futrue.huomai.main.look.write.selectgoods

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SelectGoodsPresenter @Inject constructor(v: SelectGoodsActivity, apiServer: ApiServer) :
    BasePresenter<SelectGoodsActivity>(v, apiServer) {
}

