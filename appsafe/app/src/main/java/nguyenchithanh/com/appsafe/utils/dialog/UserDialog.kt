package nguyenchithanh.com.appsafe.utils.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.custom_dialog.view.*
import nguyenchithanh.com.appsafe.R

class UserDialog(context: Context) : BaseDialogHelper() {
    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
    }

    override val builder: AlertDialog.Builder = AlertDialog.Builder(context).setView(dialogView)

    //id of view dialog

    val btnYes: Button by lazy {
        dialogView.findViewById(R.id.btn_yes) as Button
    }

    val btnNo: Button by lazy {
        dialogView.findViewById(R.id.btn_no) as Button
    }

    fun btnYesClickListener(func: (() -> Unit)? = null) =
        with(btnYes) {
            setClickListenerToDialogIcon(func)
        }

    fun btnNoClickListener(func: (() -> Unit)? = null) =
        with(btnNo) {
            setClickListenerToDialogIcon(func)
        }

    private fun View.setClickListenerToDialogIcon(func: (() -> Unit)?) =
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
}