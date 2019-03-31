package nguyenchithanh.com.appsafe.api

import io.reactivex.Observable
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.model.apibody.UserBody
import retrofit2.http.Body
import retrofit2.http.POST

interface SafeService {
    @POST("appsafe/register.php")
    fun register(@Body registerBody: UserBody): Observable<BaseResponse<User>>
    @POST("appsafe/login.php")
    fun login(@Body loginBody:UserBody): Observable<BaseResponse<User>>
}