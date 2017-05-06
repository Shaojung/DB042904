package com.example.teacher.db042904;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Context context;
    ServiceConnection connection;
    MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("SER1", "onServiceConnected");
                myService = ((MyService.MyBinder) service).getService();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void clickBind(View v)
    {
        Intent it = new Intent(context, MyService.class);
        Log.d("SER1", "bindService");

        bindService(it, connection, BIND_AUTO_CREATE);
    }

    public void clickGetRandom(View v)
    {
        if (myService != null)
        {
            int r = myService.getRandomNumber();
            Log.d("SER1", String.valueOf(r));
        }

    }
}
