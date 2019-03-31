package nguyenchithanh.com.appsafe.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nguyenchithanh.com.appsafe.ui.main.MainActivity
import nguyenchithanh.com.appsafe.ui.main.MainActivityModule
import nguyenchithanh.com.appsafe.ui.screen.ScreenActivity
import nguyenchithanh.com.appsafe.ui.screen.ScreenActivityModule
import nguyenchithanh.com.appsafe.ui.user.UserActivity
import nguyenchithanh.com.appsafe.ui.user.UserActivityModule

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [UserActivityModule::class])
    abstract fun bindUserActivity(): UserActivity

    @ContributesAndroidInjector(modules = [ScreenActivityModule::class])
    abstract fun bindScreenActivity(): ScreenActivity


}