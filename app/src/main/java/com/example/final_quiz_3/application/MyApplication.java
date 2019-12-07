package com.example.final_quiz_3.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.final_quiz_3.model.database.DatabaseAdapter;
import com.example.final_quiz_3.R;

public class MyApplication extends Application {

    private static DatabaseAdapter databaseAdapter;
    private static SharedPreferences sharedPreferences;
    private static boolean firstLaunch;
    private static String sharedPreferencesKey;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        sharedPreferencesKey = getString(R.string.is_first_launch);
        firstLaunch = sharedPreferences.getBoolean(sharedPreferencesKey, true);

        databaseAdapter = new DatabaseAdapter(this);
    }

    public static DatabaseAdapter getDatabaseAdapter() {
        return databaseAdapter;
    }

    public static boolean isFirstLaunch() {
        return firstLaunch;
    }

    public static void setFirstLaunch() {
        sharedPreferences
                .edit()
                .putBoolean(sharedPreferencesKey, false)
                .apply();
    }
}
