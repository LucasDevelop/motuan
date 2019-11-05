package com.futrue.huomai.main


import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.main.MainActivity
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(v: MainActivity, apiServer: ApiServer) : BasePresenter<MainActivity>(v, apiServer) {


}

