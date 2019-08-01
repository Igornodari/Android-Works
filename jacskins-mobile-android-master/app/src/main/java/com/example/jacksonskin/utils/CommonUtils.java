package com.example.jacksonskin.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.example.jacksonskin.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import q.rorbin.badgeview.QBadgeView;


public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }


    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    public static String loadJSONFromAsset(Context context, String jsonFileName)
            throws IOException {

        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, StandardCharsets.UTF_8);
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.getDefault()).format(new Date());
    }

    public static void addBadge(Context context, int number, View view) {
        new QBadgeView(context)
                .setBadgeText(String.valueOf(number))
                .setGravityOffset(8f, 0f, true)
                .setBadgeTextSize(11f, true)
                .setShowShadow(false)
                .setBadgeBackground(ContextCompat.getDrawable(context, R.drawable.shape_badge_background))
                .bindTarget(view);
    }
}