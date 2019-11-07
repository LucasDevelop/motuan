package com.futrue.huomai.main.look.recommend

import android.os.Bundle
import com.futrue.frame.base.fragment.BaseRefreshListFragment
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.R
import com.futrue.huomai.main.home.video.location.LocationActivity
import com.futrue.huomai.main.home.video.topic.TopicInfoActivity
import com.futrue.huomai.main.look.detail.LookDetailActivity
import com.futrue.huomai.main.look.label.LabelActivity

/**
 * @package    DynamicFragment.kt
 * @author     luan
 * @date       2019-11-07
 * @des        动态列表
 */
class DynamicFragment : BaseRefreshListFragment<DynamicPresenter, IBean, RecommendAdapter>() {

    companion object {
        //入口
        val TYPE_RECOMMEND = 0//推荐
        val TYPE_LOCATION = 0//地图
        val TYPE_TOPIC = 0//话题

        fun getNewInstance(type: Int): DynamicFragment {
            val bundle = Bundle()
            bundle.putInt("type", type)
            return DynamicFragment().apply { arguments = bundle }
        }
    }

    override fun getLayoutID(): Int = R.layout.fragment_recommend
    val type: Int by lazy { arguments?.getInt("type") ?: TYPE_RECOMMEND }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
        mBaseAdapter.setNewData(List(10) {
            IBean()
        })
    }

    override fun initEvent() {
        mBaseAdapter.setOnItemClickListener { adapter, view, position ->
            LookDetailActivity.launch(mActivity)
        }

        mBaseAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.tv_more -> {
                }
                R.id.bt_messageLabel -> {
//                    LabelActivity.launch(mActivity)
                    if (mActivity !is TopicInfoActivity)
                        TopicInfoActivity.launch(this, TopicInfoActivity.TYPE_DYNAMIC)
                }
                R.id.v_locationLabel -> {
                    if (mActivity !is LocationActivity)
                        LocationActivity.launch(this, LocationActivity.TYPE_DYNAMIC)
                }
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {
    }

    override fun loadMoreListRequest(page: Int) {
    }

}


