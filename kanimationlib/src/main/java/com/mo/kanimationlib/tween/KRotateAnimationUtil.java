package com.mo.kanimationlib.tween;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;

import com.mo.kanimationlib.KAnimationUtil;
import com.mo.kanimationlib.KAnimatorListener;

/**
 * @ author：mo
 * @ data：2019/6/26:13:50
 * @ 功能：旋转动画
 */
public class KRotateAnimationUtil {
    /**
     * 获取一个根据视图自身中心点旋转的动画
     *
     * @param interpolator   动画插入器
     * @param durationMillis 动画持续时间
     * @param listener       动画监听器
     * @return 一个根据中心点旋转的动画
     */
    public static Animation getRotateAnimationByCenter(Interpolator interpolator, long durationMillis, KAnimatorListener listener) {
        return getRotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, interpolator, durationMillis, listener);
    }

    /**
     * 获取一个旋转动画
     *
     * @param fromDegrees    开始角度
     * @param toDegrees      结束角度
     * @param pivotXType     旋转中心点X轴坐标相对类型
     * @param pivotXValue    旋转中心点X轴坐标
     * @param pivotYType     旋转中心点Y轴坐标相对类型
     * @param pivotYValue    旋转中心点Y轴坐标
     * @param interpolator   动画插入器
     * @param durationMillis 持续时间
     * @param listener       动画监听器
     * @return 一个旋转动画
     */
    public static Animation getRotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue
            , Interpolator interpolator, long durationMillis, KAnimatorListener listener) {
        return KAnimationUtil.getAnimation(new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue),
                interpolator, durationMillis, listener);
    }
    public static Animation getRotateAnimation(float fromDegrees, float toDegrees, float pivotXValue, float pivotYValue
            , Interpolator interpolator, long durationMillis, KAnimatorListener listener) {
        return KAnimationUtil.getAnimation(new RotateAnimation(fromDegrees, toDegrees, pivotXValue, pivotYValue),
                interpolator, durationMillis, listener);
    }

}
