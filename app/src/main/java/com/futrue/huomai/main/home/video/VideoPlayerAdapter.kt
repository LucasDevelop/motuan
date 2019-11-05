package com.futrue.huomai.main.home.video

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class VideoPlayerAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_videoplayer) {

    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_goodsCover))
            setText(R.id.tv_goodsTitle, "小罐茶茶具茶水分...")
            setText(R.id.tv_goodsMoney, "￥ 1280")
            setText(R.id.tv_content, "在喧嚣中迷失了自己，便想安静下来，#我要上热门# @旅游达人...")
            setText(R.id.tv_location, "重庆解放碑")
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setImageResource(R.id.iv_like, R.mipmap.video_like)
            setText(R.id.tv_likeNum, "123")
            setText(R.id.tv_commentNum, "321")
            setText(R.id.tv_shareNum, "231")


            addOnClickListener(R.id.tv_goodsClose,R.id.iv_like,R.id.iv_comment,R.id.iv_share,R.id.fl_user)
        }
    }
}
