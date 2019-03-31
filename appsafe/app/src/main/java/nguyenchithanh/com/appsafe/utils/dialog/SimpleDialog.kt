package nguyenchithanh.com.appsafe.utils.dialog

import android.content.DialogInterface
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import nguyenchithanh.com.appsafe.R


object SimpleDialog {

//     fun build(activity: AppCompatActivity, isCancelable: Boolean = false): AlertDialog {
//         val dialogBuilder = AlertDialog.Builder(activity)
//         dialogs.setContentView(R.layout.custom_dialog)
//         dialogBuilder.setCancelable(isCancelable)
//         return dialogBuilder.create()
//    }


    fun showDialog(titles: String, contents: String, activity: AppCompatActivity, layoutInflater: LayoutInflater, listener: DialogInterface){

        val builder = AlertDialog.Builder(activity, R.style.NewDialog)
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)

        val title = view.findViewById(R.id.txt_new_pass) as TextView
            title.text = titles
        val content = view.findViewById(R.id.txt_content) as TextView
            content.text = contents
        val yesBtn = view.findViewById(R.id.btn_yes) as Button
        val noBtn = view.findViewById(R.id.btn_no) as Button

        builder.setView(view)
        builder.create()
        val  mAlertDialog = builder.show()

        yesBtn.setOnClickListener {
            listener
        }

        noBtn.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }



}