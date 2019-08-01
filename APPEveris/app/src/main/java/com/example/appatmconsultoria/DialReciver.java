package com.example.appatmconsultoria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.appatmconsultoria.Dash.AppEveris;

public class DialReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String phoneNumber = getResultData();
        if (phoneNumber == null) {
            phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }

        if (phoneNumber.equals("111")) {
            setResultData(null);

            Intent i = new Intent(context, AppEveris.class);
            i.putExtra("extra_phone", phoneNumber);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
    }
        }

}