package com.futrue.huomai.mvp



import com.futrue.huomai.UserInfo
import com.futrue.huomai.data.ApiServer
import com.futrue.frame.mvp.view.IRequestView
import com.futrue.huomai.UserBean


/**
 * @package    com.zhongde.tinglishi.base.mvp
 * @anthor     lucas
 * @date       2018/12/21
 * @des        用户登陆后的界面使用
 */
abstract class BaseUserPresenter<out V : IRequestView>(v: V, apiServer: ApiServer, var userInfo: UserInfo) : BasePresenter<V>(v, apiServer) {

    //刷新用户信息
    fun refreshUserInfo(onRefreshSuccess: (UserBean?) -> Unit = {}) {
//        request {
//            call = apiServer.refreshUserInfo(userInfo.id)
//            _success = { dataBean, _, _ ->
//                //更新内存和本地缓存
//                if (dataBean is RefreshUserBean) {
//                    if (dataBean.data != null) {
//                        userInfo.refreshUserBean(dataBean.data)
//                    }
//                    onRefreshSuccess(dataBean.data)
//                }
//            }
//        }
    }
}