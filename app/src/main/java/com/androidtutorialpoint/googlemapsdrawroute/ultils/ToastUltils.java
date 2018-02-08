package com.androidtutorialpoint.googlemapsdrawroute.ultils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public class ToastUltils {
    public static void showToast(Context context, String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
