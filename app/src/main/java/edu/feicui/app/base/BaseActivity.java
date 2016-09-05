package edu.feicui.app.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;
import edu.feicui.app.base.util.LogUtil;

/**
 * Created by Administrator on 2016/8/30 0030.
 */
public abstract class BaseActivity extends AppCompatActivity{
    private  static String tag="代码测试";
    private static ArrayList<BaseActivity> list=new ArrayList<BaseActivity>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        LogUtil.d(tag,getClass().getSimpleName()+"onCreate");
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(tag,getClass().getSimpleName()+"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(tag,getClass().getSimpleName()+"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(tag,getClass().getSimpleName()+"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(tag,getClass().getSimpleName()+"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(tag,getClass().getSimpleName()+"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(tag,getClass().getSimpleName()+"onDestroy");

        //清空Activity
        if(list.contains(this)){
            list.remove(this);
        }
    }

    //通过迭代器依次关闭所有的Activity

    public static void finishAll(){
        Iterator<BaseActivity> iterator=list.iterator();
        while(iterator.hasNext()){
            iterator.next().finish();
        }
    }

    //普通跳转
    protected void startActivity(Class<?> targetClass) {
        Intent intent = new Intent(this,targetClass);
        startActivity(intent);
    }

    //内部类跳转
    protected void startActivity(Context context, Class<?> targetClass) {

        Intent intent = new Intent(context,targetClass);
        startActivity(intent);
    }

    //传递参数的跳转
    protected void startActivity(Class<?> targetClass, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //带动画的跳转
    protected void startActivity(Class<?> targetClass, int inAnimID,
                                 int outAnimID) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }

    //带动画跳转，并传递参数
    protected void startActivity(Class<?> targetClass, int inAnimID,
                                 int outAnimID, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }


}
