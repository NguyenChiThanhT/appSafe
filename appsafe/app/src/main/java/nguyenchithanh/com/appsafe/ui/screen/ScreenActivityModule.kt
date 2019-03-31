package nguyenchithanh.com.appsafe.ui.screen

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nguyenchithanh.com.appsafe.ui.screen.contact.ContactFragment
import nguyenchithanh.com.appsafe.ui.screen.picture.PictureFragment

@Module
abstract class ScreenActivityModule {
    //inject fragment in activity
    @ContributesAndroidInjector
    abstract fun ContactFragment(): ContactFragment

    @ContributesAndroidInjector
    abstract fun PictureFragment(): PictureFragment



}