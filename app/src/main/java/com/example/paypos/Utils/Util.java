package com.example.paypos.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.EditText;

public class Util {
    private static String idPhone = null;

    public static String getImei(Activity activity) {
        final int PERMISSIONS_REQUEST_READ_PHONE_STATE = 0;
        TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService(activity.getApplicationContext().TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Should we show an explanation?

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_PHONE_STATE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        PERMISSIONS_REQUEST_READ_PHONE_STATE);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            idPhone = telephonyManager.getDeviceId();
        }
        return idPhone;
    }

    public static String getUname(Activity activity) {
        final String PREFS_NAME = "preferences";
        final String PREF_UNAME = "Username";
        final String DefaultUnameValue = "";
        String UnameValue;
        SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        return UnameValue;
    }

    public static void setUname(Activity activity, String uname) {
        final String PREFS_NAME = "preferences";
        final String PREF_UNAME = "Username";
        String UnameValue;
        SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        // Edit and commit
        UnameValue = uname;
        editor.putString(PREF_UNAME, UnameValue);
        editor.apply();
    }

    public static String getOrganisme(Bundle extras, EditText edt) {
        String codeOrg = "";
        if (extras.getString("organisme").equals("STEG")) {
            edt.setText("STEG");
            codeOrg = "0701";

        } else if (extras.getString("organisme").equals("SONEDE")) {
            edt.setText("SONEDE");
            codeOrg = "0502";

        } else if (extras.getString("organisme").equals("TT")) {
            edt.setText("TT");
            codeOrg = "0151";
        } else if (extras.getString("organisme").equals("ORD")) {
            edt.setText("OOREDOO");
            codeOrg = "0777";
        } else if (extras.getString("organisme").equals("ORG")) {
            edt.setText("ORANGE");
            codeOrg = "0737";
        } else if (extras.getString("organisme").equals("TOPNET")) {
            edt.setText("TOPNET");
            codeOrg = "0770";
        } else if (extras.getString("organisme").equals("CNSS")) {
            edt.setText("CNSS");
            codeOrg = "0206";
        } else if (extras.getString("organisme").equals("CNSSFNS")) {
            edt.setText("CNSS FNS");
            codeOrg = "0207";
        } else if (extras.getString("organisme").equals("CNSSEMPLO")) {
            edt.setText("CNSS EMPLO");
            codeOrg = "0208";
        } else if (extras.getString("organisme").equals("CNRPS")) {
            edt.setText("CNRPS");
            codeOrg = "0702";
        } else if (extras.getString("organisme").equals("SNIT")) {
            edt.setText("SNIT");
            codeOrg = "0801";
        } else if (extras.getString("organisme").equals("CRDANABE")) {
            edt.setText("CRDA NABE");
            codeOrg = "0849";
        } else if (extras.getString("organisme").equals("CRDAJAND")) {
            edt.setText("CRDA JAND");
            codeOrg = "0851";
        } else if (extras.getString("organisme").equals("CRDAAROU")) {
            edt.setText("CRDA AROU");
            codeOrg = "0853";
        } else if (extras.getString("organisme").equals("CRDAARIA")) {
            edt.setText("CRDA ARIA");
            codeOrg = "0854";
        } else if (extras.getString("organisme").equals("CRDASILI")) {
            edt.setText("CRDA SILI");
            codeOrg = "0855";
        } else if (extras.getString("organisme").equals("CNEL")) {
            edt.setText("CNEL");
            codeOrg = "0901";
        } else if (extras.getString("organisme").equals("SPROLSLO")) {
            edt.setText("SPROLS LO");
            codeOrg = "0950";
        } else if (extras.getString("organisme").equals("SPROLSAC")) {
            edt.setText("SPROLS AC");
            codeOrg = "0951";
        } else if (extras.getString("organisme").equals("CRDABIZE")) {
            edt.setText("CRDA BIZE");
            codeOrg = "0852";
        } else if (extras.getString("organisme").equals("TTN")) {
            edt.setText("TTN");
            codeOrg = "0760";
        }
        return codeOrg;
    }
}
