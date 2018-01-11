package com.mindorks.framework.mvp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.mindorks.framework.mvp.di.PreferenceInfo
import com.mindorks.framework.mvp.util.AppConstants
import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppPreferenceHelper @Inject constructor(private val context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {


    private var mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"


    }


    override fun getCurrentUserLoggedInMode(): Int {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)
    }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type).apply()
    }

    override fun getCurrentUserId(): Long? {
        val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return when {
            userId == AppConstants.NULL_INDEX -> null
            else -> userId
        }
    }

    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply()
    }

    override fun getCurrentUserName(): String {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null)
    }

    override fun setCurrentUserName(userName: String?) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply()
    }

    override fun getCurrentUserEmail(): String {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null)
    }

    override fun setCurrentUserEmail(email: String) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply()
    }

    override fun getAccessToken(): String? {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)
    }

    override fun setAccessToken(accessToken: String?) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()
    }

}