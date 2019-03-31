package nguyenchithanh.com.appsafe.utils.dialog

import android.app.AlertDialog
import androidx.fragment.app.Fragment

inline fun Fragment.showUserAlertDialog(func: UserDialog.() -> Unit): AlertDialog =
    UserDialog(this.context!!).apply {
        func()
    }.create()