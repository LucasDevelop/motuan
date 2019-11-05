package com.futrue.huomai.main.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.fragment.BaseNetFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.attention.AttentionFragment
import com.futrue.huomai.main.home.hot.HotFragment
import com.futrue.huomai.main.home.search.SearchActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseNetFragment<HomePresenter>(), View.OnClickListener {



    private val mHotFragment = HotFragment()
    private val mAttentionFragment = AttentionFragment()


    override fun getLayoutID(): Int = R.layout.fragment_home

    override fun initView(savedInstanceState: Bundle?) {
        fragmentManager?.beginTransaction()?.apply {
            add(R.id.frame, mHotFragment)
            add(R.id.frame, mAttentionFragment)
            hide(mAttentionFragment)
            commit()
        }
    }

    override fun initData() {
    }

    override fun initEvent() {
        arrayOf(iv_search, fl_attention, fl_hot).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_search -> {
                SearchActivity.launch(mActivity)
            }
            fl_attention -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mHotFragment)
                        .show(mAttentionFragment)
                        .commit()
                }
                v_follow_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    setTextColor(resources.getColor(R.color.textColor))
                }
                v_hot_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                    setTextColor(resources.getColor(R.color.gray_text))
                }
                v_attention.visibility =View.VISIBLE
                v_hot.visibility =View.INVISIBLE
            }
            fl_hot -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mAttentionFragment)
                        .show(mHotFragment)
                        .commit()
                }
                v_hot_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    setTextColor(resources.getColor(R.color.textColor))
                }
                v_follow_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                    setTextColor(resources.getColor(R.color.gray_text))
                }
                v_hot.visibility =View.VISIBLE
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }
}

