package com.futrue.huomai.main.message.fenslist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.activity_fens_list.*


class FensListActivity : BaseRefreshListActivity<FensListPresenter, IBean, FensListAdapter>(),
    BaseQuickAdapter.OnItemChildClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, FensListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mRecommendListAdapter = RecommendListAdapter()
    private lateinit var rv_recommend: RecyclerView
    override fun getLayoutID(): Int = R.layout.activity_fens_list

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("粉丝")
        mSwipeRefreshLayout.isEnabled = false
        val view = layoutInflater.inflate(R.layout.foot_all, mRecyclerView, false)
        rv_recommend = view.findViewById(R.id.rv_recommend)
//        val recommendView = layoutInflater.inflate(R.layout.foot_recommend, rv_recommend, false)
        mBaseAdapter.addFooterView(view)

    }

    override fun initData() {
        mBaseAdapter.setNewData(List(3) { IBean() })
        rv_recommend.layoutManager = LinearLayoutManager(this)
        rv_recommend.adapter = mRecommendListAdapter
        mRecommendListAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        mBaseAdapter.onItemChildClickListener = this
        mRecommendListAdapter.onItemChildClickListener = this

    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        if (adapter is FensListAdapter) {

        } else {
            when (view?.id) {
                R.id.bt_attention -> {
                }
                R.id.iv_delet -> {
                }
            }

        }
    }

}


