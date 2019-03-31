package nguyenchithanh.com.appsafe.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import nguyenchithanh.com.appsafe.api.ApiErrorHandler
import nguyenchithanh.com.appsafe.api.Response
import nguyenchithanh.com.appsafe.api.SafeService
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.model.apibody.UserBody
import nguyenchithanh.com.appsafe.utils.rx.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(
    private val safeService:SafeService,
    private val schedulerProvider: SchedulerProvider) {

    val compositeDisposable = CompositeDisposable()

    fun register(registerBody: UserBody):LiveData<Response<User>> {

        val user = MutableLiveData<Response<User>>()

        safeService.register(registerBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeBy(
                onNext = {
                    user.value = Response.success(it.data)
                },
                onError = {
                    user.value = Response.error(ApiErrorHandler.handleErrorResponse(it))
                })
            .addTo(compositeDisposable)

        return user
    }

    fun login(loginBody:UserBody):LiveData<Response<User>> {
        val user = MutableLiveData<Response<User>>()

        safeService.login(loginBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeBy(
                onNext = {
                    user.value = Response.success(it.data)
                },
                onError = {
                    user.value = Response.error(ApiErrorHandler.handleErrorResponse(it))
                })
            .addTo(compositeDisposable)

        return user
    }

}