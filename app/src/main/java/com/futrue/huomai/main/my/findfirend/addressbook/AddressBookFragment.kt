package com.futrue.huomai.main.my.findfirend.addressbook

import android.os.Bundle
import android.widget.TextView
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton

class AddressBookFragment :
    BaseRefreshListFragment<AddressBookPresenter, IBean, AddressBookAdapter>() {

    private lateinit var mTvContnet: TextView
    override fun getLayoutID(): Int = R.layout.fragment_address_book

    override fun getEmptyView(): Int = R.layout.empty_address_book

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        val view = layoutInflater.inflate(R.layout.head_address_book, mRecyclerView, false)
        mTvContnet = view.findViewById(R.id.tv_content)
        mTvContnet.text = "你有67位好友正在玩快手"
        mListEmptyView.findViewById<QMUIRoundButton>(R.id.bt_find).setOnClickListener {

        }
        mBaseAdapter.addHeaderView(view)
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->

        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }
}


