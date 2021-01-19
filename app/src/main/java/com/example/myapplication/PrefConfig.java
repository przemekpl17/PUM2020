package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {

    private static final String TRENING_KEY = "trening_key";

    public static void writeTreningInPref(Context context, ArrayList<Trening> trening){
        Gson gson = new Gson();
        String jsonString = gson.toJson(trening);
        
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(TRENING_KEY, jsonString);
        editor.apply();
    }

    public static List<Trening> readTreningFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(TRENING_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Trening>>() {}.getType();
        List<Trening> trening = gson.fromJson(jsonString, type );
        return trening;
    }

    private static final String CWICZENIE_KEY = "cwiczenia_key";

    public static void writeCwiczenieInPref(Context context, ArrayList<Cwiczenia> cwiczenia){
        Gson gson = new Gson();
        String jsonString = gson.toJson(cwiczenia);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(CWICZENIE_KEY, jsonString);
        editor.apply();
    }

    public static List<Cwiczenia> readCwiczenieFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(CWICZENIE_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Cwiczenia>>() {}.getType();
        List<Cwiczenia> cw = gson.fromJson(jsonString, type );
        return cw;
    }
}
