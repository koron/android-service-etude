package net.kaoriya.android.service_example.host;

import net.kaoriya.android.service_example.common.IInterface1;

import android.util.Log;

public final class Interface1Impl extends IInterface1.Stub
{

    public final static String TAG = "ServHost1";

    @Override
    public int func1(int number, String message) {
        Log.v(TAG, "#func1 number=" + number + " message=" + message); 
        return 0;
    }

    @Override
    public int func2(int number, String message) {
        Log.v(TAG, "#func2 number=" + number + " message=" + message); 
        return 0;
    }

}
