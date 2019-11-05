package com.futrue.huomai.main.my.usercenter.userhead

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.TakePhotoWindow
import kotlinx.android.synthetic.main.activity_user_head.*
import org.devio.takephoto.model.TResult

class UserHeadActivity : BaseNetActivity<UserHeadPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, UserHeadActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mTakePhotoWindow by lazy { TakePhotoWindow(this, takePhoto) }

    override fun getLayoutID(): Int = R.layout.activity_user_head
    override fun isDarkFont(): Boolean = false

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar(
            "个人头像", leftRes = R.mipmap.frame_ic_white_back,
            bg = R.color.frame_transparent, textColor = R.color.frame_white_color
        )
    }

    override fun initData() {
        GlideUtil.loadRoundCornersImg(this, "", iv_head, 1)
    }

    override fun initEvent() {
        bt_change.setOnClickListener {
            mTakePhotoWindow.show()
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun takeSuccess(result: TResult) {

    }

}

