package edu.feicui.app.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import edu.feicui.app.base.BaseActivity;
import edu.feicui.app.base.adapter.BasePagerAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    TextView tv_skip;
    ViewPager viewPager;
    BasePagerAdapter adapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_skip= (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(this);

        initViewPager();
        initPagerData();
    }
    //Pager的监听
    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //初始化Viewpager
    private void initViewPager(){
        viewPager= (ViewPager) findViewById(R.id.viewpPager);
        adapter=new BasePagerAdapter(this);
        viewPager.setAdapter(adapter);
        //viewPager.setOnPageChangeListener(pageChangeListener);

    }

    //初始化页面信息viewpager 传值
    private void initPagerData(){
        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.cat12);
        adapter.addView(imageView);

        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        imageView.setImageResource(R.drawable.cat9);
        adapter.addView(imageView);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        startActivity(HomeActivity.class);
    }
}
