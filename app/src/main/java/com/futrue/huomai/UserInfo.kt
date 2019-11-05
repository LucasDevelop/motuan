package com.futrue.huomai

import android.text.TextUtils
import com.blankj.utilcode.util.SPUtils
import com.google.gson.Gson


/**
 * @package     com.heid.frame20181119
 * @author      lucas
 * @date        2018/11/22
 * @des         用户信息
 */

class UserInfo constructor(var gson: Gson) {

    private val KEY_USER = "userInfo"
    private val KEY_TOKEN = "token"
    private val KEY_ID = "id"


    var userBean = UserBean()

    var token: String = ""
    var id: String = ""


    //刷新user
    fun refreshUserBean(userBean: UserBean) {
        this.userBean = userBean
        SPUtils.getInstance().put(KEY_USER, gson.toJson(userBean))
    }

    //刷新token
    fun refreshToken(token: String) {
        this.token = token
        SPUtils.getInstance().put(KEY_TOKEN, token)
    }

    //刷新推送token
    fun refreshId(id: String) {
        this.id = id
        SPUtils.getInstance().put(KEY_ID, id)
    }

    //退出登陆
    fun logout() {
        userBean = UserBean()
        token = ""
        id = ""
        SPUtils.getInstance().remove(KEY_ID)
        SPUtils.getInstance().remove(KEY_USER)
        SPUtils.getInstance().remove(KEY_TOKEN)
    }

    //判断登陆状态
    fun isLogin() = id.isNotEmpty()

    //将缓存数据添加到内存中
    fun initUserInfo() {
        val userInfoStr = SPUtils.getInstance().getString(KEY_USER)
        if (!TextUtils.isEmpty(userInfoStr)) {
            userBean = gson.fromJson(userInfoStr, UserBean::class.java)
        }
        token = SPUtils.getInstance().getString(KEY_TOKEN)
        id = SPUtils.getInstance().getString(KEY_ID)

    }

}