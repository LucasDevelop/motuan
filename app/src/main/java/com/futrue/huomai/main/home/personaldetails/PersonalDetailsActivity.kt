package com.futrue.huomai.main.home.personaldetails

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.personaldetails.personallook.PersonalLookFragment
import com.futrue.huomai.main.home.personaldetails.personalvideo.PersonalVideoFragment
import com.futrue.huomai.main.home.shop.ShopActivity
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.DialogWindow
import com.futrue.huomai.window.SharePopup
import kotlinx.android.synthetic.main.activity_personal_details.*
import kotlinx.android.synthetic.main.content_scrolling.*


class PersonalDetailsActivity : BaseNetActivity<PersonalDetailsPresenter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PersonalDetailsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mPersonalLookFragment = PersonalLookFragment()
    private val mPersonalVideoFragment = PersonalVideoFragment()
    private val mDialog by lazy { DialogWindow(this, "确定不再关注此用户？") }
    private val mShare by lazy { SharePopup(this, true) }
    override fun getLayoutID(): Int = R.layout.activity_personal_details

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager?.beginTransaction()?.apply {
            add(R.id.content, mPersonalLookFragment)
            add(R.id.content, mPersonalVideoFragment)
            hide(mPersonalLookFragment)
            commit()
        }
    }

    override fun initData() {
        GlideUtil.loadRoundImg(this, "", iv_bg, R.color.yellow_FECC32, R.color.yellow_FECC32)
        GlideUtil.loadRoundImg(this, "", iv_head)
        GlideUtil.loadRoundImg(this, "", iv_toolberHead)
        tv_name.text = "小尼爱化妆（教化妆）"
        tv_number.text = "火脉号：600123456"
        tv_content.text = "其实除了喜欢旅行、穿搭之外，家居设计也是我非常喜欢研究的一个领域..."
        bt_1.text = "男"
        bt_2.text = "天秤座"
        bt_3.text = "四川 成都"
        bt_1.visibility = View.VISIBLE
        bt_2.visibility = View.VISIBLE
        bt_3.visibility = View.VISIBLE
        tv_attentionNum.text = "1.2W"
        tv_fansNum.text = "185"
        tv_goodsName.text = "认证：宜宾市小尼化妆品官方账号"
        tv_goodsNum.text = "共38件商品"

        tv_videoNum.text = "视频 365"
        tv_lookNum.text = "看看 365"

    }

    override fun initEvent() {
        arrayOf(
            bt_attention, iv_message, iv_back, iv_share, iv_toolbarback, iv_toolbarShare,
            bt_toolbarAttention, fl_video, fl_look, rl_shop
        ).setOnClickListener(this)
        appBarLayout.addOnOffsetChangedListener(object : AppBarScrollingStatusChangeListener() {
            override fun onScrollStatusChange(state: CollapsingToolbarLayoutState?) {
                if (state === CollapsingToolbarLayoutState.COLLAPSED) {
                    toolbar.visibility = View.VISIBLE
                } else {
                    toolbar.visibility = View.GONE
                }
            }
        })
        mDialog.onClick = {

        }
        mShare.onClick ={
            when(it){
                SharePopup.wechat ->{}
                SharePopup.friends ->{}
                SharePopup.report ->{}
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            bt_attention, bt_toolbarAttention -> {
                mDialog.show()
            }
            iv_message -> {

            }
            iv_back, iv_toolbarback -> {
                finish()
            }
            iv_share, iv_toolbarShare -> {
                mShare.showAtLocation(v, Gravity.CENTER, 0, 0)
            }
            fl_video -> {
                supportFragmentManager?.beginTransaction()?.apply {
                    hide(mPersonalLookFragment)
                        .show(mPersonalVideoFragment)
                        .commit()
                }
                v_video.visibility = View.VISIBLE
                v_look.visibility = View.INVISIBLE
            }
            fl_look -> {
                supportFragmentManager?.beginTransaction()?.apply {
                    hide(mPersonalVideoFragment)
                        .show(mPersonalLookFragment)
                        .commit()
                }
                v_video.visibility = View.INVISIBLE
                v_look.visibility = View.VISIBLE
            }
            rl_shop -> {
                ShopActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun reRequest() {
    }

}

