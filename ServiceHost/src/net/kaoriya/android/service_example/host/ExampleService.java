package net.kaoriya.android.service_example.host;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public final class ExampleService extends Service
{

    public final static String TAG = "ServHost";

    public final static String ACTION_INTERFACE1 =
        "net.kaoriya.action.INTERFACE1";
    public final static String ACTION_INTERFACE2 =
        "net.kaoriya.action.INTERFACE2";

    private Interface1Impl impl1;

    private Interface2Impl impl2;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "#onCreate");
        this.impl1 = new Interface1Impl();
        this.impl2 = new Interface2Impl();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "#onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        Log.v(TAG, "#onBind action=" + action);
        if (ACTION_INTERFACE1.equals(action)) {
            return this.impl1;
        } else if (ACTION_INTERFACE2.equals(action)) {
            return this.impl2;
        }
        return null;
    }

}
