package com.futrue.huomai.widget

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.futrue.huomai.R
import kotlinx.android.synthetic.main.widget_code_view.view.*

/**
 * @package    com.zhongde.haokuai.widget
 * @anthor     luan
 * @date       2019/3/1
 * @des        验证码控件
 */
class VerifyCodeView : LinearLayout {
    constructor(context: Context?) : super(context) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    lateinit var inflate: ViewGroup
    //输入完成回调
    var onInputComplete: (code: String) -> Unit = {}
    //输入不完整
    var onInputIncomplete: () -> Unit = {}

    //布局初始化
    private fun initView(context: Context?) {
        inflate = LayoutInflater.from(context).inflate(R.layout.widget_code_view, null) as ViewGroup
        addView(inflate)
        //限制长度
        v_code1.filters = arrayOf(InputFilter.LengthFilter(1))
        v_code2.filters = arrayOf(InputFilter.LengthFilter(1))
        v_code3.filters = arrayOf(InputFilter.LengthFilter(1))
        v_code4.filters = arrayOf(InputFilter.LengthFilter(1))
        initEvent(context)
    }

    //事件初始化
    private fun initEvent(context: Context?) {
        //监听edittext内容变化
        v_code1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                //如果输入长度等于1，将焦点交给下一个控件
                if (s.isNotEmpty()) {
                    v_code2.requestFocus()
                }
                if (s.isEmpty())
                    onInputIncomplete()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        v_code2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                //如果输入长度等于1，将焦点交给下一个控件
                if (s.isNotEmpty()) {
                    v_code3.requestFocus()
                }
                if (s.isEmpty())
                    onInputIncomplete()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        v_code2.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && (v as EditText).text.isEmpty()) {
                v_code1.requestFocus()
            }
            return@setOnKeyListener false
        }
        v_code3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                //如果输入长度等于1，将焦点交给下一个控件
                if (s.isNotEmpty()) {
                    v_code4.requestFocus()
                }
                if (s.isEmpty())
                    onInputIncomplete()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        v_code3.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && (v as EditText).text.isEmpty()) {
                v_code2.requestFocus()
            }
            return@setOnKeyListener false
        }
        v_code4.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                //如果输入长度等于1，输入完成
                if (s.isNotEmpty()) {
                    val t1 = v_code1.text.toString().trim()
                    val t2 = v_code2.text.toString().trim()
                    val t3 = v_code3.text.toString().trim()
                    val t4 = v_code4.text.toString().trim()
                    onInputComplete(t1 + t2 + t3 + t4)
                }
                if (s.isEmpty())
                    onInputIncomplete()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        v_code4.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && (v as EditText).text.isEmpty()) {
                v_code3.requestFocus()
            }
            return@setOnKeyListener false
        }
    }

    fun getCode(): String {
        val t1 = v_code1.text.toString().trim()
        val t2 = v_code2.text.toString().trim()
        val t3 = v_code3.text.toString().trim()
        val t4 = v_code4.text.toString().trim()
        return t1 + t2 + t3 + t4
    }
}