package com.yzq.stateview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yzq.stateviewlibrary.StateView;

public class MainActivity extends AppCompatActivity implements StateView.RetryListerner {

    private StateView stateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        stateView.setOnRetryListener(this);//设置监听


        /*模拟无数据*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                stateView.show(StateView.NO_DATA);
            }
        }, 1000 * 3);


    }

    private void initView() {
        stateView = (StateView) findViewById(R.id.statView);
    }

    @Override
    public void retry() {

        Log.i("重试", "刷新");
        /*模拟无网络*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                stateView.show(StateView.NO_NET);
            }
        }, 1000 * 3);

    }
}
