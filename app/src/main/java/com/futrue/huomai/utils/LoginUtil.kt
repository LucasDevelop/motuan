package com.futrue.huomai.utils

import android.app.Activity
import com.futrue.huomai.App


/**
 * @创建者     shen
 * @创建时间   2019/4/17 10:58
 * @描述
 */
object LoginUtil {
    /**
     * 是否登陆
     * @return true:已经登录过  false：未登录，跳转登录页面
     */
    fun isLogin(activity: Activity): Boolean {
        val login = App.instance.userInfo.isLogin()
        if (!login) {
//            WechatLoginActivity.launch(activity)
        }
        return login
    }

}