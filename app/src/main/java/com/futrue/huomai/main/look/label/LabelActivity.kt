package com.futrue.huomai.main.look.label

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.personaldetails.AppBarScrollingStatusChangeListener
import com.futrue.huomai.main.look.recommend.RecommendAdapter
import com.futrue.huomai.main.look.write.WriteActivity
import kotlinx.android.synthetic.main.activity_label.*

class LabelActivity : BaseRefreshListActivity<LabelPresenter, IBean, RecommendAdapter>(),
    View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, LabelActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutID(): Int = R.layout.activity_label

    override fun loadMoreListRequest(page: Int) {
    }

    override fun reRequest() {
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        tv_label.text = "越努力越幸运"
        tv_toolName.text = "越努力越幸运"
        tv_lookNum.text = "2.1万条看看"
        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        arrayOf(iv_back, bt_write, iv_toolBack, bt_toolWrite).setOnClickListener(this)
        appBarLayout.addOnOffsetChangedListener(object : AppBarScrollingStatusChangeListener() {
            override fun onScrollStatusChange(state: CollapsingToolbarLayoutState?) {
                if (state === CollapsingToolbarLayoutState.COLLAPSED) {
                    toolbar.visibility = View.VISIBLE
                } else {
                    toolbar.visibility = View.GONE
                }
            }
        })
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_back, iv_toolBack -> {
                finish()
            }
            bt_write, bt_toolWrite -> {
                WriteActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

}


