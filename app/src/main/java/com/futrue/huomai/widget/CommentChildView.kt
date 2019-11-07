package com.futrue.huomai.widget

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.futrue.huomai.R

/**
 * @package    CommentChildView.kt
 * @author     luan
 * @date       2019-11-06
 * @des        评论内容区
 */
class CommentChildView : FrameLayout {
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

    var rootView: ViewGroup? = null
    var contentStr: String = ""

    fun initView(context: Context) {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.view_comment_child,
            null,
            false
        ) as ViewGroup
        addView(rootView)
    }

    fun setContent(content: String) {
        contentStr = content
        rootView?.apply {
            val line1 = findViewById<TextView>(R.id.v_content_line1)
            line1.text = content
            //获取剩余未显示的字符串
            val lineEnd = line1.layout.getLineEnd(0)
            if (content.length == lineEnd) {//第一行已显示完，无需使用第二行显示

            } else {//启用第二行显示剩余字符
                val substring = content.substring(lineEnd, content.length)
                findViewById<TextView>(R.id.v_content_line2).text = substring
            }
        }
    }

    fun isHot(isHot: Boolean) {
        rootView?.apply {
            if (isHot) {
                findViewById<View>(R.id.v_hot_icon).visibility = View.VISIBLE
                findViewById<View>(R.id.v_hot_text).visibility = View.VISIBLE
            } else {
                findViewById<View>(R.id.v_hot_icon).visibility = View.GONE
                findViewById<View>(R.id.v_hot_text).visibility = View.GONE
            }
        }
    }

    //追加时间样式--调用该方法前需先调用setContent，否则追加时间位置会出错
    fun setTime(time: String) {
        rootView?.apply {
            val line1 = findViewById<TextView>(R.id.v_content_line1)
            val line2 = findViewById<TextView>(R.id.v_content_line2)
            //判断追加第几行
            if (line2.text.toString().isEmpty()) {//追加第一行
                line1.text = "${line1.text}  ${time}"
                //如果追加后超出一行，则放弃，改为追加到二行
                if (isSingleLine(line1)) {
                    line1.text = contentStr
                    initTimeStyle(line2, time)
                }else{
                    line1.text = contentStr
                    initTimeStyle(line1, time)
                }
            } else {//追加第二行
                line1.text = contentStr
                initTimeStyle(line2, time)
            }
        }
    }

    private fun initTimeStyle(line2: TextView, time: String) {
        line2.text = "${line2.text} $time"
        //修改时间样式
        val line2Str = line2.text
        val timeIndex = line2Str.indexOf(time)
        val builder = SpannableStringBuilder(line2Str)
        builder.setSpan(
            ForegroundColorSpan(Color.parseColor("#999999")),
            timeIndex,
            timeIndex + time.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        builder.setSpan(
            AbsoluteSizeSpan(11, true),
            timeIndex,
            timeIndex + time.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        line2.text = builder
    }

    //判断textview是否超出一行
    private fun isSingleLine(textView: TextView): Boolean {
        val lineEnd = textView.layout.getLineEnd(0)
        return textView.text.length > lineEnd
    }
}