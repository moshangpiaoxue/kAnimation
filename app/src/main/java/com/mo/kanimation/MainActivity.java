package com.mo.kanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.mo.kanimationlib.KAnimationUtil;
import com.mo.kanimationlib.property.KObjectAnimatorUtil;
import com.mo.kanimationlib.property.KValueAnimatorUtil;
import com.mo.kanimationlib.tween.KAlphaAnimationUtil;
import com.mo.kanimationlib.tween.KRotateAnimationUtil;
import com.mo.kanimationlib.tween.KScaleAnimationUtil;
import com.mo.kanimationlib.tween.KTranslateAnimationUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_main;
    private FrameLayout fl_obj;
    private ImageView iv_main0;
    private ImageView iv_main1;
    private ImageView iv_main2;
    private ImageView iv_main3;
    private ListView lv_main;
    private Button btn_value_open;
    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_main = findViewById(R.id.iv_main);
        fl_obj = findViewById(R.id.fl_obj);
        iv_main0 = findViewById(R.id.iv_main0);
        iv_main1 = findViewById(R.id.iv_main1);
        iv_main2 = findViewById(R.id.iv_main2);
        iv_main3 = findViewById(R.id.iv_main3);
        imageViewList.add(iv_main0);
        imageViewList.add(iv_main1);
        imageViewList.add(iv_main2);
        imageViewList.add(iv_main3);
        lv_main = findViewById(R.id.lv_main);
        findViewById(R.id.btn_alpha_xml).setOnClickListener(this);
        findViewById(R.id.btn_alpha_java).setOnClickListener(this);
        findViewById(R.id.btn_scale_xml).setOnClickListener(this);
        findViewById(R.id.btn_scale_java).setOnClickListener(this);
        findViewById(R.id.btn_translate_xml).setOnClickListener(this);
        findViewById(R.id.btn_translate_java).setOnClickListener(this);
        findViewById(R.id.btn_rotate_xml).setOnClickListener(this);
        findViewById(R.id.btn_rotate_java).setOnClickListener(this);
        findViewById(R.id.btn_set_xml).setOnClickListener(this);
        findViewById(R.id.btn_set_java).setOnClickListener(this);
        findViewById(R.id.btn_layout_open).setOnClickListener(this);
        findViewById(R.id.btn_layout_close).setOnClickListener(this);
        findViewById(R.id.btn_obj_open).setOnClickListener(this);
        findViewById(R.id.btn_obj_close).setOnClickListener(this);
        btn_value_open = findViewById(R.id.btn_value_open);
        btn_value_open.setOnClickListener(this);
        findViewById(R.id.btn_value_close).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha_xml:
                KAnimationUtil.setClickAnimation(v);
                iv_main.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
                break;
            case R.id.btn_alpha_java:
                iv_main.startAnimation(KAlphaAnimationUtil.getAlphaAnimation(0.1f, 1.0f, null, 2000, null));
                break;
            case R.id.btn_scale_xml:
                iv_main.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                break;
            case R.id.btn_scale_java:
                iv_main.startAnimation(KAnimationUtil.getAnimation(KScaleAnimationUtil.getScaleAnimation(
                        0.0f, 1.0f, 0.0f, 1.0f, 0.5f, 0.5f),
                        null, 2000L, null));
                break;
            case R.id.btn_translate_xml:
                iv_main.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
                break;
            case R.id.btn_translate_java:
                iv_main.startAnimation(KTranslateAnimationUtil.getTranslateAnimation(10f, 100f, 10f, 100f
                        , null, 2000, null));
                break;
            case R.id.btn_rotate_xml:
                iv_main.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
                break;
            case R.id.btn_rotate_java:
//                iv_main.startAnimation(KRotateAnimationUtil.getRotateAnimation(0f, 360f, 0.5f,
//                        0.5f, null, 2000, null));
                iv_main.startAnimation(KRotateAnimationUtil.getRotateAnimationByCenter(null, 2000, null));
                break;
            case R.id.btn_set_xml:
                iv_main.startAnimation(AnimationUtils.loadAnimation(this, R.anim.setalpha));
                break;
            case R.id.btn_set_java:
                AnimationSet set = new AnimationSet(true);
                Animation alphaAnimation = KAlphaAnimationUtil.getAlphaAnimation(0.1f, 1.0f, null, 2000, null);
                Animation animation = KRotateAnimationUtil.getRotateAnimationByCenter(null, 2000, null);
                set.addAnimation(alphaAnimation);
                set.addAnimation(animation);
                set.setStartOffset(2000);
                animation.setRepeatMode(Animation.REVERSE);
                iv_main.startAnimation(set);
                break;
            case R.id.btn_layout_open:
                lv_main.setVisibility(View.VISIBLE);
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("dafeig" + i);
                }
                lv_main.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
                LayoutAnimationController layoutAnimationController =
                        new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.scale));
                //item 出现顺序
                layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
                lv_main.setLayoutAnimation(layoutAnimationController);
                lv_main.startLayoutAnimation();
                break;
            case R.id.btn_layout_close:
                lv_main.clearAnimation();
                lv_main.setVisibility(View.GONE);
                break;
            case R.id.btn_obj_open:
                fl_obj.setVisibility(View.VISIBLE);
                for (int i = 1; i < imageViewList.size(); i++) {

                    ObjectAnimator translationY = KObjectAnimatorUtil.getObjectAnimator(imageViewList.get(i),
                            "translationY", new BounceInterpolator(), 500, 0f, i * 250f);
                    translationY.setStartDelay(300);
                    translationY.start();
                }
                break;
            case R.id.btn_obj_close:
                for (int i = 1; i < imageViewList.size(); i++) {
                    ObjectAnimator translationY = KObjectAnimatorUtil.getObjectAnimator(imageViewList.get(i),
                            "translationY", new BounceInterpolator(), 500, i * 250f, 0f);
                    translationY.setStartDelay(300);
                    translationY.start();
                }
                break;
            case R.id.btn_value_open:
                valueAnimator = KValueAnimatorUtil.getCountDwon(10, 0, new KValueAnimatorUtil.ChangeListener() {
                    @Override
                    public void onChange(int count) {
                        btn_value_open.setText("倒计时" + (count));
                    }
                });
                valueAnimator.start();
                break;
            case R.id.btn_value_close:
                valueAnimator.cancel();
                break;
            default:
                break;
        }
    }

    ValueAnimator valueAnimator;
}
