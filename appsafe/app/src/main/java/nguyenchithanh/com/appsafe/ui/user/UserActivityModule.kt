package nguyenchithanh.com.appsafe.ui.user

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nguyenchithanh.com.appsafe.ui.user.login.LoginFragment
import nguyenchithanh.com.appsafe.ui.user.register.RegisterFragment

@Module
abstract class UserActivityModule {
    //inject fragment in activity
    @ContributesAndroidInjector
    abstract fun RegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun LoginFragment(): LoginFragment
}