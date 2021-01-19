package io.netcatkate.autoap;

import android.util.Log;

import java.io.IOException;

public class ApControl {

    /**
       These commands are hardcoded for Android 10, with the Magisk version of su.

       See:

       https://android.googlesource.com/platform/frameworks/base/+/refs/heads/android10-release/core/java/android/net/IConnectivityManager.aidl
       https://android.stackexchange.com/questions/111226/using-adb-shell-how-i-can-disable-hotspot-tethering-on-lollipop-nexus-5/197725#197725
     */

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
