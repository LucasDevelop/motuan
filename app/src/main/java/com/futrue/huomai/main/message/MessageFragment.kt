package com.futrue.huomai.main.message

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.message.activitymsg.ActivityMsgActivity
import com.futrue.huomai.main.message.commentlist.CommentListActivity
import com.futrue.huomai.main.message.fenslist.FensListActivity
import com.futrue.huomai.main.message.priselist.PriseListActivity
import com.futrue.huomai.main.message.prviatelist.PrviateListActivity
import com.futrue.huomai.main.message.systemmsg.SystemMsgActivity

class MessageFragment : BaseRefreshListFragment<MessagePresenter, IBean, MessageAdapter>(),
    View.OnClickListener {


    private lateinit var mRlPrise: RelativeLayout
    private lateinit var mRlFens: RelativeLayout
    private lateinit var mRlComment: RelativeLayout
    private lateinit var mRlPrivate: RelativeLayout
    private lateinit var mTvPriseNum: TextView
    private lateinit var mTvFensNum: TextView
    private lateinit var mTvCommentNum: TextView


    override fun getLayoutID(): Int = R.layout.fragment_message


    override fun initView(savedInstanceState: Bundle?) {
        val view = layoutInflater.inflate(R.layout.head_message, mRecyclerView, false)
        view.apply {
            mRlPrise = findViewById(R.id.rl_prise)
            mRlFens = findViewById(R.id.rl_fens)
            mRlComment = findViewById(R.id.rl_comment)
            mRlPrivate = findViewById(R.id.rl_private)
            mTvPriseNum = findViewById(R.id.tv_priseNum)
            mTvFensNum = findViewById(R.id.tv_fensNum)
            mTvCommentNum = findViewById(R.id.tv_commentNum)
        }
        mBaseAdapter.addHeaderView(view)
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            when (position) {
                0 -> {
                    ActivityMsgActivity.launch(this)
                }
                1 -> {
                    SystemMsgActivity.launch(this)
                }
            }
        }
    }

    override fun initData() {
        mTvPriseNum.text = "1"
        mTvFensNum.text = "99"
        mTvCommentNum.text = "･･･"

        mBaseAdapter.setNewData(List(2) { IBean() })
    }

    override fun initEvent() {
        arrayOf(mRlPrise, mRlFens, mRlComment, mRlPrivate).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mRlPrise -> {
                PriseListActivity.launch(mActivity)
            }
            mRlFens -> {
                FensListActivity.launch(mActivity)
            }
            mRlComment -> {
                CommentListActivity.launch(mActivity)
            }
            mRlPrivate -> {
                PrviateListActivity.launch(mActivity)
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }


    override fun loadMoreListRequest(page: Int) {
    }

}


