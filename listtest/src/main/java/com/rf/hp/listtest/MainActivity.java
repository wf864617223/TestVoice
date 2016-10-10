package com.rf.hp.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * 下拉刷新的小案例
 */
public class MainActivity extends AppCompatActivity {

    CustomHealder header;
    PtrFrameLayout prtFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = new CustomHealder(this);
        header.setPadding(0, 30, 0, 0);
        //header.initWithString('Alibaba');
        prtFrame = (PtrFrameLayout) findViewById(R.id.prt_frame);
        prtFrame.setHeaderView(header);
        int a = 10;
        int b = 20;
        boolean b1 = a > b ? true : false;
        int c = a < b ? a: b;
        prtFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                /* 延时100秒 *//*
                prtFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        prtFrame.autoRefresh();
                        return;
                    }
                }, 100);*/


                return true;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                Toast.makeText(MainActivity.this, "12345", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(MainActivity.this, "54321", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this, "12345", Toast.LENGTH_SHORT).show();
    }*/
}
