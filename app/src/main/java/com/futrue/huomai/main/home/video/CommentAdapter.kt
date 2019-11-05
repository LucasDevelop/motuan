package com.futrue.huomai.main.home.video

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil

class CommentAdapter : BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_comment) {

    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "小尼")
            setText(R.id.tv_content, "在喧嚣中迷失了自己，便想安静下来，#我要上热门# @旅游达人@旅游百事通")
            setText(R.id.tv_praise, "125")



            addOnClickListener(R.id.ll_praise, R.id.bt_attention)
        }
    }
}
