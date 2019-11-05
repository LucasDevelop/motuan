package com.futrue.frame.helper

import android.app.Activity
import android.arch.lifecycle.LifecycleObserver
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * 通用型工具
 */
interface CommentHelper : LifecycleObserver {


    /**
     * 扩展函数
     * 对Any对象扩展toString方法，消除空指针异常
     */
    fun Any?.ts(): String = if (this == null) "null" else toString()

    /**
     * 对Any对象扩展log方法
     */
    fun Any?.ld(tag: String = "frame") {
        LogUtils.d(tag, this.toString())
    }

    fun Any?.le(tag: String = "frame") {
        LogUtils.e(tag, this.toString())
    }

    fun String.showToast() {
        ToastUtils.showShort(this)
        //判断当前线程是否是主线程
    }

    /**
     * 资源获取
     */
    fun Activity.getResStr(strIdRes: Int) = this.resources.getString(strIdRes) ?: "null"

    fun Activity.getResColor(colorIdRes: Int) = this.resources.getColor(colorIdRes)

    //三元运算
    infix fun <A> A?.T(isFalse: A): A {
        if (this == null || (this is String && this == "")) {
            return isFalse
        } else
            return this
    }

    //设置点击事件
    infix fun Array<out View>.setOnClickListener(listener: View.OnClickListener) {
        this.forEach { it.setOnClickListener(listener) }
    }

    //表单验证
    fun Map<String, Boolean>.formCheck(callback: () -> Unit = {}): Boolean {

        this.forEach {
            if (it.value) {
                ToastUtils.showLong(it.key)
                return false//未通过
            }
        }
        //调用回掉
        callback()
        return true//验证通过
    }

    //绑定生命周期
    fun bindLifeCycle(context: Context) {
        (context as? AppCompatActivity)?.lifecycle?.addObserver(this)
    }

    //解除绑定
    fun unbindLifeCycle(context: Context) {
        (context as? AppCompatActivity)?.lifecycle?.removeObserver(this)
    }



    //显示布局
    fun View.showView() {
        visibility = View.VISIBLE
    }

    //隐藏布局
    fun View.hideView(isGone: Boolean = true) {
        if (isGone)
            visibility = View.GONE
        else
            visibility = View.INVISIBLE
    }

    //连接TextView与edittext
    fun TextView.with(vararg editText: EditText) {
        editText.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var isClick = true
                    editText.forEach {
                        isClick = it.text.toString().trim().isNotEmpty() && isClick
                    }
                    isEnabled = isClick
                }
            })
        }
    }


    //连接TextView与edittext
    fun Button.with(vararg editText: EditText) {
        editText.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var isClick = true
                    editText.forEach {
                        isClick = it.text.toString().trim().isNotEmpty() && isClick
                    }
                    isEnabled = isClick
                }
            })
        }
    }

    //连接TextView与edittext和delView
    fun TextView.with(editText: EditText, delView: View) {
        delView.setOnClickListener { editText.setText("") }
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val notEmpty = s.toString().trim().isNotEmpty()
                isEnabled = notEmpty
                delView.visibility = if (notEmpty) View.VISIBLE else View.GONE
            }
        })
    }

    //关联EditText与Text  计数
    fun EditText.withCount(submitView: TextView, countV: TextView, maxSize: Int) {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                countV.text = "${s?.length}/$maxSize"
                submitView.isEnabled = s?.isNotEmpty() ?: false
            }
        })
    }

    fun TextView.setTextOrNull(t:CharSequence?){
        text = t?:""
    }
}