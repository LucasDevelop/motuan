package com.futrue.huomai.main.home.personaldetails.personalvideo

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class PersonalVideoPresenter @Inject constructor(v: PersonalVideoFragment, apiServer: ApiServer) :
    BasePresenter<PersonalVideoFragment>(v, apiServer) {
}

