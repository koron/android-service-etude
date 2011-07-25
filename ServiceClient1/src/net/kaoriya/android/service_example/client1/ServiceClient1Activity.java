package net.kaoriya.android.service_example.client1;

import net.kaoriya.android.service_example.common.IInterface1;
import net.kaoriya.android.service_example.common.IInterface2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class ServiceClient1Activity extends Activity
{

    public final static String TAG = "ServClient1";

    public final static String ACTION_INTERFACE1 =
        "net.kaoriya.action.INTERFACE1";
    public final static String ACTION_INTERFACE2 =
        "net.kaoriya.action.INTERFACE2";

    private IInterface1 interface1 = null;

    private IInterface2 interface2 = null;

    private ServiceConnection conn1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceClient1Activity.this.interface1 =
                IInterface1.Stub.asInterface(service);
            updateViews();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            ServiceClient1Activity.this.interface1 = null;
            updateViews();
        }
    };

    private ServiceConnection conn2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceClient1Activity.this.interface2 =
                IInterface2.Stub.asInterface(service);
            updateViews();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            ServiceClient1Activity.this.interface2 = null;
            updateViews();
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "#onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        connectService();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG, "#onDestroy");
        super.onDestroy();


        disconnectService();
    }

    private void connectService() {
        bindService(new Intent(ACTION_INTERFACE1), this.conn1,
                BIND_AUTO_CREATE);
        bindService(new Intent(ACTION_INTERFACE2), this.conn2,
                BIND_AUTO_CREATE);
    }

    private void disconnectService() {
        if (this.interface2 != null) {
            unbindService(this.conn2);
        }
        if (this.interface1 != null) {
            unbindService(this.conn1);
        }
    }

    private void updateViews() {
        // TODO:
        Log.v(TAG, "#updateViews interface1=" + (this.interface1 != null)
                + " interface2=" + (this.interface2 != null));
    }

}
