package edu.feicui.app.base.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/30 0030.
 */
public class BasePagerAdapter extends PagerAdapter{
    protected Context context;
    private ArrayList<View> viewArrayList=new ArrayList<View>();
    private ArrayList<String> tabtitleList=new ArrayList<String>();

    public BasePagerAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<View> getViewArrayList(){
        return viewArrayList;
    }

    public void addView(View view){
        viewArrayList.add(view);
    }

    public void addTab(String title){
        tabtitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitleList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=viewArrayList.get(position);
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=viewArrayList.get(position);
        container.addView(view);
        return  view;
    }

    @Override
    public int getCount() {
        return viewArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
