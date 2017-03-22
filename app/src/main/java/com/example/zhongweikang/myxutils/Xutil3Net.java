package com.example.zhongweikang.myxutils;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_xutil3_net)
public class Xutil3Net extends Activity {

    @ViewInject(R.id.btn_get)
    private Button get;
    @ViewInject(R.id.btn_post)
    private Button post;
    @ViewInject(R.id.pro)
    private ProgressBar down;
    @ViewInject(R.id.textView)
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xutil3_net);
        x.view().inject(this);
    }

    @Event(value = {R.id.btn_get, R.id.btn_post, R.id.pro})
    private void getButton(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                Log.d("tag",11111+"");
                getAndPost();
                break;
            case R.id.btn_post:
                break;
            case R.id.pro:
                Toast.makeText(this,"开始下载了啊",Toast.LENGTH_SHORT).show();
                downLoad();


                break;
        }
    }
    
    private void getAndPost(){
        RequestParams param=new RequestParams("https://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=98050039_dg&wd=progressbar%E6%A0%B7%E5%BC%8F&oq=progressbar&rsv_pq=c4f291fb000044bd&rsv_t=42a115F05BL3czEVJkJHJS%2FjBpsgIq0wBQLezM1YpyK30QPs%2BqC1FYrNJsCokR%2FFutI&rqlang=cn&rsv_enter=1&inputT=9930&rsv_sug3=19&rsv_sug1=14&rsv_sug7" +
                "=100&bs=progressbar");
        x.http().get(param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("tag",result);
                textView.setText(result);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /* xUtils3下载的方法*/
    private  void downLoad(){
        RequestParams param=new RequestParams("http://img06.tooopen.com/images/20170316/tooopen_sy_202006455884.jpg");
        param.setSaveFilePath(Environment.getExternalStorageDirectory()+"/image_zhong/111111.jdp");  // 设置下载存贮的位置和名称
       // param.setCancelFast(true);
        x.http().get(param, new Callback.ProgressCallback<File>() {  // ProgressCallback是下载回调的方法，其中泛参数使用File


            @Override
            public void onSuccess(File result) {
                Log.d("File","下载成功"+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
               Log.d("AAT","下载失败"+ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {
              // 我是修改的，
            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                /* total 是总的下载进度长度，current是当前的下载进度长度*/
                 down.setProgress((int) current); // 设置当前的进度为
                 down.setMax((int) total);  // 设置进度条的最大值为
            }
        });
    }
}
