package com.caique.everis.retencaoura;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DialReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String phoneNumber = getResultData();
        if (phoneNumber == null) {
            phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }

        if (phoneNumber.equals("333")) {
            setResultData(null);

            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("extra_phone", phoneNumber);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }
}