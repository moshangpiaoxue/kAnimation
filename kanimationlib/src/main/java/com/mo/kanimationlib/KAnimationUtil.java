package com.mo.kanimationlib;

import android.view.animation.Animation;
import android.view.animation.Interpolator;

/**
 * @ author：mo
 * @ data：2019/6/26:14:19
 * @ 功能：
 */
public class KAnimationUtil {
    /**
     * 获取动画
     *
     * @param animation 原始动画
     * @param duration  持续时间
     * @param listener  监听
     * @return animation
     */
    public static Animation getAnimation(Animation animation, long duration, final KAnimatorListener listener) {
        return getAnimation(animation, null, duration, false, listener);
    }
    /**
     * 获取动画
     *
     * @param animation    原始动画
     * @param duration     持续时间
     * @param isFillAfter  是否停留在动画结束时的状态
     * @param listener     监听
     * @return animation
     */
    public static Animation getAnimation(Animation animation,  long duration, boolean isFillAfter, final KAnimatorListener listener) {
        return getAnimation(animation, null, duration, isFillAfter, listener);
    }
    /**
     * 获取动画
     *
     * @param animation    原始动画
     * @param interpolator 动画插入器
     * @param duration     持续时间
     * @param listener     监听
     * @return animation
     */
    public static Animation getAnimation(Animation animation, Interpolator interpolator, long duration, final KAnimatorListener listener) {
        return getAnimation(animation, interpolator, duration, false, listener);
    }

    /**
     * 获取动画
     *
     * @param animation    原始动画
     * @param interpolator 动画插入器
     * @param duration     持续时间
     * @param isFillAfter  是否停留在动画结束时的状态
     * @param listener     监听
     * @return animation
     */
    public static Animation getAnimation(Animation animation, Interpolator interpolator, long duration, boolean isFillAfter, final KAnimatorListener listener) {
        Long du = duration;
        if (listener != null) {
            animation.setAnimationListener(listener);
        }
        if (interpolator != null) {
            animation.setInterpolator(interpolator);
        }
        animation.setFillAfter(isFillAfter);
        animation.setDuration(du == null || du <= 0 ? KContacts.defultDuration : du);
        return animation;
    }


}
