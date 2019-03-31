package nguyenchithanh.com.appsafe.ui.user

import dagger.Module
import nguyenchithanh.com.appsafe.base.BaseViewModel
import javax.inject.Inject

class UserActivityViewModel @Inject constructor() : BaseViewModel() {


    override fun onCleared() {
//        compositeDisposable.addAll(userReponse.compositeDisposable)
        super.onCleared()
    }
}