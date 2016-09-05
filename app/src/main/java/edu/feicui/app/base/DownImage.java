package edu.feicui.app.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/31 0031.
 * 读取服务器图片
 */
public class DownImage extends AsyncTask<String,Float,Bitmap> {
    private ImageView imageView;
    private String str;

    public DownImage(ImageView imageView, String str) {
        this.imageView = imageView;
        this.str = str;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap=null;
        try {
            //URL url=new URL(str);
            InputStream is=new URL(str).openStream();
            bitmap= BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
