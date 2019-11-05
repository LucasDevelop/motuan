package com.futrue.huomai.main.my.praise.video

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class MyPraiseVideoPresenter @Inject constructor(v: MyPraiseVideoFragment, apiServer: ApiServer) :
    BasePresenter<MyPraiseVideoFragment>(v, apiServer) {
}

