package nguyenchithanh.com.appsafe.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.lang.RuntimeException

data class ResponseError(
    @SerializedName("code")
    val status_code: Int,
    @SerializedName("message")
    val status_message: String,
    @SerializedName("code_type")
    val status_code_type: String
) : RuntimeException(), Serializable