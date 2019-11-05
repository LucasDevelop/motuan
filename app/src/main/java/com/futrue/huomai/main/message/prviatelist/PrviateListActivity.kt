package com.futrue.huomai.main.message.prviatelist

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
import com.futrue.huomai.main.message.chat.ChatActivity
import com.futrue.huomai.main.message.prviateadd.PrviateAddActivity

class PrviateListActivity :
    BaseRefreshListActivity<PrviateListPresenter, IBean, PrviateListAdapter>(),
    BaseQuickAdapter.OnItemChildClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PrviateListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private lateinit var mRvRecommend: RecyclerView
    private val mPrviateRecommendAdapter = PrviateRecommendAdapter()

    override fun getLayoutID(): Int = R.layout.activity_prviate_list

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar(
            "私信",
            rightRes = R.mipmap.prviate_add,
            rightClickListener = View.OnClickListener {
                PrviateAddActivity.launch(this)
            })
        mSwipeRefreshLayout.isEnabled = false
        val view = layoutInflater.inflate(R.layout.foot_fens, mRecyclerView, false)
        mRvRecommend = view.findViewById(R.id.rv_recommend)
//        val recommendView = layoutInflater.inflate(R.layout.foot_recommend, rv_recommend, false)
        mBaseAdapter.addFooterView(view)

    }

    override fun initData() {
        mBaseAdapter.setNewData(List(3) { IBean() })
        mRvRecommend.layoutManager = LinearLayoutManager(this)
        mRvRecommend.adapter = mPrviateRecommendAdapter
        mPrviateRecommendAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        mPrviateRecommendAdapter.onItemChildClickListener = this
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            ChatActivity.launch(this)
        }

    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {

    }
}


