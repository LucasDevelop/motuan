package com.futrue.huomai.main.look.write.selectlabel

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SelectLabelPresenter @Inject constructor(v: SelectLabelActivity, apiServer: ApiServer) :
    BasePresenter<SelectLabelActivity>(v, apiServer) {
}

