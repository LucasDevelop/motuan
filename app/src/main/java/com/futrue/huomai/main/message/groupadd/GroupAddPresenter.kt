package com.futrue.huomai.main.message.groupadd

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class GroupAddPresenter @Inject constructor(v: GroupAddActivity, apiServer: ApiServer) :
    BasePresenter<GroupAddActivity>(v, apiServer) {
}

