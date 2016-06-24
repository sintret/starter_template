package com.injani.salestracker.library;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by andi on 6/20/2016.
 */
public class SessionManager {

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "salestracker";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    // token to send to our server
    public String token() {
        return pref.getString("token", "");
    }
    //is user is login or not
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setLogin() {
        editor.putBoolean(KEY_IS_LOGGEDIN, true);
        editor.commit();
    }

    public void setLogout() {
        editor.putBoolean(KEY_IS_LOGGEDIN, false);
        editor.commit();

    }
}
