package com.seyed.nazanin.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hamidreza on 3/12/2017.
 */

public class SpManager {
    private static SpManager ourInstance;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static SpManager getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new SpManager(context);
        return ourInstance;
    }

    private SpManager(Context context) {
        sharedPreferences = context.getSharedPreferences("share", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setPath(String path){
        editor.putString("path",path);
        editor.apply();
    }


    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editor.putBoolean("firsttime",isFirstTime);
        editor.apply();
    }

    public boolean isFirstTimeLaunch()
    {
        return sharedPreferences.getBoolean("firsttime",true);
    }

    public void setDetailId(String detailId)
    {
        editor.putString("detailId",detailId);
        editor.apply();
    }

    public String getDetailId()
    {
        return sharedPreferences.getString("detailId","");
    }


}
