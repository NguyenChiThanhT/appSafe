package nguyenchithanh.com.appsafe.utils.extention

import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import nguyenchithanh.com.appsafe.di.GlideApp

//fun ImageView.displayProfilePicture(imgUrl: String, radius: Int){
//    GlideApp.with(this.context)
//            .load(imgUrl)
//            .placeholder(R.drawable.ic_user)
//            .error(R.drawable.ic_user)
//            .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(radius)))
//            .into(this)
//}

fun ImageView.displayPictureInLibrary(imgUrl: String?){
    GlideApp.with(this.context)
            .load(imgUrl)
            .into(this)
}