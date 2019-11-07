package com.futrue.huomai.main.look.recommend

import android.graphics.Color
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.utils.GlideUtil
import javax.inject.Inject

class RecommendAdapter @Inject constructor() :
    BaseQuickAdapter<IBean, BaseViewHolder>(R.layout.item_recommend) {
    override fun convert(helper: BaseViewHolder, item: IBean) {

        helper.apply {
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_head))
            setText(R.id.tv_name, "遛遛六")
            setText(R.id.tv_time, "11小时前发布")
            setText(
                R.id.tv_content, "/小罐茶功夫套装骨瓷茶具套组,体验升乐茶香。综合借鉴传统茶具，造型" +
                        "精髓，在此基础上加以改造，使茶具更简单，间接优雅，品味非凡。厚薄均匀的哑光蔓延茶具，彰显..."
            )
            helper.getView<RecyclerView>(R.id.v_img_list).apply {
                layoutManager = GridLayoutManager(mContext, 3)
                val imageAdapter = ImageAdapter()
                adapter = imageAdapter
                imageAdapter.setNewData(List(5) { "" })
            }
            setGone(R.id.rl_goods, true)
            GlideUtil.loadRoundCornersImg(mContext, "", getView(R.id.iv_goodsCover))
            setText(R.id.tv_goodsTitle, "小罐茶茶具茶水分离杯")
            setText(R.id.tv_goodsMoney, "￥ 1280")
            val number = "22"
            val content = "有${number}人已跟随购买"
            val stringBuilder = SpannableStringBuilder(content)
            val foregroundColorSpan = ForegroundColorSpan(Color.parseColor("#FE4C4C"))
            stringBuilder.setSpan(
                foregroundColorSpan, 1, number.length + 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setText(R.id.tv_num, stringBuilder)

            setText(R.id.bt_messageLabel, "越努力越幸运")
            setText(R.id.v_locationLabel, "重庆解放碑")
            setGone(R.id.iv_hot, true)
            setText(R.id.tv_praiseNum, "102赞")

            val name = "风一样的绿女子："
            val content2 = "${name}如果你不出去走走，你就会以为这就是世界。"
            val stringBuilder2 = SpannableStringBuilder(content2)
            val foregroundColorSpan2 = ForegroundColorSpan(Color.parseColor("#57578F"))
            stringBuilder2.setSpan(
                foregroundColorSpan2, 0, name.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setText(R.id.tv_commentContent, stringBuilder2)

            setText(R.id.tv_comment, "12")
            setText(R.id.tv_praise, "18")


            addOnClickListener(R.id.tv_more, R.id.bt_messageLabel, R.id.v_locationLabel)
        }

    }
}
