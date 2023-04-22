package com.example.myunittestapplication.retrofit

import android.content.SharedPreferences
import javax.inject.Inject

const val AUTH_TOKEN = "AuthToken"

class LocalRepository @Inject constructor(private val preferences: SharedPreferences) {
    suspend fun saveUserToken(token: String) {
        preferences.edit().putString(AUTH_TOKEN, token).apply()
    }
}