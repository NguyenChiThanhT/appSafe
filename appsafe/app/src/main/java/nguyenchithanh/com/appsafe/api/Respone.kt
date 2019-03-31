package nguyenchithanh.com.appsafe.api

data class Response<out T>(val status: Status,val data: T?, val error: ResponseError?) {
    companion object {
        fun <T> loading(): Response<T> {
            return Response(Status.LOADING,null,null)
        }

        fun <T> success(data: T?): Response<T> {
            return Response(Status.SUCCESS,data,null)
        }

        fun <T> error(error: ResponseError?): Response<T> {
            return Response(Status.ERROR,null,error)
        }
    }
}