package com.futrue.huomai.main.look.friendlist

import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.mvp.BasePresenter
import javax.inject.Inject

class FriendListPresenter @Inject constructor(v: FriendListActivity, apiServer: ApiServer) :
    BasePresenter<FriendListActivity>(v, apiServer) {
}

