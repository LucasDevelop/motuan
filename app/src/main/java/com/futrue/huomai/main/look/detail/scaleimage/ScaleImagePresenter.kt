package com.futrue.huomai.main.look.detail.scaleimage

import com.futrue.huomai.UserInfo
import com.futrue.huomai.data.ApiServer
import com.futrue.huomai.main.look.detail.scaleimage.ScaleImageActivity
import com.futrue.huomai.mvp.BaseUserPresenter
import javax.inject.Inject

class ScaleImagePresenter @Inject constructor(v: ScaleImageActivity, apiServer: ApiServer, userInfo: UserInfo) :
    BaseUserPresenter<ScaleImageActivity>(v, apiServer, userInfo) {
}

