package com.futrue.huomai.main.my.praise

import android.os.Bundle
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseFragment
import com.futrue.huomai.main.my.praise.look.MyPraiseLookFragment
import com.futrue.huomai.main.my.praise.video.MyPraiseVideoFragment
import kotlinx.android.synthetic.main.fragment_my_priase.*
/**
 * @package    MyPriaseFragment.kt
 * @author     luan
 * @date       2019-11-05
 * @des        赞过
 */
class MyPriaseFragment : BaseFragment(), View.OnClickListener {

    private val mMyPraiseLookFragment = MyPraiseLookFragment()
    private val mMyPraiseVideoFragment = MyPraiseVideoFragment()

    override fun getLayoutID(): Int = R.layout.fragment_my_priase

    override fun initView(savedInstanceState: Bundle?) {
        fragmentManager?.beginTransaction()?.apply {
            add(R.id.fl_priaseContent, mMyPraiseLookFragment)
            add(R.id.fl_priaseContent, mMyPraiseVideoFragment)
            hide(mMyPraiseLookFragment)
            commit()
        }
    }

    override fun initEvent() {
        bt_video.setOnClickListener(this)
        bt_look.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            bt_video -> {
                fragmentManager?.beginTransaction()?.apply {
                    show( mMyPraiseVideoFragment)
                    hide(mMyPraiseLookFragment)
                    commit()
                }
                bt_video.setTextColor(mActivity.getResColor(R.color.yellow_FECC32))
                bt_look.setTextColor(mActivity.getResColor(R.color.textColor))
            }
            bt_look -> {
                fragmentManager?.beginTransaction()?.apply {
                    show( mMyPraiseLookFragment)
                    hide(mMyPraiseVideoFragment)
                    commit()
                }
                bt_look.setTextColor(mActivity.getResColor(R.color.yellow_FECC32))
                bt_video.setTextColor(mActivity.getResColor(R.color.textColor))
            }
        }
    }

    override fun initData() {
    }

}


