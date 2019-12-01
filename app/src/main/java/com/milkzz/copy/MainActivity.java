package com.milkzz.copy;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.milkz.ui.progress.ZJuHuaProgress;
import com.milkz.ui.toast.ZToast;

public class MainActivity extends AppCompatActivity {
    ZJuHuaProgress zJuHuaProgress = new ZJuHuaProgress();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZToast.showToast(getBaseContext(), "持续2秒", 2000);
            }
        });

        findViewById(R.id.bt_juhua_progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMSG(MSG_SHOW_PROGRESS);
            }
        });
    }

    private void sendMSG(int what){
        Message message = new Message();
        message.what = what;
        handler.sendMessage(message);
    }

    private static final int MSG_SHOW_PROGRESS = 100;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case MSG_SHOW_PROGRESS:{
                    Log.d("ZZZ","progress");

                    zJuHuaProgress.show(getSupportFragmentManager(),"");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    zJuHuaProgress.dismiss();
                }break;
            }
            return true;
        }
    });
}
