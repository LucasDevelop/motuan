package com.futrue.huomai.main.look.detail.praiselist

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class PraiseListPresenter @Inject constructor(v: PraiseListActivity, apiServer: ApiServer) :
    BasePresenter<PraiseListActivity>(v, apiServer) {
}

