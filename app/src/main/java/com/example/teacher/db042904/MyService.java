package com.example.teacher.db042904;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
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
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SER1", "This is onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
