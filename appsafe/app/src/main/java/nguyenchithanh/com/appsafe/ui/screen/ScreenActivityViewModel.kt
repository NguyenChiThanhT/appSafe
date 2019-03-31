package nguyenchithanh.com.appsafe.ui.screen

import dagger.Module
import nguyenchithanh.com.appsafe.base.BaseViewModel
import javax.inject.Inject

class ScreenActivityViewModel @Inject constructor() : BaseViewModel() {


    override fun onCleared() {
//        compositeDisposable.addAll(userReponse.compositeDisposable)
        super.onCleared()
    }
}