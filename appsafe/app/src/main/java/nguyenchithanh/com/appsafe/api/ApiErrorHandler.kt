package nguyenchithanh.com.appsafe.api

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ApiErrorHandler {
    private const val STATUS_CODE_TYPE_UNKNOW = "STATUS_CODE_TYPE_UNKNOW"
    private const val STATUS_CODE_TYPE_SERVER = "STATUS_CODE_TYPE_SERVER"

    fun handleErrorResponse(e: Throwable): ResponseError {
        try{
            return when(e){
                is HttpException  -> {
                    if(e.code() == 500)
                        ResponseError(500, "Server error!", STATUS_CODE_TYPE_SERVER)
                    else {
                        convertToResponseError(e.response().errorBody()!!)
                    }
                }
                is UnknownHostException ->  ResponseError(400,"No internet connection!", STATUS_CODE_TYPE_UNKNOW)
                is SocketTimeoutException ->  ResponseError(400,"Time out!", STATUS_CODE_TYPE_UNKNOW)
                else -> ResponseError(400,"Somethings wrong!", STATUS_CODE_TYPE_UNKNOW)
            }
        }
        catch (ex: Exception){
            return ResponseError(400, "Somethings wrong!", STATUS_CODE_TYPE_UNKNOW)
        }
    }

    fun handleErrorResponse(e: Any): ResponseError {
        return try{
            val response =  (e as Response<*>)
            when(response.code()){
                in 400..499 -> {
                    convertToResponseError(response.errorBody()!!)
                }
                500 -> ResponseError(500, "Server error!", STATUS_CODE_TYPE_SERVER)
                else -> ResponseError(400, "Somethings wrong!", STATUS_CODE_TYPE_UNKNOW)
            }
        }
        catch (ex: Exception){
            ResponseError(400, "Somethings wrong!", STATUS_CODE_TYPE_UNKNOW)
        }
    }

    private fun getMessage(code: Int, serverMsg: String): String{
        //val defaultMsg = "Somethings wrong!"
        return when(code){
            else -> serverMsg
        }
    }

    private fun convertToResponseError(e: ResponseBody):ResponseError{
        val jsonObject = JSONObject(e.string())
        val errorObject = JSONObject(jsonObject.getString("error"))
        val serverMessage = errorObject.getString("message")
        val code = errorObject.getInt("code")
        val codeType = errorObject.getString("code_type")
        return ResponseError(code, getMessage(code, serverMessage), codeType)
    }
}