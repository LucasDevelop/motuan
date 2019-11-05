package com.futrue.huomai.main.message.prviateadd

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.huomai.R
import com.futrue.huomai.main.look.friendlist.FriendListBean
import com.futrue.huomai.utils.GlideUtil


class PrviateAddAdapter : BaseQuickAdapter<FriendListBean, BaseViewHolder>(R.layout.item_prviateadd) {
    override fun convert(helper: BaseViewHolder, item: FriendListBean) {
        helper.apply {
            GlideUtil.loadRoundImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "我想静静")
        }
    }
}
