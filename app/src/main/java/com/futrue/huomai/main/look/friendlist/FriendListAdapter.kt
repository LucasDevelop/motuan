package com.futrue.huomai.main.look.friendlist

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.main.look.friendlist.FriendListBean

class FriendListAdapter :
    BaseQuickAdapter<FriendListBean, BaseViewHolder>(R.layout.item_friend_list) {

    override fun convert(helper: BaseViewHolder, item: FriendListBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_avatar))
            setText(R.id.tv_name, item.city)
        }
    }
}
