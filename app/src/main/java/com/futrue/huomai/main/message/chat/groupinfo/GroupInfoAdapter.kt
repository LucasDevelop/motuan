package com.futrue.huomai.main.message.chat.groupinfo

import com.blankj.utilcode.util.SizeUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class GroupInfoAdapter @Inject constructor() :
    BaseQuickAdapter<GroupInfoBean, BaseViewHolder>(R.layout.item_groupinfo) {
    override fun convert(helper: BaseViewHolder, item: GroupInfoBean) {
        helper.apply {
            when (item.type) {
                1 -> {
                    setImageResource(R.id.iv_head, R.mipmap.group_plus)
                    setText(R.id.tv_name, "")
                }
                2 -> {
                    setImageResource(R.id.iv_head, R.mipmap.group_delet)
                    setText(R.id.tv_name, "")
                }
                else -> {
                    GlideUtil.loadRoundCornersImg(
                        mContext, "", getView(R.id.iv_head),
                        SizeUtils.dp2px(4F)
                    )
                    setText(R.id.tv_name, "反倒是是")
                }
            }
        }

    }
}
