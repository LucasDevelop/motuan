package com.futrue.huomai.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.*
import android.widget.TextView


object AnimUtil {

    fun rotate(): Animation {
        val translateAnimation =
            RotateAnimation(0f, 360*100f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        translateAnimation.interpolator = LinearInterpolator()
        translateAnimation.repeatCount = 100000
        translateAnimation.duration = 6000*100
        return translateAnimation
    }


    fun scaleTextSize(v: TextView, startSize: Float, endSize: Float) {
        val animator = ValueAnimator.ofFloat(startSize, endSize)
        animator.duration = 350
        animator.addUpdateListener {
            v.textSize = it.animatedValue as Float
        }
        animator.start()
    }
}