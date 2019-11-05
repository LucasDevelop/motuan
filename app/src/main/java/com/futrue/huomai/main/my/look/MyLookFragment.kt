package com.futrue.huomai.main.my.look

import android.os.Bundle
import com.futrue.huomai.R
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.home.personaldetails.personallook.PersonalLookAdapter
import com.futrue.huomai.main.home.video.VideoPlayerActivity
/**
 * @package    MyLookFragment.kt
 * @author     luan
 * @date       2019-11-05
 * @des        看看
 */
class MyLookFragment : BaseRefreshListFragment<MyLookPresenter, IBean, PersonalLookAdapter>() {


    override fun getLayoutID(): Int = R.layout.fragment_my_look

    override fun initView(savedInstanceState: Bundle?) {
        mSwipeRefreshLayout.isEnabled = false
        mBaseAdapter.setNewData(List(1) {
            IBean()
        })
//        mRecyclerView?.isNestedScrollingEnabled = false
    }

    override fun initData() {
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            VideoPlayerActivity.launch(mActivity)
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


