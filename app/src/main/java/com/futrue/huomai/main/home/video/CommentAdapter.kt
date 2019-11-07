package com.futrue.huomai.main.home.video

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewTreeObserver
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.frame.helper.CommentHelper
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.utils.TimeUtil
import com.futrue.huomai.widget.CommentChildView
import javax.inject.Inject

class CommentAdapter @Inject constructor(): BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_comment),
    CommentHelper {

    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "小尼")
//            setText(R.id.tv_content, "在喧嚣中迷失了自己，便想安静下来，#我要上热门# @旅游达人@旅游百事通")
            setText(R.id.iv_praise, "125")
            setChecked(R.id.iv_praise, true)
            getView<CommentChildView>(R.id.v_content).apply {
                viewTreeObserver.addOnGlobalLayoutListener(object :
                    ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        viewTreeObserver.removeOnGlobalLayoutListener(this)
                        setContent("在喧嚣中迷失了自己，便想安静下来，#我要上热门# @旅游达人@旅游百事通")
                        isHot(true)
                        setTime(TimeUtil.formatTime(System.currentTimeMillis() - 3700 * 1000))
                    }
                })
            }
            getView<View>(R.id.v_more_reply).setOnClickListener {
                it.visibility = View.GONE
                getView<RecyclerView>(R.id.v_reply_list).apply {
                    layoutManager = LinearLayoutManager(mContext)
                    val commentReplyAdapter = CommentReplyAdapter()
                    adapter = commentReplyAdapter
                    commentReplyAdapter.setNewData(List(5) { IBean() })
                }
            }

            addOnClickListener(R.id.ll_praise, R.id.bt_attention)
        }
    }
}
