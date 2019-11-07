package com.futrue.huomai.main.my

import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.futrue.frame.base.fragment.BaseNetFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.personaldetails.AppBarScrollingStatusChangeListener
import com.futrue.huomai.main.home.shop.ShopActivity
import com.futrue.huomai.main.my.findfirend.FindFirendActivity
import com.futrue.huomai.main.my.look.MyLookFragment
import com.futrue.huomai.main.my.praise.MyPriaseFragment
import com.futrue.huomai.main.my.secret.MySecretFragment
import com.futrue.huomai.main.my.setting.SettingActivity
import com.futrue.huomai.main.my.usercenter.UserCenterActivity
import com.futrue.huomai.main.my.video.MyVideoFragment
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.SharePopup
import com.futrue.huomai.window.TakePhotoWindow
import kotlinx.android.synthetic.main.content_my_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.tv_lookNum
import kotlinx.android.synthetic.main.content_scrolling.tv_videoNum
import kotlinx.android.synthetic.main.fragment_my.*
import org.devio.takephoto.model.TResult

/**
 * @package    MyFragment.kt
 * @author     luan
 * @date       2019-11-05
 * @des        我的
 */
class MyFragment : BaseNetFragment<MyPresenter>(), View.OnClickListener {


    private val mTakePhotoWindow by lazy { TakePhotoWindow(mActivity, takePhoto) }
    private val mShare by lazy { SharePopup(mActivity, isReport = false) }

    companion object {
        private val MyLookFragmentKey = "MyLookFragment"
        private val MyVideoFragmentKey = "MyVideoFragment"
        private val MySecretFragmentKey = "MySecretFragment"
        private val MyPriaseFragmentKey = "MyPriaseFragment"
    }

    private var mMyLookFragment: MyLookFragment? = null
    private var mMyVideoFragment: MyVideoFragment? = null
    private var mMySecretFragment: MySecretFragment? = null
    private var mMyPriaseFragment: MyPriaseFragment? = null

    override fun getLayoutID(): Int = R.layout.fragment_my

    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            fragmentManager?.apply {
                mMyLookFragment =
                    getFragment(savedInstanceState, MyLookFragmentKey) as MyLookFragment
                mMyVideoFragment =
                    getFragment(savedInstanceState, MyVideoFragmentKey) as MyVideoFragment
                mMySecretFragment =
                    getFragment(savedInstanceState, MySecretFragmentKey) as MySecretFragment
                mMyPriaseFragment =
                    getFragment(savedInstanceState, MyPriaseFragmentKey) as MyPriaseFragment
            }

        } else {
            mMyLookFragment = MyLookFragment()
            mMyVideoFragment = MyVideoFragment()
            mMySecretFragment = MySecretFragment()
            mMyPriaseFragment = MyPriaseFragment()
        }
        fragmentManager?.beginTransaction()?.apply {
            add(R.id.content, mMyLookFragment!!)
            add(R.id.content, mMyVideoFragment!!)
            add(R.id.content, mMySecretFragment!!)
            add(R.id.content, mMyPriaseFragment!!)
            hide(mMyLookFragment!!)
            hide(mMySecretFragment!!)
            hide(mMyPriaseFragment!!)
            commit()
        }
        changeStatus()
    }

    var isShop = true

    //更新状态
    private fun changeStatus() {
        if (isShop){//有店铺
            rl_shop.showView()
            v_no_shop.hideView()
        }else{
            rl_shop.hideView()
            v_no_shop.showView()
        }
    }

    override fun initData() {
        GlideUtil.loadRoundImg(mActivity, "", iv_bg, R.color.yellow_FECC32, R.color.yellow_FECC32)
        GlideUtil.loadRoundImg(mActivity, "", iv_head)
        GlideUtil.loadRoundImg(mActivity, "", iv_toolberHead)
        tv_toolMessageNum.text = "1"
        tv_messageNum.text = "1"
        tv_name.text = "小尼爱化妆（教化妆）"
        tv_number.text = "火脉号：600123456"
        tv_content.text = "其实除了喜欢旅行、穿搭之外，家居设计也是我非常喜欢研究的一个领域..."
        bt_1.text = "男"
        bt_2.text = "天秤座"
        bt_3.text = "四川 成都"
        tv_attentionNum.text = "1.2W"
        tv_fansNum.text = "1.2W"
        tv_getPraiseNum.text = "1.2W"
        tv_fansNum.text = "185"
        tv_goodsName.text = "认证：宜宾市小尼化妆品官方账号"
        tv_goodsNum.text = "共38件商品"

        tv_videoNum.text = "365"
        tv_lookNum.text = "365"
        tv_privateNum.text = "365"
        tv_praiseNum.text = "365"
    }

    override fun initEvent() {
        arrayOf(
            bt_editor, iv_setting, iv_share, rl_findfirend, rl_toolFindfirend, iv_toolbarShare,
            rl_video, rl_look, rl_private, rl_praise, rl_shop, rl_assistant, bt_setCover, v_shop
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

        mShare.onClick = {
            when (it) {
                SharePopup.wechat -> {
                }
                SharePopup.friends -> {
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            v_shop -> {

            }
            bt_editor -> {
                UserCenterActivity.launch(mActivity)
            }
            rl_findfirend, rl_toolFindfirend -> {
                FindFirendActivity.launch(mActivity)
            }
            iv_setting, iv_toolSetting -> {
                SettingActivity.launch(mActivity)
            }
            iv_share, iv_toolbarShare -> {
                mShare.showAtLocation(v, Gravity.CENTER, 0, 0)
            }
            rl_shop -> {
                ShopActivity.launch(mActivity)
            }
            rl_assistant -> {

            }
            bt_setCover -> {
                mTakePhotoWindow.show()
            }
            rl_video -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mMyLookFragment!!)
                        .hide(mMySecretFragment!!)
                        .hide(mMyPriaseFragment!!)
                        .show(mMyVideoFragment!!)
                        .commit()
                }
                v_video.visibility = View.VISIBLE
                v_look.visibility = View.GONE
                v_private.visibility = View.GONE
                v_praise.visibility = View.GONE
            }
            rl_look -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mMyVideoFragment!!)
                        .hide(mMySecretFragment!!)
                        .hide(mMyPriaseFragment!!)
                        .show(mMyLookFragment!!)
                        .commit()
                }
                v_video.visibility = View.GONE
                v_look.visibility = View.VISIBLE
                v_private.visibility = View.GONE
                v_praise.visibility = View.GONE

            }
            rl_private -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mMyVideoFragment!!)
                        .hide(mMyLookFragment!!)
                        .hide(mMyPriaseFragment!!)
                        .show(mMySecretFragment!!)
                        .commit()
                }
                v_video.visibility = View.GONE
                v_look.visibility = View.GONE
                v_private.visibility = View.VISIBLE
                v_praise.visibility = View.GONE
            }
            rl_praise -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mMyVideoFragment!!)
                        .hide(mMyLookFragment!!)
                        .hide(mMySecretFragment!!)
                        .show(mMyPriaseFragment!!)
                        .commit()
                }
                v_video.visibility = View.GONE
                v_look.visibility = View.GONE
                v_private.visibility = View.GONE
                v_praise.visibility = View.VISIBLE
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


    override fun onSaveInstanceState(outState: Bundle) {
        if (mMyLookFragment != null) {
            fragmentManager?.putFragment(outState, MyLookFragmentKey, mMyLookFragment!!)
        }

        if (mMyVideoFragment != null) {
            fragmentManager?.putFragment(outState, MyVideoFragmentKey, mMyVideoFragment!!)
        }
        if (mMySecretFragment != null) {
            fragmentManager?.putFragment(outState, MySecretFragmentKey, mMySecretFragment!!)
        }
        if (mMyPriaseFragment != null) {
            fragmentManager?.putFragment(outState, MyPriaseFragmentKey, mMyPriaseFragment!!)
        }
        super.onSaveInstanceState(outState)
    }

    override fun takeSuccess(result: TResult) {

    }

}

