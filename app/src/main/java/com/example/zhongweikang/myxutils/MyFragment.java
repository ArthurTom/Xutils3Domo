package com.example.zhongweikang.myxutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by zhongweikang on 2017/3/15.
 */
@ContentView(R.layout.activity_fragment)
public class MyFragment extends FragmentActivity {
    @ViewInject(R.id.fragment_show)
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fragment);
        x.view().inject(this);
        textView.setText("fragment布局");
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transition=fm.beginTransaction();
         transition.replace(R.id.fragment_layout,new fragment());
        transition.commit();
    }
}
