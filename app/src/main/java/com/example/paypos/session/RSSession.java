package com.example.paypos.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.paypos.Model.UserInfos;
import com.google.gson.Gson;
import static android.content.Context.MODE_PRIVATE;

public class RSSession {
    private final static String SHARED_PREFERENCES_FILE = "local_storage_users";

    public static void saveIntoSharedPreferences(Object Data, Context context) {
        UserInfos user = new Gson().fromJson(new Gson().toJson(Data), UserInfos.class);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_PREFERENCES_FILE, new Gson().toJson(user));
        editor.apply();
    }

    public static UserInfos getLocalStorage(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        String localStorage = sharedPreferences.getString(SHARED_PREFERENCES_FILE, "");
        return new Gson().fromJson(localStorage, UserInfos.class);
    }

    public static int getIdUser(Context context) {
        return getLocalStorage(context).getId_client();
    }

    public static void cancelSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(SHARED_PREFERENCES_FILE);
        editor.apply();
    }
}
