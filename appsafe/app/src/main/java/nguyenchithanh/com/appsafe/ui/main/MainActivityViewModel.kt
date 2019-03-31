package nguyenchithanh.com.appsafe.ui.main

import dagger.Module
import nguyenchithanh.com.appsafe.base.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor() : BaseViewModel() {


    override fun onCleared() {
//        compositeDisposable.addAll(userReponse.compositeDisposable)
        super.onCleared()
    }
}