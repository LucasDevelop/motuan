package com.futrue.huomai.main.message.commentlist

import com.futrue.huomai.mvp.BasePresenter
import com.futrue.huomai.data.ApiServer
import javax.inject.Inject

class CommentListPresenter @Inject constructor(v: CommentListActivity, apiServer: ApiServer) :
    BasePresenter<CommentListActivity>(v, apiServer) {
}

