package nguyenchithanh.com.appsafe.di
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import nguyenchithanh.com.appsafe.ui.main.MainActivityViewModel
import nguyenchithanh.com.appsafe.ui.screen.ScreenActivityViewModel
import nguyenchithanh.com.appsafe.ui.user.UserActivityViewModel
import nguyenchithanh.com.appsafe.ui.user.login.LoginViewModel
import nguyenchithanh.com.appsafe.ui.user.register.RegisterViewModel
import nguyenchithanh.com.appsafe.di.ViewModelKey

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( UserActivityViewModel::class)
    abstract fun bindUserActivityViewModel( userActivityViewModel:  UserActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( RegisterViewModel::class)
    abstract fun bindRegisterViewModel( registerViewModel:  RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( LoginViewModel::class)
    abstract fun bindloginViewModel( loginViewModel:  LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(  ScreenActivityViewModel::class)
    abstract fun bindscreenActivityViewModel(  screenActivityViewModel: ScreenActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: SafeViewModelFactory): ViewModelProvider.Factory
}