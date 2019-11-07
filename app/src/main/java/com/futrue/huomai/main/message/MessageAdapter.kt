package com.futrue.huomai.main.message

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class MessageAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_message) {
    override fun convert(helper: BaseViewHolder, item: IBean) {
        helper.apply {
//            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            when (adapterPosition) {
                1 -> {
                   getView<ImageView>(R.id.iv_head).setImageResource(R.mipmap.ic_icon10)
                }
                2 -> {
                    getView<ImageView>(R.id.iv_head).setImageResource(R.mipmap.ic_icon11)
                }
            }
            setText(R.id.tv_name, "遛遛六")
            setText(R.id.tv_time, "11小时前发布")
            setText(
                R.id.tv_content, "小罐茶功夫套装骨瓷茶具套组,体验升乐茶香。综合借鉴传统茶具，造型" +
                        "精髓，在此基础上加以改造，使茶具更简单，间接优雅，品味非凡。厚薄均匀的哑光蔓延茶具，彰显..."
            )

        }
    }
}
