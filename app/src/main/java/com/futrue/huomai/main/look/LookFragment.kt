package com.futrue.huomai.main.look

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.fragment.BaseNetFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.search.SearchActivity
import com.futrue.huomai.main.look.attention.LookAttentionFragment
import com.futrue.huomai.main.look.recommend.DynamicFragment
import com.futrue.huomai.main.look.write.WriteActivity
import kotlinx.android.synthetic.main.fragment_look.*

class LookFragment : BaseNetFragment<LookPresenter>(), View.OnClickListener {


    private val mRecommendFragment = DynamicFragment.getNewInstance(DynamicFragment.TYPE_RECOMMEND)
    private val mLookAttentionFragment = LookAttentionFragment()


    override fun getLayoutID(): Int = R.layout.fragment_look


    override fun initView(savedInstanceState: Bundle?) {
        fragmentManager?.beginTransaction()?.apply {
            add(R.id.frame_look, mRecommendFragment)
            add(R.id.frame_look, mLookAttentionFragment)
            hide(mLookAttentionFragment)
            commit()
        }

    }

    override fun initData() {
    }

    override fun initEvent() {
        arrayOf(iv_search, fl_attention, fl_recommend, bt_write).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_search -> {
                SearchActivity.launch(mActivity)
            }
            fl_attention -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mRecommendFragment)
                        .show(mLookAttentionFragment)
                        .commit()
                }
                v_recommend_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                    setTextColor(resources.getColor(R.color.gray_text))
                }
                v_attention_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    setTextColor(resources.getColor(R.color.textColor))
                }
                v_attention.visibility = View.VISIBLE
                v_recommend.visibility = View.INVISIBLE
            }
            fl_recommend -> {
                fragmentManager?.beginTransaction()?.apply {
                    hide(mLookAttentionFragment)
                        .show(mRecommendFragment)
                        .commit()
                }
                v_attention_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                    setTextColor(resources.getColor(R.color.gray_text))
                }
                v_recommend_text.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    setTextColor(resources.getColor(R.color.textColor))
                }
                v_attention.visibility = View.INVISIBLE
                v_recommend.visibility = View.VISIBLE
            }
            bt_write -> {
                WriteActivity.launch(mActivity)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


}

