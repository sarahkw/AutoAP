package io.netcatkate.autoap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public class PowerConnectionReceiver extends BroadcastReceiver {

    private boolean mStartedByMe = false;

    private static boolean isConnectedToWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        } else {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            mStartedByMe = false;
            if (!isConnectedToWifi(context)) {
                ApControl.start();
                mStartedByMe = true;
            }
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            if (mStartedByMe) {
                ApControl.stop();
                mStartedByMe = false;
            }
        }
    }
}
