package edu.feicui.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import edu.feicui.app.entity.TimeBuyInfo;
import edu.feicui.app.main.R;

/**
 * Created by Administrator on 2016/9/1 0001.
 */
public class TimeBuyAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<TimeBuyInfo> arrayList=new ArrayList<TimeBuyInfo>();

    public TimeBuyAdapter(Context context) {
        this.context = context;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addImage(ArrayList<TimeBuyInfo> e){
        if(e!=null){
            arrayList.addAll(e);
        }
    }

    public void clearData(){
        arrayList.clear();
    }

    public ArrayList<TimeBuyInfo> getArrayList(){
        return arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public TimeBuyInfo getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view=layoutInflater.inflate(R.layout.timebuy_item,null);
        }

        TextView img_path= (TextView) view.findViewById(R.id.img_path);

        img_path.setText(getItem(i).img_path);

        return view;
    }
}
