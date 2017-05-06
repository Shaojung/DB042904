package com.example.teacher.db042904;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {
    private final IBinder myBinder = new MyBinder();
    private final Random mGenerator = new Random();
    Handler handler = new Handler();
    int i;
    public MyService() {
        i=0;
    }

    class MyBinder extends Binder {
        public MyService getService()
        {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("SER1", "This is onbind");
        handler.post(showTime);
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SER1", "This is onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
    Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.d("SER1", "Time:" + new java.util.Date());
            i++;
            if (i <= 5)
            {
                handler.postDelayed(this, 1000);
            }
            else
            {
                Log.d("SER1", "時間到");
            }

        }
    };
}
