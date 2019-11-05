package com.futrue.huomai.main.home.search

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class SearchPresenter @Inject constructor(v: SearchActivity, apiServer: ApiServer) :
    BasePresenter<SearchActivity>(v, apiServer) {
}

