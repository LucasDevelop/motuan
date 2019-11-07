package com.futrue.huomai.main.look.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.video.CommentAdapter
import com.futrue.huomai.main.look.detail.praiselist.PraiseListActivity
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.SharePopup
import kotlinx.android.synthetic.main.activity_look_detail.*
/**
 * @package    LookDetailActivity.kt
 * @author     luan
 * @date       2019-11-07
 * @des       动态详情
 */
class LookDetailActivity :
    BaseRefreshListActivity<LookDetailPresenter, IBean, CommentAdapter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, LookDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }


    val mShare by lazy { SharePopup(this) }

    override fun getLayoutID(): Int = R.layout.activity_look_detail


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("das", rightRes = R.mipmap.personal_share,
            rightClickListener = View.OnClickListener {
                mShare.showAtLocation(mRecyclerView, Gravity.CENTER, 0, 0)
            })
        initHeader()
        mSwipeRefreshLayout.isEnabled = false
        GlideUtil.loadRoundCornersImg(this, "", iv_head)
        val comment = et_comment.text.toString().trim()
        mBaseAdapter.setNewData(List(10) { IBean() })

    }

    private fun initHeader() {
        val view = layoutInflater.inflate(R.layout.head_look_detail, mRecyclerView, false)
        view.apply {
            findViewById<View>(R.id.v_follow).showView()
            arrayOf(R.id.v_praiseNum).forEach {
                findViewById<View>(it).setOnClickListener(this@LookDetailActivity)
            }
        }
        mBaseAdapter.addHeaderView(view)
    }


    override fun initData() {
//        GlideUtil.loadRoundImg(this, "", mIvHead)
//        mTvName.text = "好物博物馆"
//        mTvTime.text = "06-29 发布"
//        mBtAttention.text = "+ 关注"
//        mTvContent.text = "小罐茶功夫套装骨瓷茶具套组,体验升级，乐享茶香茶香。综合借鉴传统茶具，造型精髓，在此基\n" +
//                "础上加以改造，使茶具更简单，间接优雅，品味非凡。厚薄均匀的哑光蔓延茶具，彰显儒雅范。小罐茶功夫套装骨瓷茶具套组,体验升级，乐享茶香。综合借鉴传统茶具，厚薄均匀的哑光蔓延茶具，彰显儒雅风范。体验升级，乐享茶香。综合借鉴传统茶具，造型精髓。"
//
//        mLl1.visibility = View.VISIBLE
//        mIv1.visibility = View.VISIBLE
//        mIv2.visibility = View.VISIBLE
//        GlideUtil.loadRoundImg(this, "", mIv1)
//        GlideUtil.loadRoundImg(this, "", mIv2)
//        GlideUtil.loadRoundImg(this, "", mIvGoodsCover)
//        mTvGoodsTitle.text = "小罐茶茶具茶水分离杯"
//        mTvGoodsMoney.text = "￥ 1280.00"
//
//        val number = "22"
//        val content = "有${number}人已跟随购买"
//        val stringBuilder = SpannableStringBuilder(content)
//        val foregroundColorSpan = ForegroundColorSpan(Color.parseColor("#FE4C4C"))
//        stringBuilder.setSpan(
//            foregroundColorSpan, 1, number.length + 1,
//            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
//        )
//        mTvNum.text = stringBuilder
//        GlideUtil.loadRoundImg(this, "", mIvImg1)
//        GlideUtil.loadRoundImg(this, "", mIvImg2)
//        GlideUtil.loadRoundImg(this, "", mIvImg3)
//        mTvPraiseNum.text = "1250人赞过"
//        mTvLookNum.text = "浏览151156"
//        mTvCommentNum.text = "356 条评论"
//        mTvGoodsName.text = "认证：宜宾市小尼化妆品官方账号"
//        mTvGoodsNum.text = "共38件商品"
    }


    override fun initEvent() {
        mShare.onClick ={
            when(it){
                SharePopup.wechat ->{}
                SharePopup.friends ->{}
                SharePopup.report ->{}
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.v_praiseNum-> {//点赞列表
                PraiseListActivity.launch(this)
            }
            else -> {
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


