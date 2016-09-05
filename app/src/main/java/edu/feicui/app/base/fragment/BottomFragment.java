package edu.feicui.app.base.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.feicui.app.main.R;


/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class BottomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
