package com.mryan_ActivityLife.test;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 *  属性动画的特点：动画效果会改变控件的位置.且开启动画的是动画对象,而不是控件对象.
 *  只有旋转的属性动画是经常用的,注意参数.
 *  注意:这些方法都是安卓在3.0以后出现的新特性,所以要把AndroidManifest.xml里的android:minSdkVersion值修改为11以上
 */
//注释后面有222的暂时不用管.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private ImageButton imageView;
    private Button alpha_bt;
    private Button rotationY_bt;
    private Button scaleX_bt;
    private Button translationX_bt;
    private Button AnimatorSet_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //对控件进行初始化
        initVeiw();
        //此处用的是xml的形式.引用在Xml里的属性动画资源. AnimatorInflater.loadAnimator(上下文,R.animator..)222
        //创建一个animator包,再在里面写XML文件做我们需要的动画资源
        Animator Xmlanimator = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);
        //  把要做动画控件对象放进去.Animator.setTarget(View对象);222
        Xmlanimator.setTarget(imageView);
       //开启动画.Animator.start.222
        Xmlanimator.start();


    }
    // 对于控件进行初始化
    private void initVeiw() {
        //找到ImageView控件对象
        imageView = (ImageButton) findViewById(R.id.animation_iv);
        //找到Button控件对象.
        alpha_bt = (Button) findViewById(R.id.alpha_bt);
        rotationY_bt = (Button) findViewById(R.id.rotationY_bt);
        scaleX_bt = (Button) findViewById(R.id.scaleX_bt);
        translationX_bt = (Button) findViewById(R.id.translationY_bt);
        AnimatorSet_bt=(Button)findViewById(R.id.AnimatorSet_bt);
        //为button设置点击事件
        alpha_bt.setOnClickListener(this);
        rotationY_bt.setOnClickListener(this);
        scaleX_bt.setOnClickListener(this);
        translationX_bt.setOnClickListener(this);
        AnimatorSet_bt.setOnClickListener(this);
    }

    /**
     * 根据点击事件类型.调用控件做属性动画的
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alpha_bt:
                //做透明动画,参数1:View,代表你要修改那个控件的属性. 参数2:propertyName代表实现什么样子的动画:"alpha",String类型.
                //参数3:float... values,控件修改的参数,new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f}
                ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f});
                //设置动画执行时长.setDuration   看我们需要的时长了
                alpha.setDuration(2000);
                //设置动画执行的模式setRepeatMode,参数用ObjectAnimator引用.
                alpha.setRepeatMode(ObjectAnimator.RESTART);
                //设置动画执行的次数.setRepeatCount
                alpha.setRepeatCount(1);
                //使用ObjectAnimator对象开启动画.
                alpha.start();

                break;
            case R.id.rotationY_bt:
                //做旋转动画,"rotationY".rotationX,rotation  new float[]{90f, 180f, 270f, 360f}
                ObjectAnimator rotationY = ObjectAnimator.ofFloat(imageView, "rotationY", new float[]{90f, 180f, 270f, 360f});
                rotationY.setDuration(2000);
                rotationY.setRepeatMode(ObjectAnimator.RESTART);
                rotationY.setRepeatCount(1);
                rotationY.start();
                break;
            case R.id.scaleX_bt:
                //做缩放动画,scaleX,scaleY  new float[]{1f, 2f, 3f, 4f, 5f, 6f,1f}
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1f, 2f, 3f, 4f, 5f, 6f,1f});
                scaleX.setDuration(2000);
                scaleX.setRepeatMode(ObjectAnimator.RESTART);
                scaleX.setRepeatCount(1);
                scaleX.start();

                break;
            case R.id.translationY_bt:
                //做平移动画,translationY,translationX new float[]{10f, 20f, 30f, 40f, 60f, 80f}
                ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, "translationY", new float[]{10f, 20f, 30f, 40f, 60f, 80f});
                translationY.setDuration(2000);
                translationY.setRepeatMode(ObjectAnimator.RESTART);
                translationY.setRepeatCount(1);
                translationY.start();

                //做动画集合AnimatorSet,分别创建两个动画对象.注意playTogether(动画对象...)和playSequentially的区别.最后开启动画.start
            case R.id.AnimatorSet_bt:
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator oa = ObjectAnimator.ofFloat(imageView, "translationX", new float[]{10f,20f,30f,40f,60f,80f});
                oa.setDuration(3000);
                ObjectAnimator oa2 = ObjectAnimator.ofFloat(imageView, "translationY", new float[]{-10f,-20f,-30f,-40f,-60f,-80f});
                oa2.setDuration(3000);
                set.playTogether(oa,oa2);
                set.start();

                break;

            default:
                break;
        }
    }

    /**
     * 根据点击事件,使imagButton吐丝一段话,"送你一个美女."
     */

    public void yyyy(View v){
        //成功后的吐丝
        Toast.makeText(this, "美女来了", Toast.LENGTH_SHORT).show();
    }
}
