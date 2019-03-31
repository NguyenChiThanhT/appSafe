package nguyenchithanh.com.appsafe.utils.extention

import android.util.Patterns

fun String.isValidEmailAddress(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}