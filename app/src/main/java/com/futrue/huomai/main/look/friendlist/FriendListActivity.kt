package com.futrue.huomai.main.look.friendlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.look.friendlist.FriendListBean
import com.mcxtzhang.indexlib.suspension.SuspensionDecoration
import kotlinx.android.synthetic.main.activity_friend_list.*
import java.util.ArrayList


class FriendListActivity : BaseNetActivity<FriendListPresenter>() {

    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, FriendListActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mAdapter = FriendListAdapter()
    private lateinit var mDecoration: SuspensionDecoration
    private var mDatas = ArrayList<FriendListBean>()
    override fun getLayoutID(): Int = R.layout.activity_friend_list

    override fun initView(savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mAdapter
        mDecoration = SuspensionDecoration(this, mDatas)
        mDecoration.setColorTitleFont(getResColor(R.color.textColor))
        mDecoration.setColorTitleBg(getResColor(R.color.grey_F7F7F7))
        recyclerView.addItemDecoration(mDecoration)
        //如果add两个，那么按照先后顺序，依次渲染。
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        //indexbar初始化
        indexBar.setmPressedShowTextView(tvSideBarHint)//设置HintTextView
            .setNeedRealIndex(true)//设置需要真实的索引
            .setmLayoutManager(layoutManager)//设置RecyclerView的LayoutManager
    }

    override fun initData() {
        initDatas(resources.getStringArray(R.array.provinces))
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    private fun initDatas(data: Array<String>) {
        //延迟两秒 模拟加载数据中....
        window.decorView.postDelayed({
            mDatas = ArrayList<FriendListBean>()
            //微信的头部 也是可以右侧IndexBar导航索引的，
            for (i in data.indices) {
                val cityBean = FriendListBean()
                cityBean.setCity(data[i])//设置城市名称
                mDatas.add(cityBean)
            }
            mAdapter.setNewData(mDatas)
            mAdapter.notifyDataSetChanged()

            indexBar.setmSourceDatas(mDatas)//设置数据
                .invalidate()
            mDecoration.setmDatas(mDatas)
        }, 500)
    }


}

