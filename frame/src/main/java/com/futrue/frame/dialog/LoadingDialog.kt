package com.futrue.frame.dialog

import android.content.Context
import com.futrue.frame.R
import com.futrue.frame.base.dialog.BaseDialog

/**
 *  通用小菊花
 */
class LoadingDialog(context: Context, var isCancel: Boolean = false) : BaseDialog(context) {
    override fun initView() {
        setCanceledOnTouchOutside(isCancel)

    }

    override fun onBackPressed() {
        if (isCancel)
            super.onBackPressed()
    }

    override fun getLayoutID(): Int? = R.layout.frame_dialog_loading
}