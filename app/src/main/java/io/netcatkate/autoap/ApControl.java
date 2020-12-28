package io.netcatkate.autoap;

import android.util.Log;

import java.io.IOException;

public class ApControl {
    public static void start() {
        Log.i("ApControl", "start");
        try {
            Runtime.getRuntime().exec(new String[] { "su", "-c", "service", "call", "connectivity", "24", "i32", "0", "i32", "0", "i32", "0", "s16", "dummy" });
        } catch (IOException e) {
            Log.e("ApControl", "fail");
        }
    }

    public static void stop() {
        Log.i("ApControl", "stop");
        try {
            Runtime.getRuntime().exec(new String[] { "su", "-c", "service", "call", "connectivity", "25", "i32", "0", "s16", "dummy" });
        } catch (IOException e) {
            Log.e("ApControl", "fail");
        }
    }
}
