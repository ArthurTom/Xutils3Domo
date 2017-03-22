package com.example.zhongweikang.myxutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)  // 这一行用于代替一下的东西
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.text_tittle)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    setContentView(R.layout.activity_main);
        x.view().inject(this);  // 选择Activity这个方法进行注解开发

        textView.setText("我是标题");
    }


    /* Button点击事件的写法,{} ,switch判断*/
    @Event(value = {R.id.BT1, R.id.BT2, R.id.BT3})
    private void getButton(View view) {
        switch (view.getId()) {
            case R.id.BT1:
                Intent intent=new Intent(this,MyFragment.class);
                        startActivity(intent);
                Log.d("tag","点击了事件");
                break;
            case R.id.BT2:
                break;
            case R.id.BT3:
                break;
        }


    }
}