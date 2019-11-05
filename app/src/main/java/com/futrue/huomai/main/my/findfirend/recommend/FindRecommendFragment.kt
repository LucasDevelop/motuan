package com.futrue.huomai.main.my.findfirend.recommend

import android.os.Bundle
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.window.DialogCenterWindow
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton

class FindRecommendFragment : BaseRefreshListFragment<FindRecommendPresenter,
        IBean, FindRecommendAdapter>() {

    private val mDialogCenterWindow by lazy {
        DialogCenterWindow(
            mActivity, "匹配手机通讯录", "查看通讯录好友，在手机设" +
                    "置里开启通讯录权限，看看哪些联系人在玩魔团。"
        )
    }

    override fun getLayoutID(): Int = R.layout.fragment_find_recommend


    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        val view = layoutInflater.inflate(R.layout.head_find_commend, mRecyclerView, false)
        view.findViewById<QMUIRoundButton>(R.id.bt_look).setOnClickListener {
            mDialogCenterWindow.show()
        }
        mBaseAdapter.addHeaderView(view)
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) { IBean() })
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->

        }
        mDialogCenterWindow.onClick = {}
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }
}


