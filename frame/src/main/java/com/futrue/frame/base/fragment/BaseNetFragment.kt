package com.futrue.frame.base.fragment

import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.futrue.frame.R
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.mvp.presenter.IPresenter
import com.futrue.frame.mvp.view.IRequestView
import com.futrue.frame.widget.loadingView.VaryViewHelperController
import javax.inject.Inject

/**
 * 包含网络请求的页面
 */
abstract class BaseNetFragment<P : IPresenter<*>> : BaseDaggerFragment(), IRequestView {
    //注入控制器
    @Inject
    lateinit var mPresenter: P

    fun isPresenterInitialzed() = ::mPresenter.isInitialized

    var mSwitchLayout: VaryViewHelperController? = null

    override fun initFindView() {
        super.initFindView()
        //如果页面需要有网络状态回显功能，那么在布局中必须使用frame_root_view id来包裹被切换的部分
        val frameRootView = findView<View>(R.id.frame_root_view)
        if (frameRootView != null)
            mSwitchLayout = VaryViewHelperController(frameRootView, getEmptyView())
    }

    //重写更换空数据布局
    open fun getEmptyView(): Int = R.layout.frame_view_pager_no_data

    //重新请求
    protected open fun reRequest() {

    }

    override fun requestFail(bean: IBean, code: Int, requestTag: Any) {
        //默认数据获取失败时显示服务器返回的错误信息
        ToastUtils.showShort(bean.msg)
    }

    override fun requestError(msg: String, exception: Throwable?, requestTag: Any) {
        //请求错误
        ToastUtils.showShort("服务器错误")
    }

    //token 过期
    override fun tokenOverdue() {
        ToastUtils.showShort("登录状态已失效，请重新登入.")
    }

    //显示加载中布局
    override fun showLoadingView() {
        mSwitchLayout?.showLoading()
    }

    //显示空布局
    override fun showEmptyView() {
        mSwitchLayout?.showEmpty(getString(R.string.frame_load_empty))
    }

    //显示网络错误布局
    override fun showNetErrorView() {
        mSwitchLayout?.showNetworkError { reRequest() }
    }

    //显示服务器错误布局
    override fun showServerErrorView(hint: String) {
        mSwitchLayout?.showNetworkError({ reRequest() }, hint)
    }

    override fun refreshView() {
        mSwitchLayout?.restore()
    }
}