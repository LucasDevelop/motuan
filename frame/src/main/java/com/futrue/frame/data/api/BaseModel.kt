package com.futrue.frame.data.api

import com.blankj.utilcode.util.NetworkUtils
import com.futrue.frame.config.FrameConfig
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.helper.CommentHelper
import com.futrue.frame.mvp.view.IListView
import com.futrue.frame.mvp.view.IRequestView
import com.futrue.frame.mvp.view.ISwipeView
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @file       BaseModelkt
 * @brief      网络请求解析
 */
open class BaseModel(private val iView: IRequestView) : CommentHelper {


    private val TAG = "net"
    //请求体
    lateinit var call: Observable<out IBean>
    //加载显示的样式
    var loadStyle = LoadStyle.NONE
    //请求模式
    var requestMode = RequestMode.NONE
    //成功回调
    var _success: (dataBean: IBean, reqMode: RequestMode, requestTag: String) -> Unit = { dataBean, _, _ -> }
    //失败回调
    var _fail: (e: Throwable) -> Unit = {}
    //开始回调
    var _subscribe: (d: Disposable) -> Unit = {}
    //是否只用WiFi访问网络
    private var isOnlyUseWifi = false
    //同步生命周期
    private var isSyncLifeCycle = true
    //请求标记，用于在回调的时候区分数据
    var requestTag = ""

    enum class LoadStyle {
        NONE,//什么都不显示
        VIEW,//显示布局样式
        DIALOG,//显示popupWindow样式
        CUSTOM//显示自定义样式
    }

    enum class RequestMode {
        NONE,//首次加载
        LOAD_MODE//加载更多
    }

    //自定义样式
    var _customProgress: () -> Unit = {}
    var _customError: () -> Unit = {}

    fun request(init: BaseModel.() -> Unit) {
        //初始化
        init()
        loadBeginView()
        val checkNetWork = checkNetWork()
        if (checkNetWork) {
            loadNetErrorView()
            return
        }
        //请求数据
        val observable = call.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
        //同步生命周期
        if (isSyncLifeCycle) {
            if (iView is RxAppCompatActivity)
                observable?.compose(iView.bindUntilEvent(ActivityEvent.DESTROY))
            if (iView is RxFragment)
                observable?.compose(iView.bindUntilEvent(FragmentEvent.DESTROY))
        }
        observable?.subscribe(object : Observer<IBean> {
            override fun onComplete() {
                //结束
            }

            override fun onSubscribe(d: Disposable) {
                _subscribe(d)
            }

            override fun onNext(it: IBean) {
                when (it.status) {
                    FrameConfig.Net.REQUEST_SUCCESS, 0 -> {
                        iView.requestSuccess(it, requestMode, requestTag)
                        _success(it, requestMode, requestTag)
                        if (iView is ISwipeView)
                            iView.resetRefresh()
                        disProgressSuccess(it)
                    }
                    FrameConfig.Net.TOKEN_OVERDUE -> {
                        iView.tokenOverdue()
                        disProgressSuccess(it)
                    }
                    else -> {
                        //其他状态码
                        iView.requestFail(it, it.status, requestTag)
                        disProgressError()
                    }
                }
            }

            override fun onError(it: Throwable) {
                //输出日志
                it.printStackTrace()
                iView.requestError(it.message ?: "未知错误", it, requestTag)
                //失败
                loadFailView()
                _fail(it)
            }
        })
    }

    //显示网络错误
    private fun loadNetErrorView() {
        when (loadStyle) {
            LoadStyle.NONE -> {

            }
            LoadStyle.DIALOG -> {
                iView.hideLoading()
            }
            LoadStyle.VIEW -> {
                iView.showNetErrorView()
            }
            LoadStyle.CUSTOM -> {
            }
        }
    }


    //请求数据失败时关闭progress
    private fun disProgressError() {
        when (requestMode) {
            RequestMode.NONE -> {
                when (loadStyle) {
                    LoadStyle.NONE -> {
                    }
                    LoadStyle.VIEW -> {
                        iView.showServerErrorView("服务器错误")
                    }
                    LoadStyle.DIALOG -> {
                        iView.hideLoading()
                    }
                    LoadStyle.CUSTOM -> {
                        _customError()
                    }
                }
            }
            RequestMode.LOAD_MODE -> {
                (iView as? IListView)?.showLoadMoreFailView()
            }
        }
    }

    //请求数据成功时关闭progress
    private fun disProgressSuccess(data: IBean) {
        if (requestMode == RequestMode.NONE) {
            when (loadStyle) {
                LoadStyle.NONE -> {
                }
                LoadStyle.VIEW -> {
                    if (data.isEmpty())
                        iView.showEmptyView()
                    else
                        iView.refreshView()
                }
                LoadStyle.DIALOG -> {
                    iView.hideLoading()
                }
                LoadStyle.CUSTOM -> {
                    _customError()
                }
            }
        } else {//load more
            (iView as? IListView)?.showLoadMoreSuccessView()
            when (loadStyle) {
                LoadStyle.DIALOG -> {
                    iView.hideLoading()
                }
                LoadStyle.CUSTOM -> {
                    _customError()
                }
                else -> {
                }
            }
        }
    }

    //预加载view样式
    private fun loadBeginView() {
        when (requestMode) {
            RequestMode.NONE -> {
                when (loadStyle) {
                    LoadStyle.NONE -> {
                    }
                    LoadStyle.VIEW -> {
                        iView.showLoadingView()
                    }
                    LoadStyle.DIALOG -> {
                        iView.showLoading()
                    }
                    LoadStyle.CUSTOM -> {
                        _customProgress()
                    }
                }
            }
            RequestMode.LOAD_MODE -> {
            }
        }
    }

    //加载失败的样式
    private fun loadFailView() {
        when (requestMode) {
            RequestMode.NONE -> {
                when (loadStyle) {
                    LoadStyle.NONE -> {
                    }
                    LoadStyle.VIEW -> {
                        iView.showServerErrorView("服务器错误")
                    }
                    LoadStyle.DIALOG -> {
                        iView.hideLoading()
                    }
                    LoadStyle.CUSTOM -> {
                        _customError()
                    }
                }
            }
            RequestMode.LOAD_MODE -> {
                (iView as? IListView)?.showLoadMoreFailView()
            }
        }
        (iView as? ISwipeView)?.resetRefresh()
    }

    private fun checkNetWork(): Boolean {
        //判断wifi是否可用
        if (isOnlyUseWifi && !NetworkUtils.isWifiConnected()) {
            "wifi不可用".ld(TAG)
            "wifi不可用".showToast()
            _fail(RuntimeException("wifi不可用"))
            return true
        }
        //判断网络是否可用
        if (!isOnlyUseWifi && !NetworkUtils.isConnected()) {
            "网络不可用".ld(TAG)
            "网络不可用".showToast()
            _fail(RuntimeException("网络不可用"))
            return true
        }
        return false
    }
}