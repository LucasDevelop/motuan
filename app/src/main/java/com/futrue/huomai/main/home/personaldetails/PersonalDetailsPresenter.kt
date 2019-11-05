package com.futrue.huomai.main.home.personaldetails

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class PersonalDetailsPresenter @Inject constructor(
    v: PersonalDetailsActivity,
    apiServer: ApiServer
) : BasePresenter<PersonalDetailsActivity>(v, apiServer) {
}

