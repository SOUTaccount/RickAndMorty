package com.stebakov.core.wrappers

import android.animation.Animator

/**
 * Created by Vladimir Stebakov on 12.07.2022
 */
interface AnimatorWrapper : Animator.AnimatorListener {
    override fun onAnimationCancel(p0: Animator?) {}
    override fun onAnimationEnd(p0: Animator?) {}
    override fun onAnimationRepeat(p0: Animator?) {}
    override fun onAnimationStart(p0: Animator?) {}
}