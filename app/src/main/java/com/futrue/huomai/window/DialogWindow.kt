package com.futrue.huomai.window


import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.WindowManager
import com.futrue.frame.base.dialog.BaseDialog
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.window_dialog.*

/**
 * @package    com.zhongde.haokuai.window
 * @anthor     luan
 * @date       2019/3/9
 * @des
 */
class DialogWindow(val activity: FragmentActivity, val title: String) : BaseDialog(activity),
    View.OnClickListener {


    override fun initView() {
        v_cancel.setOnClickListener { dismiss() }
        tv_title.text = title
        tv_confirm.setOnClickListener(this)
        v_cancel.setOnClickListener(this)
    }

    var onClick: () -> Unit = { }

    override fun onClick(v: View?) {
        when (v) {
            tv_confirm -> {
                onClick()
                dismiss()
            }
            v_cancel -> {
                dismiss()
            }
        }

    }

    override fun resetHeight(): Int = WindowManager.LayoutParams.MATCH_PARENT
    override fun resetWidth(): Int = WindowManager.LayoutParams.MATCH_PARENT

    override fun getLayoutID(): Int? = R.layout.window_dialog

}