package net.kaoriya.android.service_example.host;

import net.kaoriya.android.service_example.common.IInterface2;

import android.util.Log;

public final class Interface2Impl extends IInterface2.Stub
{

    public final static String TAG = "ServHost2";

    @Override
    public int func3(int number, String message) {
        Log.v(TAG, "#func3 number=" + number + " message=" + message); 
        return 0;
    }

    @Override
    public int func4(int number, String message) {
        Log.v(TAG, "#func4 number=" + number + " message=" + message); 
        return 0;
    }

}
