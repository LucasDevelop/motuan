package com.futrue.frame.base.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.blankj.utilcode.util.SizeUtils
import com.futrue.frame.R
import com.futrue.frame.bus.AppBus
import com.futrue.frame.helper.CommentHelper
import com.futrue.frame.mvp.view.IView
import com.gyf.barlibrary.ImmersionBar
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.devio.takephoto.app.TakePhoto
import org.devio.takephoto.app.TakePhotoImpl
import org.devio.takephoto.model.InvokeParam
import org.devio.takephoto.model.TContextWrap
import org.devio.takephoto.model.TResult
import org.devio.takephoto.permission.InvokeListener
import org.devio.takephoto.permission.PermissionManager
import org.devio.takephoto.permission.TakePhotoInvocationHandler

/**
 * activity底层基类--包含一些基本的功能,一般用于无网络请求无dagger注入的界面
 */
abstract class BaseActivity : RxAppCompatActivity(), IView, CommentHelper, TakePhoto.TakeResultListener,
        InvokeListener {

    private var mToolBar: Toolbar? = null


    private val mLoadingDialog: QMUITipDialog by lazy {
        QMUITipDialog.Builder(this)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create()

    }
    val takePhoto: TakePhoto by lazy {
        TakePhotoInvocationHandler.of(this).bind(
                TakePhotoImpl(
                        this,
                        this
                )
        ) as TakePhoto
    }
    var invokeParam: InvokeParam? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //竖屏
        if (isUseOrientation())
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        initStatusBar()
        super.onCreate(savedInstanceState)
        initAnim()
        baseInit()
        initView(savedInstanceState)
        initData()
        initEvent()
    }

    open fun isUseOrientation(): Boolean = true
    open fun isDarkFont(): Boolean = true

    //内部初始化
    private fun baseInit() {
        //填充布局
        if (getLayoutID() != 0)
            setContentView(getLayoutID())
        if (registerBus())
            AppBus.register(this)
        initFindView()
    }

    open fun initFindView() {
        //查找控件
        mToolBar = findViewById(R.id.frame_toolbar)
    }

    //视图初始化
    abstract fun initView(savedInstanceState: Bundle?)

    //数据初始化
    abstract fun initData()

    //事件初始化
    open fun initEvent() {}

    //布局id
    abstract fun getLayoutID(): Int

    //注册事件
    open fun registerBus() = false

    //Activity是否添加动画
    open fun toggleOverridePendingTransition() = false

    //Activity动画类型
    open fun getOverridePendingTransitionMode() = TransitionMode.RIGHT

    enum class TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE, FINISH
    }

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

    /**
     * 设置toolbar
     * @param title 中间显示的文本
     * @param isBack 是否显示返回按钮
     * @param textSize 字体大小
     * @param textColor  字体的颜色
     * @param layoutParams 文字参数
     * @param rightRes 右边的资源
     * @param rightClickListener    右边资源的点击事件
     */
    fun setToolbar(
            title: String,
            isBack: Boolean = true,
            rightRes: Any = 0,
            rightTextColor: Int = 0,
            rightClickListener: View.OnClickListener? = null, @DrawableRes leftRes: Int = 0,
            bg: Int = R.color.frame_white_color,
            textSize: Float = 18f,
            textColor: Int = R.color.frame_black_color,
            layoutParams: Toolbar.LayoutParams = Toolbar.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER
            )
    ) {
        mToolBar?.run {
            //背景颜色
            setBackgroundColor(resources.getColor(bg))
            if (isBack) {
                val leftImg = ImageView(this@BaseActivity)
                if (leftRes == 0) {
//                    setNavigationIcon(R.mipmap.frame_ic_back)
                    leftImg.setImageResource(R.mipmap.frame_ic_back)
                } else {
                    leftImg.setImageResource(leftRes)
                }
//                setNavigationOnClickListener {
//                    finish()
//                }
                val lefttParams = Toolbar.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        Gravity.START
                )
                val dp15 = SizeUtils.dp2px(10f)
                leftImg.setPadding(0, dp15, dp15, dp15)
                leftImg.id = R.id.frame_toolbar_right
                leftImg.setOnClickListener { onNavigationOnClickListener()}
                addView(leftImg, lefttParams)
            }
            if (!TextUtils.isEmpty(title)) {
                val textView = TextView(this@BaseActivity)
                textView.id = R.id.frame_toolbar_title
                textView.text = title
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
                if (textColor != 0)
                    textView.setTextColor(resources.getColor(textColor))
                addView(textView, layoutParams)
            }
            if (rightClickListener == null) return
            val rightParams = Toolbar.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.RIGHT
            )
            //判断是资源还是文本
            val dp15 = SizeUtils.dp2px(15f)
            if (rightRes is Int) {
                val rightImg = ImageView(this@BaseActivity)
                rightImg.id = R.id.frame_toolbar_right
                rightImg.setPadding(dp15, 0, dp15, 0)
                rightImg.setImageResource(rightRes)
                rightImg.setOnClickListener(rightClickListener)
                addView(rightImg, rightParams)
            }
            if (rightRes is String) {
                val textView = TextView(this@BaseActivity)
                textView.id = R.id.frame_toolbar_right
                textView.gravity = Gravity.CENTER
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                if (rightTextColor != 0) {
                    textView.setTextColor(rightTextColor)
                } else {
                    textView.setTextColor(resources.getColor(R.color.frame_title_color))
                }
                textView.setPadding(dp15, 0, dp15, 0)
                textView.text = rightRes
                textView.setOnClickListener(rightClickListener)
                addView(textView, rightParams)
            }
        }

    }

    protected open fun onNavigationOnClickListener() {
        finish()
    }

    //onActivityResult回调
    var onACResult: (requestCode: Int, resultCode: Int, data: Intent?) -> Unit = { _, _, _ -> }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        takePhoto.onActivityResult(requestCode, resultCode, data)
        onACResult(requestCode, resultCode, data)
    }


    override fun onDestroy() {
        super.onDestroy()
        if (registerBus())
            AppBus.unregister(this)

        // 必须调用该方法，防止内存泄漏
        ImmersionBar.with(this).destroy()
    }

    //初始化activity打开与关闭动画
    private fun initAnim() {
        if (toggleOverridePendingTransition()) {
            when (getOverridePendingTransitionMode()) {
                TransitionMode.LEFT -> overridePendingTransition(R.anim.frame_left_in, R.anim.frame_left_out)
                TransitionMode.RIGHT -> overridePendingTransition(R.anim.frame_right_in, R.anim.frame_right_out)
                TransitionMode.FINISH -> overridePendingTransition(R.anim.frame_right_in, R.anim.frame_right_finish)
                TransitionMode.TOP -> overridePendingTransition(R.anim.frame_top_in, R.anim.frame_top_out)
                TransitionMode.BOTTOM -> overridePendingTransition(R.anim.frame_bottom_in, R.anim.frame_bottom_out)
                TransitionMode.SCALE -> overridePendingTransition(R.anim.frame_scale_in, R.anim.frame_scale_out)
                TransitionMode.FADE -> overridePendingTransition(R.anim.frame_fade_in, R.anim.frame_fade_out)
            }
        }
    }

    override fun finish() {
        super.finish()
        if (toggleOverridePendingTransition()) {
            when (getOverridePendingTransitionMode()) {
                TransitionMode.LEFT -> overridePendingTransition(R.anim.frame_left_in, R.anim.frame_left_out)
                TransitionMode.RIGHT -> overridePendingTransition(R.anim.frame_right_in, R.anim.frame_right_out)
                TransitionMode.FINISH -> overridePendingTransition(R.anim.frame_right_in, R.anim.frame_right_finish)
                TransitionMode.TOP -> overridePendingTransition(R.anim.frame_top_in, R.anim.frame_top_out)
                TransitionMode.BOTTOM -> overridePendingTransition(R.anim.frame_bottom_in, R.anim.frame_bottom_out)
                TransitionMode.SCALE -> overridePendingTransition(R.anim.frame_scale_in, R.anim.frame_scale_out)
                TransitionMode.FADE -> overridePendingTransition(R.anim.frame_fade_in, R.anim.frame_fade_out)
            }
        }
    }


    //**********仿ISO图片选择功能***********

    override fun takeSuccess(result: TResult) {
//        Log.i(TAG, "takeSuccess：" + result.image.compressPath)
    }

    override fun takeFail(result: TResult, msg: String) {
//        Log.i(TAG, "takeFail:$msg")
    }

    override fun takeCancel() {
//        Log.i(TAG, this.resources.getString(org.devio.takephoto.R.string.msg_operation_canceled))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        takePhoto.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (invokeParam != null) {
            val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
            PermissionManager.handlePermissionsResult(this, type, invokeParam!!, this)
        }
    }

    override fun invoke(invokeParam: InvokeParam?): PermissionManager.TPermissionType {
        val type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam!!.method)
        if (PermissionManager.TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }
        return type
    }

    //沉浸式
    protected fun initStatusBar() {
        ImmersionBar.with(this)
                .transparentStatusBar()  //透明状态栏，不写默认透明色
                .statusBarDarkFont(isDarkFont())   //状态栏字体是深色，不写默认为亮色
                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
//                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)  //单独指定软键盘模式
                .init()
    }

}