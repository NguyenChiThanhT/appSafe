package nguyenchithanh.com.appsafe.ui.user.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import nguyenchithanh.com.appsafe.api.Response
import nguyenchithanh.com.appsafe.base.BaseViewModel
import nguyenchithanh.com.appsafe.data.repo.UserRepo
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.model.apibody.UserBody
import javax.inject.Inject


class LoginViewModel
@Inject constructor(
    private val userRepo: UserRepo) : BaseViewModel() {

    private var loginBody = MutableLiveData<UserBody>()
    val resultLogin: LiveData<Response<User>>? = Transformations.switchMap(loginBody) {
        userRepo.login(it)
    }

    fun login(loginBody: UserBody) {
        this.loginBody.value = loginBody
    }

    override fun onCleared() {
        compositeDisposable.addAll(userRepo.compositeDisposable)
        super.onCleared()
    }
}