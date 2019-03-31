package nguyenchithanh.com.appsafe.di

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import nguyenchithanh.com.appsafe.api.SafeService
import nguyenchithanh.com.appsafe.data.pref.SafeSharedPreferences
import nguyenchithanh.com.appsafe.utils.rx.AppSchedulerProvider
import nguyenchithanh.com.appsafe.utils.rx.SchedulerProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application):
            SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesMangaSharedPreferences(sharedPreferences: SharedPreferences):
            SafeSharedPreferences {
        return SafeSharedPreferences(sharedPreferences)
    }
//    @Provides
//    @Singleton
//    fun provideGson():Gson = GsonBuilder()
//        /*.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)*/
//        .create()

    @Provides
    @Singleton
    fun provideRetrofit(): SafeService {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("http://192.168.1.253/gumi/")
            .build()
            .create(SafeService::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideFaceIdService(retrofit: Retrofit): FaceIdService{
//        return retrofit.create(FaceIdService::class.java)
//    }
}