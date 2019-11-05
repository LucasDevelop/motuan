package com.futrue.huomai.main.message.prviateadd

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.look.friendlist.FriendListBean
import com.futrue.huomai.main.message.groupadd.GroupAddActivity
import com.futrue.huomai.main.message.selectgroup.SelectGroupActivity
import com.mcxtzhang.indexlib.suspension.SuspensionDecoration
import kotlinx.android.synthetic.main.activity_prviate_add.*


class PrviateAddActivity : BaseNetActivity<PrviateAddPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, PrviateAddActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mAdapter = PrviateAddAdapter()
    private lateinit var mDecoration: SuspensionDecoration
    private var mDatas = ArrayList<FriendListBean>()

    override fun getLayoutID(): Int = R.layout.activity_prviate_add

    override fun initView(savedInstanceState: Bundle?) {
//        val view = layoutInflater.inflate(R.layout.head_group, ll_rootView, false)
//
//        view.setOnClickListener { GroupAddActivity.launch(this) }
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mAdapter
        mDecoration = SuspensionDecoration(this, mDatas)
        mDecoration.setColorTitleFont(getResColor(R.color.textColor))
        mDecoration.setColorTitleBg(getResColor(R.color.grey_F7F7F7))
        recyclerView.addItemDecoration(mDecoration)
        //如果add两个，那么按照先后顺序，依次渲染。
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        //indexbar初始化
        indexBar.setmPressedShowTextView(tvSideBarHint)//设置HintTextView
            .setNeedRealIndex(true)//设置需要真实的索引
            .setmLayoutManager(layoutManager)//设置RecyclerView的LayoutManager

//        mAdapter.addHeaderView(view)
    }

    override fun initData() {
        et_search.text
        initDatas(resources.getStringArray(R.array.provinces))
    }

    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        tv_send.setOnClickListener { GroupAddActivity.launch(this) }
        rl_group.setOnClickListener { SelectGroupActivity.launch(this) }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    private fun initDatas(data: Array<String>) {
        //延迟两秒 模拟加载数据中....
        mDatas = ArrayList()
        //微信的头部 也是可以右侧IndexBar导航索引的，
        for (i in data.indices) {
            val cityBean = FriendListBean()
            cityBean.setCity(data[i])//设置城市名称
            mDatas.add(cityBean)
        }
        mAdapter.setNewData(mDatas)

        indexBar.setmSourceDatas(mDatas)//设置数据
            .invalidate()
        mDecoration.setmDatas(mDatas)
    }
}


