package com.example.administrator.netstatelistener;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NetBroadCast.onNetStateChangeListener {

    private NetBroadCast broadCast;
    private boolean boo = false;//是否注册广播
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadCast = new NetBroadCast(this);
        registerReceiver(broadCast, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        boo = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(boo){
            unregisterReceiver(broadCast);
        }
    }

    @Override
    public void onNetStateChange(int netMobile) {
        if (netMobile == NetBroadCast.NETWORK_NONE){
            Log.e("1111","1111");
            Toast.makeText(MainActivity.this,"网络连接异常",Toast.LENGTH_SHORT);
        }else{
            Log.e("2222","2222");
            Toast.makeText(MainActivity.this,"网络连接正常",Toast.LENGTH_SHORT);
        }
    }
}
