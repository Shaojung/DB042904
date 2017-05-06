package com.example.teacher.db042904;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {
    private final IBinder myBinder = new MyBinder();
    private final Random mGenerator = new Random();
    public MyService() {
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
}
