package com.futrue.huomai.widget.tab

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.futrue.huomai.R

class TabItem : LinearLayout {
    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    var mText: TextView? = null
    var mDivide: View? = null
    var mTextStr: String? = null

    fun initView(context: Context, attrs: AttributeSet?) {
        attrs?.apply {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.TabItem)
            mTextStr = attributes.getString(R.styleable.TabItem_text)
            attributes.recycle()
        }
        val inflate =
            LayoutInflater.from(context).inflate(R.layout.view_tab_item, null, false) as ViewGroup
        addView(inflate)
        mDivide = inflate.getChildAt(0)
        mText = inflate.getChildAt(1) as? TextView
        mText?.text = mTextStr ?: ""
    }
}