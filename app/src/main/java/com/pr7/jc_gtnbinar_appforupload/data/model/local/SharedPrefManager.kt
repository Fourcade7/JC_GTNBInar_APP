package com.pr7.jc_gtnbinar_appforupload.data.model.local

import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import com.pr7.jc_gtnbinar_appforupload.di.CONTEXT


const val LOGINED="Logined"
const val TOKEN="Token"
const val USER_UID="User_uid"
const val USERNAME="UserName"
const val NAME="Name"
const val SURNAME="SurName"
const val GMAIL="Gmail"
const val ORDERS="Orders"
const val MY_PLANS="MyPlans"




fun saveString(key: String, value: String?) {
    val editor = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
        .edit() as SharedPreferences.Editor
    editor.putString(key, value)
    editor.commit()
}

fun loadString(key: String): String? {
    val sharedPreferences = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getString(key, null)
}

fun saveBoolean(key: String, value: Boolean) {
    val editor = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
        .edit() as SharedPreferences.Editor
    editor.putBoolean(key, value)
    editor.commit()
}

fun loadBoolean(key: String): Boolean {
    val sharedPreferences = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getBoolean(key, false)
}

fun saveInt(key: String, value: Int) {
    val editor = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
        .edit() as SharedPreferences.Editor
    editor.putInt(key, value)
    editor.commit()
}

fun loadInt(key: String): Int {
    val sharedPreferences = CONTEXT.getSharedPreferences("Pr", ComponentActivity.MODE_PRIVATE)
    return sharedPreferences.getInt(key, 0)
}