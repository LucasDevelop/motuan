package com.futrue.huomai.main.home.video

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.personaldetails.PersonalDetailsActivity
import com.futrue.huomai.main.look.friendlist.FriendListActivity
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.SharePopup
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import kotlinx.android.synthetic.main.activity_video_player.*


class VideoPlayerActivity :
    BaseRefreshListActivity<VideoPlayerPresenter, IBean, VideoPlayerAdapter>(),
    View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, VideoPlayerActivity::class.java)
            activity.startActivity(intent)
        }
    }

    val mShare by lazy { SharePopup(this) }

    override fun getLayoutID(): Int = R.layout.activity_video_player

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mSwipeRefreshLayout.isEnabled = false
        GlideUtil.loadRoundCornersImg(this, "", iv_head)
        val comment = et_comment.text.toString().trim()
        val adapter = CommentAdapter()
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
        adapter.setNewData(List(10) { IBean() })
        val pagerSnapHelper = object : PagerSnapHelper() {

            override fun findTargetSnapPosition(
                layoutManager: RecyclerView.LayoutManager?, velocityX: Int, velocityY: Int
            ): Int {
                val targetPos = super.findTargetSnapPosition(layoutManager, velocityX, velocityY)

                return targetPos
            }
        }
        pagerSnapHelper.attachToRecyclerView(mRecyclerView)
        mBaseAdapter.setNewData(List(5) { IBean() })
    }

    override fun initEvent() {
        arrayOf(iv_back, iv_expression, bt_send).setOnClickListener(this)
        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.tv_goodsClose -> {

                }
                R.id.iv_like -> {

                }
                R.id.iv_comment -> {
                    slidingLayout.anchorPoint = 0.8f
                    slidingLayout.panelState = SlidingUpPanelLayout.PanelState.EXPANDED
                }
                R.id.iv_share -> {
                    mShare.showAtLocation(view, Gravity.CENTER, 0, 0)
                }
                R.id.fl_user ->{
                    PersonalDetailsActivity.launch(this)
                }
            }
        }
        mShare.onClick = {
            when (it) {
                SharePopup.wechat -> {

                }
                SharePopup.friends -> {

                }
                SharePopup.report -> {

                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            iv_back -> {
                finish()
            }
            iv_expression -> {
            }
            bt_send -> {

            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


    override fun loadMoreListRequest(page: Int) {
    }

}


