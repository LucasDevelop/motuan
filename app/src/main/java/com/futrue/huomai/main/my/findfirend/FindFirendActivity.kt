package com.futrue.huomai.main.my.findfirend

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseActivity
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.my.findfirend.addressbook.AddressBookFragment
import com.futrue.huomai.main.my.findfirend.recommend.FindRecommendFragment
import kotlinx.android.synthetic.main.activity_find_firend.*

class FindFirendActivity : BaseNetActivity<FindFirendPresenter>() {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, FindFirendActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mFindRecommendFragment = FindRecommendFragment()
    private val mAddressBookFragment = AddressBookFragment()

    override fun getLayoutID(): Int = R.layout.activity_find_firend

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("发现好友")
        supportFragmentManager.beginTransaction()
            .add(R.id.rl_findContent, mFindRecommendFragment)
            .add(R.id.rl_findContent, mAddressBookFragment)
            .hide(mAddressBookFragment).commit()
    }

    override fun initData() {
    }

    override fun initEvent() {
        rl_recommend.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .hide(mAddressBookFragment).show(mFindRecommendFragment)
                .commit()
            tv_recommend.setTextColor(getResColor(R.color.textColor))
            tv_addressBook.setTextColor(getResColor(R.color.grey_999))
            v_recommend.visibility = View.VISIBLE
            v_addressBook.visibility = View.GONE
        }
        rl_addressBook.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .hide(mFindRecommendFragment).show(mAddressBookFragment)
                .commit()
            tv_recommend.setTextColor(getResColor(R.color.grey_999))
            tv_addressBook.setTextColor(getResColor(R.color.textColor))
            v_recommend.visibility = View.GONE
            v_addressBook.visibility = View.VISIBLE
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {

    }
}


