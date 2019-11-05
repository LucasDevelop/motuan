package com.futrue.frame.base.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.futrue.frame.bus.AppBus
import com.futrue.frame.helper.CommentHelper
import com.futrue.frame.mvp.view.IView
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.trello.rxlifecycle2.components.support.RxFragment
import org.devio.takephoto.app.TakePhoto
import org.devio.takephoto.app.TakePhotoImpl
import org.devio.takephoto.model.InvokeParam
import org.devio.takephoto.model.TContextWrap
import org.devio.takephoto.model.TResult
import org.devio.takephoto.permission.InvokeListener
import org.devio.takephoto.permission.PermissionManager
import org.devio.takephoto.permission.TakePhotoInvocationHandler

/**
 * Fragment底层基类--包含一些基本的功能,一般用于无网络请求无dagger注入的界面
 */
abstract class BaseFragment : RxFragment(), IView,CommentHelper , TakePhoto.TakeResultListener, InvokeListener {
    private val mLoadingDialog: QMUITipDialog by lazy {
           QMUITipDialog.Builder(mActivity)
            .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
            .setTipWord("正在加载")
            .create() }
    val mActivity:FragmentActivity by lazy { activity!! }
    lateinit var rootView: View
    private var invokeParam: InvokeParam? = null
    val takePhoto: TakePhoto by lazy {
        TakePhotoInvocationHandler.of(this).bind(
                TakePhotoImpl(
                        this,
                        this
                )
        ) as TakePhoto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        this.takePhoto.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        this.takePhoto.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = LayoutInflater.from(activity).inflate(getLayoutID(), null)
        return rootView
    }

    //视图创建完毕后
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        baseInit()
        initView(savedInstanceState)
        initData()
        initEvent()
    }

    //内部初始化
    private fun baseInit() {
        if (registerBus())
            AppBus.register(this)
        initFindView()
    }

    //查找控件
    open fun initFindView() {
    }

    //布局id
    abstract fun getLayoutID(): Int

    //视图初始化
    abstract fun initView(savedInstanceState: Bundle?)

    //数据初始化
    abstract fun initData()

    //事件初始化
    open fun initEvent() {}

    //注册事件
    open fun registerBus() = false

    //显示加载框
    override fun showLoading() {
        if (!mLoadingDialog.isShowing)
            mLoadingDialog.show()
    }

    //隐藏加载框
    override fun hideLoading() {
        if (mLoadingDialog.isShowing)
            mLoadingDialog.dismiss()
    }

    fun <T : View> findView(id: Int): T? {
        return rootView.findViewById(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (registerBus())
            AppBus.unregister(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        this.takePhoto.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(this.activity, type, this.invokeParam, this)
    }


    override fun takeSuccess(result: TResult) {

    }

    override fun takeFail(result: TResult, msg: String) {

    }

    override fun takeCancel() {

    }

    override fun invoke(invokeParam: InvokeParam): PermissionManager.TPermissionType {
        val type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.method)
        if (PermissionManager.TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }

        return type
    }

}