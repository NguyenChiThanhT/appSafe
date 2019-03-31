package nguyenchithanh.com.appsafe.data.pref

import android.content.SharedPreferences
import com.google.gson.Gson
import nguyenchithanh.com.appsafe.model.User
import javax.inject.Inject

class SafeSharedPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val ACCESS_TOKEN_KEY = "access_token"
        const val USER_INFO = "User"
    }

    fun getAccessToken(): String? {
        return prefs.getString(ACCESS_TOKEN_KEY, "")
    }

    fun setAccessToken(token: String) {
        prefs.edit().putString(ACCESS_TOKEN_KEY, token).apply()
    }

    fun getUserInfo(): User? {
        if (prefs.getString(USER_INFO, "").equals(""))
            return null
        else
            return Gson().fromJson(prefs.getString(USER_INFO, ""), User::class.java)
    }

    fun setUserInfo(User: User?) {
        prefs.edit().putString(USER_INFO, Gson().toJson(User)).apply()
    }
}