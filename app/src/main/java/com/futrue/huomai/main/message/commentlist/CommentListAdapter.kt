package com.futrue.huomai.main.message.commentlist

import com.futrue.huomai.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class CommentListAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_commentlist) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "遛遛六")
            setText(R.id.tv_type, "赞了你的作品")
            setText(R.id.tv_time, "评论了你的作品  2小时前")
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_img))
        }
    }
}
