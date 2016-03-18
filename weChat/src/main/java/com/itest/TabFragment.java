package com.itest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/28.
 */
public class TabFragment extends Fragment {

    public static final String TITLE = "title";
    private String mTitle = "Default";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments()!=null){
            mTitle=getArguments().getString(TITLE);
        }
        TextView tv = new TextView(getActivity());
        tv.setTextSize(20);
        tv.setBackgroundColor(Color.parseColor("#ffffffff"));
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);

        return tv;
    }
}
