package edu.feicui.app.main;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import edu.feicui.app.base.BaseActivity;
import edu.feicui.app.base.DownImage;
import edu.feicui.app.base.adapter.BasePagerAdapter;

public class HomeActivity extends BaseActivity {
    DownImage downImage;
    MediaPlayer mediaPlayer;
    ImageView iv_pager,imageView1,imageView2,imageView3,imageView4,imageView5;
    SearchView searchView;
    ViewPager viewPager;
    BasePagerAdapter adapter;
    //调取整体路径public final static String URL = "http://192.168.1.141:8080/OkHttp/";
    String home="URLUtil.URL" +"home/";
    //String pic="http://192.168.1.141:8080/OkHttp/images";
    String sy_pager1=home+"home1.jpg";
    String sy_pager2=home+"home2.jpg";
    String sy_pager3=home+"home3.jpg";
    String sy_pager4=home+"home4.jpg";
    String sy_pager5=home+"home5.jpg";
    String sy_pager6=home+"home6.jpg";
    ImageView icon[]=new ImageView[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //初始化
        imageView1= (ImageView) findViewById(R.id.home_iv1);
        imageView2= (ImageView) findViewById(R.id.home_iv2);
        imageView3= (ImageView) findViewById(R.id.home_iv3);
        imageView4= (ImageView) findViewById(R.id.home_iv4);
        imageView5= (ImageView) findViewById(R.id.home_iv5);
        searchView= (SearchView) findViewById(R.id.searchView);
        initViewPager();
        shouyePager();
        initIcon();
    }
    private void initIcon(){
        icon[0]= (ImageView) findViewById(R.id.icon1);
        icon[1]= (ImageView) findViewById(R.id.icon2);
        icon[2]= (ImageView) findViewById(R.id.icon3);
        icon[3]= (ImageView) findViewById(R.id.icon4);
        icon[4]= (ImageView) findViewById(R.id.icon5);
        icon[5]= (ImageView) findViewById(R.id.icon6);
        //设置被选择时候的图标颜色,默认选择第一个
        icon[0].setImageResource(R.drawable.small_icon_selected);
    }
    private ViewPager.OnPageChangeListener pageChangeListener=
            new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }
                @Override
                public void onPageSelected(int position) {
                    //更新小圆点图标
                    for(int i=0;i<icon.length;i++){
                        icon[i].setImageResource(R.drawable.small_icon_normal);
                    }icon[position].setImageResource(R.drawable.small_icon_selected);
                }
                @Override
                public void onPageScrollStateChanged(int state) {
                }
            };
    //设置homepager的图片
    private void shouyePager(){
        initPagerData(iv_pager,sy_pager1);
        initPagerData(iv_pager,sy_pager2);
        initPagerData(iv_pager,sy_pager3);
        initPagerData(iv_pager,sy_pager4);
        initPagerData(iv_pager,sy_pager5);
        initPagerData(iv_pager,sy_pager6);
    }
    //初始化Viewpager
    private void initViewPager(){
        viewPager= (ViewPager) findViewById(R.id.home_viewpPager);
        adapter=new BasePagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }
    //初始化页面信息viewpager 传值
    private void initPagerData(ImageView imageView,String url){
        imageView= (ImageView) getLayoutInflater().inflate(R.layout.lead_item,null);
        downImage=new DownImage(imageView,url);
        downImage.execute();
        adapter.addView(imageView);
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //mediaPlayer.stop();
    }
    public void timeBuy(View view) {
        startActivity(TimeBuyActivity.class);
    }
}
