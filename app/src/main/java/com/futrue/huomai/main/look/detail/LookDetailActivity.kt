package com.futrue.huomai.main.look.detail

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.futrue.frame.base.activity.BaseRefreshListActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.look.detail.praiselist.PraiseListActivity
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.SharePopup
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton
import kotlinx.android.synthetic.main.activity_look_detail.*
import kotlinx.android.synthetic.main.activity_search.*

class LookDetailActivity :
    BaseRefreshListActivity<LookDetailPresenter, IBean, LookDetailAdapter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, LookDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }


    private lateinit var mIvHead: ImageView
    private lateinit var mTvName: TextView
    private lateinit var mTvTime: TextView
    private lateinit var mBtAttention: QMUIRoundButton
    private lateinit var mTvContent: TextView
    private lateinit var mLl1: LinearLayout
    private lateinit var mLl2: LinearLayout
    private lateinit var mLl3: LinearLayout
    private lateinit var mIv1: ImageView
    private lateinit var mIv2: ImageView
    private lateinit var mIv3: ImageView
    private lateinit var mIv4: ImageView
    private lateinit var mIv5: ImageView
    private lateinit var mIv6: ImageView
    private lateinit var mIv7: ImageView
    private lateinit var mIv8: ImageView
    private lateinit var mIv9: ImageView
    private lateinit var mIvGoodsCover: ImageView
    private lateinit var mTvGoodsTitle: TextView
    private lateinit var mTvGoodsMoney: TextView
    private lateinit var mTvNum: TextView
    private lateinit var mIvImg1: ImageView
    private lateinit var mIvImg2: ImageView
    private lateinit var mIvImg3: ImageView
    private lateinit var mTvPraiseNum: TextView
    private lateinit var mTvLookNum: TextView
    private lateinit var mLlShop: LinearLayout
    private lateinit var mTvGoodsName: TextView
    private lateinit var mTvGoodsNum: TextView
    private lateinit var mTvCommentNum: TextView
    private lateinit var mRlPraise: RelativeLayout
    val mShare by lazy { SharePopup(this) }

    override fun getLayoutID(): Int = R.layout.activity_look_detail


    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("das", rightRes = R.mipmap.personal_share,
            rightClickListener = View.OnClickListener {
                mShare.showAtLocation(mRecyclerView, Gravity.CENTER, 0, 0)
            })
        val view = layoutInflater.inflate(R.layout.head_look_detail, mRecyclerView, false)
        view.apply {
            mIvHead = findViewById(R.id.iv_head)
            mTvName = findViewById(R.id.tv_name)
            mTvTime = findViewById(R.id.tv_time)
            mBtAttention = findViewById(R.id.bt_attention)
            mTvContent = findViewById(R.id.tv_content)
            mLl1 = findViewById(R.id.ll_1)
            mLl2 = findViewById(R.id.ll_2)
            mLl3 = findViewById(R.id.ll_3)
            mIv1 = findViewById(R.id.iv_1)
            mIv2 = findViewById(R.id.iv_2)
            mIv3 = findViewById(R.id.iv_3)
            mIv4 = findViewById(R.id.iv_4)
            mIv5 = findViewById(R.id.iv_5)
            mIv6 = findViewById(R.id.iv_6)
            mIv7 = findViewById(R.id.iv_7)
            mIv8 = findViewById(R.id.iv_8)
            mIv9 = findViewById(R.id.iv_9)
            mIvGoodsCover = findViewById(R.id.iv_goodsCover)
            mTvGoodsTitle = findViewById(R.id.tv_goodsTitle)
            mTvGoodsMoney = findViewById(R.id.tv_goodsMoney)
            mTvNum = findViewById(R.id.tv_num)
            mIvImg1 = findViewById(R.id.iv_img1)
            mIvImg2 = findViewById(R.id.iv_img2)
            mIvImg3 = findViewById(R.id.iv_img3)
            mTvPraiseNum = findViewById(R.id.tv_praiseNum)
            mTvLookNum = findViewById(R.id.tv_lookNum)
            mLlShop = findViewById(R.id.ll_shop1)
            mTvGoodsName = findViewById(R.id.tv_goodsName)
            mTvGoodsNum = findViewById(R.id.tv_goodsNum)
            mTvCommentNum = findViewById(R.id.tv_commentNum)
            mRlPraise = findViewById(R.id.rl_praise)
        }

        mBaseAdapter.addHeaderView(view)

        mSwipeRefreshLayout.isEnabled = false
        GlideUtil.loadRoundCornersImg(this, "", iv_head)
        val comment = et_comment.text.toString().trim()

        mBaseAdapter.setNewData(List(10) { IBean() })
    }


    override fun initData() {
        GlideUtil.loadRoundImg(this, "", mIvHead)
        mTvName.text = "好物博物馆"
        mTvTime.text = "06-29 发布"
        mBtAttention.text = "+ 关注"
        mTvContent.text = "小罐茶功夫套装骨瓷茶具套组,体验升级，乐享茶香茶香。综合借鉴传统茶具，造型精髓，在此基\n" +
                "础上加以改造，使茶具更简单，间接优雅，品味非凡。厚薄均匀的哑光蔓延茶具，彰显儒雅范。小罐茶功夫套装骨瓷茶具套组,体验升级，乐享茶香。综合借鉴传统茶具，厚薄均匀的哑光蔓延茶具，彰显儒雅风范。体验升级，乐享茶香。综合借鉴传统茶具，造型精髓。"

        mLl1.visibility = View.VISIBLE
        mIv1.visibility = View.VISIBLE
        mIv2.visibility = View.VISIBLE
        GlideUtil.loadRoundImg(this, "", mIv1)
        GlideUtil.loadRoundImg(this, "", mIv2)
        GlideUtil.loadRoundImg(this, "", mIvGoodsCover)
        mTvGoodsTitle.text = "小罐茶茶具茶水分离杯"
        mTvGoodsMoney.text = "￥ 1280.00"

        val number = "22"
        val content = "有${number}人已跟随购买"
        val stringBuilder = SpannableStringBuilder(content)
        val foregroundColorSpan = ForegroundColorSpan(Color.parseColor("#FE4C4C"))
        stringBuilder.setSpan(
            foregroundColorSpan, 1, number.length + 1,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        mTvNum.text = stringBuilder
        GlideUtil.loadRoundImg(this, "", mIvImg1)
        GlideUtil.loadRoundImg(this, "", mIvImg2)
        GlideUtil.loadRoundImg(this, "", mIvImg3)
        mTvPraiseNum.text = "1250人赞过"
        mTvLookNum.text = "浏览151156"
        mTvCommentNum.text = "356 条评论"
        mTvGoodsName.text = "认证：宜宾市小尼化妆品官方账号"
        mTvGoodsNum.text = "共38件商品"
    }


    override fun initEvent() {
        arrayOf(mBtAttention, iv_expression, bt_send, mRlPraise).setOnClickListener(this)
        mShare.onClick ={
            when(it){
                SharePopup.wechat ->{}
                SharePopup.friends ->{}
                SharePopup.report ->{}
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            mBtAttention -> {

            }
            iv_expression -> {

            }
            bt_send -> {

            }
            mRlPraise -> {
                PraiseListActivity.launch(this)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


