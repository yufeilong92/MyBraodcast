package com.example.dell.mybraodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LocalBroadcastManager localBroadcastManager;
    private Button btn_SendBrod;
    private Button btn_UnregisetdBrod;
    private MainActivity.localBroadCasre localBroadCasre;
    private Button btn_offLineWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MARK);
        localBroadCasre = new localBroadCasre();
        localBroadcastManager.registerReceiver(localBroadCasre, intentFilter);
    }

    public static void startInten(Context context, String parml, String parml1) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("PARML", parml);
        intent.putExtra("PARML2", parml1);
        context.startActivity(intent);
    }

    private void initView() {
        btn_SendBrod = (Button) findViewById(R.id.btn_SendBrod);

        btn_SendBrod.setOnClickListener(this);
        btn_UnregisetdBrod = (Button) findViewById(R.id.btn_UnregisetdBrod);
        btn_UnregisetdBrod.setOnClickListener(this);
        btn_offLineWord = (Button) findViewById(R.id.btn_offLineWord);
        btn_offLineWord.setOnClickListener(this);
    }

    private String MARK = "com.example.broadcasttest.localbr";
    private static final String OFFINE = "com.lawyee.offline";

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_SendBrod:
                Intent intent = new Intent(MARK);
                localBroadcastManager.sendBroadcast(intent);
                break;
            case R.id.btn_UnregisetdBrod:
                unregisterReceiver(localBroadCasre);
                Toast.makeText(MainActivity.this, "停止广播", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_offLineWord:
                Intent intent1 = new Intent(OFFINE);
                sendBroadcast(intent1);
                break;
        }


    }


    class localBroadCasre extends BroadcastReceiver {
        @Override

        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "本地广播发送成功", Toast.LENGTH_SHORT).show();
        }
    }

}
