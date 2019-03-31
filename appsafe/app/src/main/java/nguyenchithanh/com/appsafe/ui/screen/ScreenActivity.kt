package nguyenchithanh.com.appsafe.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nguyenchithanh.com.appsafe.R
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.CONTACT
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.KEY_INTENT_SCREEN
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.PICTURE
import nguyenchithanh.com.appsafe.ui.screen.contact.ContactFragment
import nguyenchithanh.com.appsafe.ui.screen.picture.PictureFragment
import nguyenchithanh.com.appsafe.ui.user.register.RegisterFragment
import nguyenchithanh.com.appsafe.utils.fragment.SetUpFrgment

class ScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)
        val contactFragment = ContactFragment()
        SetUpFrgment.replaceFragment(this,contactFragment,(R.id.containerScreen))
    }

    override fun onResume() {
//        val getDataMain = intent.getStringExtra(KEY_INTENT_SCREEN)
//        LoadFragment(getDataMain)

        super.onResume()
    }

    private fun LoadFragment(getDataMain:String) {

        when(getDataMain){

            CONTACT -> {
                val contactFragment = ContactFragment()
                SetUpFrgment.replaceFragment(this,contactFragment,(R.id.containerScreen))
            }

            PICTURE -> {
                val pictureFragment = PictureFragment()
                SetUpFrgment.replaceFragment(this,pictureFragment,(R.id.containerScreen))
            }

        }
    }
}
