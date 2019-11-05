package com.futrue.huomai.main.home.personaldetails.personallook

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class PersonalLookPresenter @Inject constructor(v: PersonalLookFragment, apiServer: ApiServer) :
    BasePresenter<PersonalLookFragment>(v, apiServer) {
}

