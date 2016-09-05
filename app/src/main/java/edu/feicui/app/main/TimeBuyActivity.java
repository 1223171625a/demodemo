package edu.feicui.app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;

import edu.feicui.app.adapter.TimeBuyAdapter;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TimeBuyActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private TimeBuyAdapter adapter;
    Button button;
    OkHttpClient client=new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_buy);
        listView= (ListView) findViewById(R.id.timebuy_listview);
        adapter=new TimeBuyAdapter(this);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                postRequest();

                break;

        }

    }
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void postRequest(){
        String ath="发送给服务器的测试数据";
        //JSONObject json=new JSONObject();
        RequestBody body=RequestBody.create(JSON,ath);

        String url="URLUtil.SERVLETURL";
        final Request request=new Request.Builder().url(url).post(body).build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response=client.newCall(request).execute();

                    if(response.isSuccessful()){
                        String str=response.body().string();

                        Log.v("请求成功",str+"");
                    }else {
                        Log.v("请求响应失败","失败了");
                    }
                    response.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
