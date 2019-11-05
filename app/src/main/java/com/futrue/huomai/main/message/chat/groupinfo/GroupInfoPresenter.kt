package com.futrue.huomai.main.message.chat.groupinfo

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class GroupInfoPresenter @Inject constructor(v: GroupInfoActivity, apiServer: ApiServer) :
    BasePresenter<GroupInfoActivity>(v, apiServer) {
}

