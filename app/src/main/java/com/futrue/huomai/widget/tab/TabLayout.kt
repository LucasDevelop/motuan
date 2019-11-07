package com.futrue.huomai.widget.tab

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import com.futrue.huomai.R

class TabLayout : LinearLayout {
    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    val list = ArrayList<TabItem>()
    var onTabClick: (position: Int, tab: TabItem) -> Unit = {position, tab ->  }

    fun initView(context: Context) {
        viewTreeObserver.addOnGlobalLayoutListener(object :ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                for (i in 0 until childCount) {
                    val childAt = getChildAt(i)
                    if (childAt is TabItem) {
                        list.add(childAt)
                        childAt.setOnClickListener {
                            val position = list.indexOf(it)
                            selectTab(position)
                            onTabClick(position, childAt)
                        }
                    }
                }
                selectTab(0)
            }

        })
    }

    fun selectTab(position: Int) {
        if (position > list.size - 1 || position < 0)
            return
        list.forEach {
            if (list.indexOf(it) == position) {
                it.mText?.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                    setTextColor(resources.getColor(R.color.textColor))
                }
                it.mDivide?.visibility = View.VISIBLE
            } else {
                it.mText?.apply {
                    typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                    setTextColor(resources.getColor(R.color.gray_text))
                }
                it.mDivide?.visibility = View.INVISIBLE
            }
        }
    }
}