package com.futrue.huomai.main.look.write.selectlocation

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class SelectLocationPresenter @Inject constructor(v: SelectLocationActivity, apiServer: ApiServer) :
    BasePresenter<SelectLocationActivity>(v, apiServer) {
}

