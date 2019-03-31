package nguyenchithanh.com.appsafe.ui.user

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import nguyenchithanh.com.appsafe.R
import nguyenchithanh.com.appsafe.data.pref.SafeSharedPreferences
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.ui.user.login.LoginFragment
import nguyenchithanh.com.appsafe.ui.user.register.RegisterFragment
import nguyenchithanh.com.appsafe.utils.fragment.SetUpFrgment
import javax.inject.Inject

class UserActivity : AppCompatActivity(),HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var safeSharedPreferences: SafeSharedPreferences

    var user:User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        loadLoginFragment()

//        user = safeSharedPreferences.getUserInfo()
//        if(user?.status == 1) {
//            loadLoginFragment()
//        } else {
//            loadRegisterFragment()
//        }

    }

    private fun loadLoginFragment() {
        val loginFragment = LoginFragment()
        SetUpFrgment.addFragment(this,loginFragment,(R.id.containerUser))
    }
    private fun loadRegisterFragment() {
        val registerFragment = RegisterFragment()
        SetUpFrgment.addFragment(this,registerFragment,(R.id.containerUser))
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
