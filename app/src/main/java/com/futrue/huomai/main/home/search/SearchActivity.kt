package com.futrue.huomai.main.home.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import com.chad.library.adapter.base.BaseQuickAdapter
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseNetActivity<SearchPresenter>(), View.OnClickListener,
    BaseQuickAdapter.OnItemClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mVals = arrayOf(
        "Hello", "Android", "Weclome Hi ", "Button",
        "TextView", "Hello", "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
        "Android", "Weclome Hello", "Button Text", "TextView"
    )

    private val mHistoryAdapter = HistoryAdapter()
    private val mContentAdapter = ContentAdapter()

    override fun getLayoutID(): Int = R.layout.activity_search

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        flowLayout.adapter = object : TagAdapter<String>(mVals) {
            override fun getView(parent: FlowLayout, position: Int, s: String): View {
                val tv =
                    layoutInflater.inflate(R.layout.item_tv, flowLayout, false) as QMUIRoundButton
                tv.text = s
                return tv
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mHistoryAdapter
        mHistoryAdapter.setNewData(List(2) { IBean() })

        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = mContentAdapter
        mContentAdapter.setNewData(List(3) { IBean() })
    }

    override fun initEvent() {

        arrayOf(tv_cancel, tv_refresh).setOnClickListener(this)
        et_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                if (et_search.text.isEmpty()){
//                    "请输入shousu".showToast()
//                    return@setOnEditorActionListener true
//                }
//                SearchResultActivity.launch(this@SearchActivity, et_search.text.toString())
//                finish()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false

        }

        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mHandler.removeCallbacks(mRun)
                //延迟800ms，如果不再输入字符，则执行该线程的run方法
                mHandler.postDelayed(mRun, 800)
            }
        })
        mHistoryAdapter.onItemClickListener = this

        flowLayout.setOnTagClickListener { view, position, parent ->
            return@setOnTagClickListener true
        }


    }

    val mRun = Runnable {
        val content = et_search.text.trim().toString()
        if (content.isNotEmpty()) {
            rv_content.visibility = View.VISIBLE
        } else {
            rv_content.visibility = View.GONE
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_cancel -> {

            }
            tv_refresh -> {

            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        if (adapter is HistoryAdapter) {

        } else {

        }
    }

}

