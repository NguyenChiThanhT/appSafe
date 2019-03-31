package nguyenchithanh.com.appsafe.utils.fragment

import android.content.Context
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import io.reactivex.internal.util.BackpressureHelper.add
import nguyenchithanh.com.appsafe.R

class SetUpFrgment {

    companion object {
        inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
            val fragmentTransaction = beginTransaction()
            fragmentTransaction.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
            fragmentTransaction.func()
            fragmentTransaction.commit()
        }

        fun addFragment(context: Context,fragment: Fragment, frameId:Int) {
            (context as AppCompatActivity).supportFragmentManager.inTransaction { add(frameId, fragment) }
        }

        fun replaceFragment(context: Context,fragment: Fragment, frameId: Int) {
            (context as AppCompatActivity).supportFragmentManager.inTransaction{replace(frameId, fragment)}
        }

        fun removeFragment(context: Context,fragment: Fragment) {
            (context as AppCompatActivity).supportFragmentManager.inTransaction{remove(fragment)}
        }
    }
}