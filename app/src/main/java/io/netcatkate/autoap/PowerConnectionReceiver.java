package io.netcatkate.autoap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            ApControl.start();
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            ApControl.stop();
        }
    }
}
