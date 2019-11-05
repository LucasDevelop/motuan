package com.futrue.huomai.main.my.usercenter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import com.blankj.utilcode.util.TimeUtils
import com.futrue.huomai.R
import com.futrue.frame.base.activity.BaseNetActivity
import com.futrue.frame.data.api.BaseModel
import com.futrue.frame.data.bean.IBean
import com.futrue.huomai.main.my.usercenter.intro.IntroActivity
import com.futrue.huomai.main.my.usercenter.settext.SetTextActivity
import com.futrue.huomai.main.my.usercenter.userhead.UserHeadActivity
import com.futrue.huomai.utils.CityDataUtils
import com.futrue.huomai.utils.GlideUtil
import com.futrue.huomai.window.SexPopup
import kotlinx.android.synthetic.main.activity_user_center.*
import java.text.SimpleDateFormat
import java.util.*
import com.blankj.utilcode.util.SnackbarUtils.dismiss
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnOptionsSelectListener
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import com.bigkoo.pickerview.view.OptionsPickerView
import com.trello.rxlifecycle2.RxLifecycle.bindUntilEvent
import kotlinx.android.synthetic.main.pickerview_custom_options.*


class UserCenterActivity : BaseNetActivity<UserCenterPresenter>(), View.OnClickListener {


    companion object {
        fun launch(activity: Activity) {
            val intent = Intent(activity, UserCenterActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private val mSexPopup by lazy { SexPopup(this) }
    private lateinit var mCustomTime: TimePickerView
    private lateinit var mCustomOptions: OptionsPickerView<Any>
    private lateinit var mIvPublic: ImageView
    private lateinit var mIvFirend: ImageView
    private lateinit var mIvSelf: ImageView
    private var mTimeTyep = -1
    private var options1Items = ArrayList<JsonBean>()
    private val options2Items = ArrayList<ArrayList<String?>>()
    private val options3Items = ArrayList<ArrayList<ArrayList<String>>>()


    override fun getLayoutID(): Int = R.layout.activity_user_center

    override fun initView(savedInstanceState: Bundle?) {
        setToolbar("编辑个人资料")
        mCustomTime = initCustomTimePicker()
        mCustomOptions = initCustomOptionPicker()
    }

    override fun initData() {
        CityDataUtils.initJsonData(this) { item1, item2, item3 ->
            options1Items.addAll(item1)
            options2Items.addAll(item2)
            options3Items.addAll(item3)
            mCustomOptions.setPicker(
                options1Items as List<Any>?,
                options2Items as List<MutableList<Any>>?,
                options3Items as List<MutableList<MutableList<Any>>>?
            )
        }
        GlideUtil.loadRoundImg(this, "", iv_head)
        tv_name.text = "风一样的女子"
        tv_id.text = "123456789"
        tv_sex.text = "女"
        bt_sex.visibility = View.VISIBLE
        bt_sex.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.woman, 0, 0, 0)
        tv_birthday.text = "1991-11-12/射手座"
        tv_birthdayType.text = "年龄好友可见"
        tv_address.text = "重庆 渝中区"
        tv_intro.text = "你曾经说，最大的愿望，最大的愿望，就是去旅..."

    }

    override fun initEvent() {
        arrayOf(ll_head, ll_name, ll_id, ll_sex, ll_birthday, ll_address, ll_intro)
            .setOnClickListener(this)
        mSexPopup.onClick = {
            if (it == SexPopup.man) {

            } else {

            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_head -> {
                UserHeadActivity.launch(this)
            }
            R.id.ll_name -> {
                SetTextActivity.launch(this, SetTextActivity.name)
            }
            R.id.ll_id -> {
                SetTextActivity.launch(this, SetTextActivity.id)
            }
            R.id.ll_sex -> {
                mSexPopup.showAtLocation(v, Gravity.CENTER, 0, 0)
            }
            R.id.ll_birthday -> {
                mCustomTime.show()
            }
            R.id.ll_address -> {
                mCustomOptions.show()
            }
            R.id.ll_intro -> {
                IntroActivity.launch(this)
            }
            R.id.tv_cancel -> {
                mCustomTime.dismiss()
            }
            R.id.tv_confirm -> {
                mCustomTime.returnData()
                mCustomTime.dismiss()
            }
            R.id.rl_public -> {
                mTimeTyep = 0
                mIvPublic.visibility = View.VISIBLE
                mIvFirend.visibility = View.GONE
                mIvSelf.visibility = View.GONE
            }
            R.id.rl_firend -> {
                mTimeTyep = 1
                mIvPublic.visibility = View.GONE
                mIvFirend.visibility = View.VISIBLE
                mIvSelf.visibility = View.GONE
            }
            R.id.rl_self -> {
                mTimeTyep = 2
                mIvPublic.visibility = View.GONE
                mIvFirend.visibility = View.GONE
                mIvSelf.visibility = View.VISIBLE
            }
            R.id.tv_optionsCancel -> {
                mCustomOptions.dismiss()
            }
            R.id.tv_optionsConfirm -> {
                mCustomOptions.returnData()
                mCustomOptions.dismiss()
            }
        }
    }

    override fun requestSuccess(bean: IBean, requestMode: BaseModel.RequestMode, requestTag: Any) {

    }


    private fun initCustomTimePicker(): TimePickerView {
        //时间选择器 ，自定义布局
        return TimePickerBuilder(this, OnTimeSelectListener { date, v ->
            val time = TimeUtils.date2String(
                date, SimpleDateFormat(
                    "yyyy-MM-dd",
                    Locale.getDefault()
                )
            )
            val zodiac = TimeUtils.getZodiac(date)
            //选中事件回调
            tv_birthday.text = "${time}/$zodiac"
        }).setLayoutRes(R.layout.pickerview_custom_time) {
            it.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(this)
            it.findViewById<TextView>(R.id.tv_confirm).setOnClickListener(this)
            it.findViewById<RelativeLayout>(R.id.rl_public).setOnClickListener(this)
            it.findViewById<RelativeLayout>(R.id.rl_firend).setOnClickListener(this)
            it.findViewById<RelativeLayout>(R.id.rl_self).setOnClickListener(this)
            mIvPublic = it.findViewById(R.id.iv_public)
            mIvFirend = it.findViewById(R.id.iv_firend)
            mIvSelf = it.findViewById(R.id.iv_self)

        }
            .setContentTextSize(20)
            .setTextColorCenter(getResColor(R.color.yellow_FECC32))
            .setTextColorOut(getResColor(R.color.textColor))
            .setType(booleanArrayOf(true, true, true, false, false, false))
            .setLabel("年", "月", "日", "时", "分", "秒")
            .setLineSpacingMultiplier(2f)
            .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
            .build()
    }


    private fun initCustomOptionPicker(): OptionsPickerView<Any> {//条件选择器初始化，自定义布局

        return OptionsPickerBuilder(this,
            OnOptionsSelectListener { options1, option2, options3, v ->
                val opt1tx = options1Items[options1].pickerViewText
                val opt2tx = options2Items[options1][option2]
                val opt3tx = options3Items[options1][option2][options3]
                tv_address.text = opt1tx + opt2tx + opt3tx
            })
            .setLayoutRes(R.layout.pickerview_custom_options) {
                it.findViewById<TextView>(R.id.tv_optionsCancel).setOnClickListener(this)
                it.findViewById<TextView>(R.id.tv_optionsConfirm).setOnClickListener(this)
            }
            .setContentTextSize(20)
            .setTextColorCenter(getResColor(R.color.yellow_FECC32))
            .setTextColorOut(getResColor(R.color.textColor))
            .setLineSpacingMultiplier(2f)
            .build<Any>()
    }


}

