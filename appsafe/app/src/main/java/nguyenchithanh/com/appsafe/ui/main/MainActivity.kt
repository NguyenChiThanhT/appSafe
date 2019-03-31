package nguyenchithanh.com.appsafe.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import nguyenchithanh.com.appsafe.R
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.CONTACT
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.KEY_INTENT_SCREEN
import nguyenchithanh.com.appsafe.keyscreen.KeyScreen.PICTURE
import nguyenchithanh.com.appsafe.ui.screen.ScreenActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    private fun setupView() {

        ln_picture.setOnClickListener {
            var picture = Intent(this,ScreenActivity::class.java)
            picture.putExtra(KEY_INTENT_SCREEN,PICTURE)
            startActivity(picture)
        }

        ln_contact.setOnClickListener {
            var contact = Intent(this,ScreenActivity::class.java)
            contact.putExtra(KEY_INTENT_SCREEN,CONTACT)
            startActivity(contact)
        }
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
