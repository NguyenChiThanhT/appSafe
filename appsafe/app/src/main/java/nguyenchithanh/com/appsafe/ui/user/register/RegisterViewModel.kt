package nguyenchithanh.com.appsafe.ui.user.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import nguyenchithanh.com.appsafe.api.Response
import nguyenchithanh.com.appsafe.base.BaseViewModel
import nguyenchithanh.com.appsafe.data.repo.UserRepo
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.model.apibody.UserBody
import javax.inject.Inject

class RegisterViewModel
      @Inject constructor(
          private val userRepo: UserRepo) : BaseViewModel() {

    private val registerBody = MutableLiveData<UserBody>()

    val resultRegister : LiveData<Response<User>>? = Transformations.switchMap(registerBody) {
        userRepo.register(it)
    }

    fun register(userBody: UserBody) {
        this.registerBody.value = userBody
    }

    override fun onCleared() {
        compositeDisposable.addAll(userRepo.compositeDisposable)
        super.onCleared()
    }
}