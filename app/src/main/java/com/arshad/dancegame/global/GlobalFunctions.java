package com.arshad.dancegame.global;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arshad.dancegame.R;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GlobalFunctions {

    private static final String TAG = "GlobalFunctions";

    static String app_name = "com.arshad.dancegam";

    /**
     * Storing string value into SharedPrefs
     *
     * @param c
     * @param key
     * @param value
     */
    public static void setSharedPrefs(Context c, String key, String value) {

        SharedPreferences.Editor editor = c.getSharedPreferences(app_name,
                Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();

    }

    /**
     * Storing int value into SharedPrefs
     *
     * @param c
     * @param key
     * @param value
     */
    public static void setSharedPrefs(Context c, String key, int value) {

        SharedPreferences.Editor editor = c.getSharedPreferences(app_name,
                Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.apply();

    }

    /**
     * Storing float value into SharedPrefs
     *
     * @param c
     * @param key
     * @param value
     */
    public static void setSharedPrefs(Context c, String key, float value) {

        SharedPreferences.Editor editor = c.getSharedPreferences(app_name,
                Context.MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.apply();

    }

    /**
     * Fetching float value from SharedPrefs
     *
     * @param c
     * @param key
     * @param default_value
     * @return
     */
    public static float getSharedPrefs(Context c, String key, float default_value) {
        if (c == null) {
            return default_value;
        } else {
            SharedPreferences prefs = c.getSharedPreferences(app_name,
                    Context.MODE_PRIVATE);
            return prefs.getFloat(key, default_value);
        }
    }

    /**
     * Fetching String value from SharedPrefs
     *
     * @param c
     * @param key
     * @param default_value
     * @return
     */
    public static String getSharedPrefs(Context c, String key,
                                        String default_value) {
        if (c == null) {
            return default_value;
        } else {
            SharedPreferences prefs = c.getSharedPreferences(app_name,
                    Context.MODE_PRIVATE);
            return prefs.getString(key, default_value);
        }
    }

    /**
     * Fetching int value from SharedPrefs
     *
     * @param c
     * @param key
     * @param default_value
     * @return
     */
    public static int getSharedPrefs(Context c, String key, int default_value) {
        if (c == null) {
            return default_value;
        } else {
            SharedPreferences prefs = c.getSharedPreferences(app_name,
                    Context.MODE_PRIVATE);
            return prefs.getInt(key, default_value);
        }
    }

    /**
     * Checking if SharedPrefs contains key
     *
     * @param c
     * @param key
     * @return
     */
    public static boolean checkSharedPrefs(Context c, String key) {
        if (c == null) {
            return false;
        } else {
            SharedPreferences prefs = c.getSharedPreferences(app_name,
                    Context.MODE_PRIVATE);
            return prefs.contains(key);
        }
    }

    /**
     * Removing from SharedPrefs
     *
     * @param c
     * @param key
     */
    public static void removeSharedPrefs(Context c, String key) {
        SharedPreferences.Editor editor = c.getSharedPreferences(app_name,
                Context.MODE_PRIVATE).edit();
        editor.remove(key);
        //editor.commit();
        editor.apply();
    }


    /**
     * Clear SharedPrefs
     *
     * @param c
     */
    public static void clearSharedPrefs(Context c) {
        SharedPreferences.Editor editor = c.getSharedPreferences(app_name,
                Context.MODE_PRIVATE).edit();
        //editor.commit();
        editor.clear();
        editor.apply();
    }

    /**
     * Showing Short Toast Message
     */
    public static void toastShort(Context c, String msg) {
                Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();

//        try {
//            View v = (((Activity) c).findViewById(android.R.id.content));
//            Snackbar snackbar = Snackbar.make(v, msg, Snackbar.LENGTH_LONG)
//                    .setAction("Action", null);
//            TextView tv = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
//            Typeface font = Typeface.createFromAsset(c.getAssets(), Constants.FONT_LIGHT);
//            tv.setTypeface(font);
//            snackbar.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Long Toast Message
     *
     * @param c
     * @param msg
     */
    public static void toastLong(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Hide Keypad - removing focus from selected Edittext
     *
     * @param c
     * @param et
     */
    public static void hideKeyboard(Context c, EditText et) {
        InputMethodManager imm = (InputMethodManager) c
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    /**
     * Disable screen touch
     *
     * @param window
     */
    public static void disableTouch(Window window) {
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    /**
     * Enable screen touch
     *
     * @param window
     */
    public static void enableTouch(Window window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }


    /**
     * Make View Visible
     *
     * @param views
     */
    public static void viewVisible(View... views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Make View Hidden
     *
     * @param views
     */
    public static void viewHidden(View... views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * Make View Invisible
     *
     * @param views
     */
    public static void viewInvisible(View... views) {
        for (View view : views) {
            view.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * Creating HorizontalLayout for RecyclerView
     *
     * @param mContext
     * @param recyclerViews
     */
    public static void createHorizontalRecyclerView(Context mContext, RecyclerView... recyclerViews) {
        for (RecyclerView recyclerView : recyclerViews) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    /**
     * Creating VerticalLayout for RecyclerView
     *
     * @param mContext
     * @param recyclerViews
     */
    public static void createVerticalRecyclerView(Context mContext, RecyclerView... recyclerViews) {
        for (RecyclerView recyclerView : recyclerViews) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        }
    }

    /**
     * Start ProgressDialog loading
     *
     * @param dialog
     * @param message
     */
    public static void startProgressDialog(ProgressDialog dialog, String message) {
        try {
            dialog.setMessage(message);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
//            dialog.setContentView(R.layout.global_progress_dialog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop progress dialog loading
     *
     * @param dialog
     */
    public static void stopProgressDialog(ProgressDialog dialog) {
        try {
            if (dialog != null && dialog.isShowing()) {
                Log.e(TAG, "Dismissing Dialog");
                dialog.dismiss();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Set Regular font for textView
     *
     * @param c
     * @param tvs
     */
    public static void setCustomFont(Context c, String fontName, TextView... tvs) {
        Typeface tf = Typeface.createFromAsset(c.getAssets(),
                fontName);
        for (TextView tv : tvs) {
            tv.setTypeface(tf);
        }
    }

    public static int random(int start, int end, int random) {
        Random rand = new Random();
        Log.e(TAG, start + " " + end + " " + random);
        int r = rand.nextInt((end - start) + 1) + start;

        if(r == random) {
            r = rand.nextInt((end - start) + 1) + start;
        }
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return r;
    }

}
