package com.futrue.huomai.main.my.secret

import android.os.Bundle
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseFragment
import com.futrue.huomai.main.my.secret.look.SecretLookFragment
import com.futrue.huomai.main.my.secret.video.SecretVideoFragment
import kotlinx.android.synthetic.main.fragment_my_secret.*

class MySecretFragment : BaseFragment() ,View.OnClickListener{


    override fun getLayoutID(): Int = R.layout.fragment_my_secret

    private val mSecretVideoFragment = SecretVideoFragment()
    private val mSecretLookFragment = SecretLookFragment()

    override fun initView(savedInstanceState: Bundle?) {
        fragmentManager?.beginTransaction()?.apply {
            add(R.id.fl_secretContent, mSecretVideoFragment)
            add(R.id.fl_secretContent, mSecretLookFragment)
            hide(mSecretLookFragment)
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
                    show(mSecretVideoFragment)
                    hide(mSecretLookFragment)
                    commit()
                }
                bt_video.setTextColor(mActivity.getResColor(R.color.yellow_FECC32))
                bt_look.setTextColor(mActivity.getResColor(R.color.textColor))
            }
            bt_look -> {
                fragmentManager?.beginTransaction()?.apply {
                    show(mSecretLookFragment)
                    hide(mSecretVideoFragment)
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


