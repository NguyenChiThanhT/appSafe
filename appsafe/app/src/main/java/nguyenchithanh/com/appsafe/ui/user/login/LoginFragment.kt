package nguyenchithanh.com.appsafe.ui.user.login


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import es.dmoral.toasty.Toasty
import nguyenchithanh.com.appsafe.R
import nguyenchithanh.com.appsafe.api.Response
import nguyenchithanh.com.appsafe.api.ResponseError
import nguyenchithanh.com.appsafe.api.Status
import nguyenchithanh.com.appsafe.data.pref.SafeSharedPreferences
import nguyenchithanh.com.appsafe.di.Injectable
import nguyenchithanh.com.appsafe.model.User
import nguyenchithanh.com.appsafe.model.apibody.UserBody
import nguyenchithanh.com.appsafe.ui.main.MainActivity
import nguyenchithanh.com.appsafe.utils.fragment.SetUpFrgment
import javax.inject.Inject


class LoginFragment : Fragment(),Injectable,HasSupportFragmentInjector {

    lateinit var edt_pass: TextView
    lateinit var txt_number_one: TextView
    lateinit var txt_number_two: TextView
    lateinit var txt_number_three: TextView
    lateinit var txt_number_four: TextView
    lateinit var txt_number_five: TextView
    lateinit var txt_number_six: TextView
    lateinit var txt_number_seven: TextView
    lateinit var txt_number_eight: TextView
    lateinit var txt_number_night: TextView
    lateinit var txt_ok: TextView
    lateinit var txt_number_zero: TextView
    lateinit var txt_remove_number: TextView

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var safeSharedPreferences: SafeSharedPreferences

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        setupView(view)
        setupViewModel()

        return view
    }

    private fun setupView(view: View) {
        edt_pass = view.findViewById(R.id.edt_pass)
        txt_number_one = view.findViewById(R.id.txt_number_one)
        txt_number_two = view.findViewById(R.id.txt_number_two)
        txt_number_three = view.findViewById(R.id.txt_number_three)
        txt_number_four = view.findViewById(R.id.txt_number_four)
        txt_number_five = view.findViewById(R.id.txt_number_five)
        txt_number_six = view.findViewById(R.id.txt_number_six)
        txt_number_seven = view.findViewById(R.id.txt_number_seven)
        txt_number_eight = view.findViewById(R.id.txt_number_eight)
        txt_number_night = view.findViewById(R.id.txt_number_night)
        txt_ok = view.findViewById(R.id.txt_ok)
        txt_number_zero = view.findViewById(R.id.txt_number_zero)
        txt_remove_number = view.findViewById(R.id.txt_remove_number)

        txt_ok.visibility = View.GONE
        txt_remove_number.visibility = View.GONE

        buttonClickNumber()

    }

    private fun setupViewModel(){

        loginViewModel =ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel::class.java)
        loginViewModel.resultLogin?.observe(this, Observer {
            handleDataRespone(it)
        })
    }

    private fun handleDataRespone(response: Response<User>) {
        when (response.status) {
            Status.LOADING -> loadingState()
            Status.SUCCESS -> successfulState(response.data!!)
            Status.ERROR -> errorState(response.error!!)
        }
    }

    private fun loadingState() {
//        progressDialogLogin.show()
    }

    private fun successfulState(user: User) {
        if(user.status ==1) {
            val intentMain = Intent(context as AppCompatActivity,MainActivity::class.java)
            intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentMain)
        } else {
            Toasty.error(context as AppCompatActivity,user.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun errorState(error: ResponseError) {
        Toasty.success(context as AppCompatActivity,error.status_message, Toast.LENGTH_SHORT).show()
    }

    private fun buttonClickNumber() {
        txt_number_one.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "1")
        }

        txt_number_two.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "2")
        }

        txt_number_three.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "3")
        }

        txt_number_four.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "4")
        }

        txt_number_five.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "5")
        }

        txt_number_six.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "6")
        }

        txt_number_seven.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "7")
        }

        txt_number_eight.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "8")
        }

        txt_number_night.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "9")
        }

        txt_number_zero.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()
            checkShowText(strPass, "0")
        }

        txt_ok.setOnClickListener {
            val intentMain = Intent(context as AppCompatActivity,MainActivity::class.java)
            intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intentMain)
//           loginViewModel.login(UserBody(edt_pass.text.toString().trim()))
        }

        txt_remove_number.setOnClickListener {
            var strPass = edt_pass.text.toString().trim()

            checkShowText(strPass,"")

            if (strPass.length-1 > 0) {
                val currentPass = strPass.substring(0, strPass.length - 1)
                edt_pass.text = currentPass
            } else {
                txt_remove_number.visibility = View.GONE
                val currentPass = strPass.substring(0, strPass.length - 1)
                edt_pass.text = currentPass
            }
        }
    }

    private fun checkShowText(strPass: String, number: String) {
        if (strPass.length > 4) {
            txt_ok.visibility = View.VISIBLE
            edt_pass.text = strPass + number
        } else {
            txt_ok.visibility = View.GONE
            edt_pass.text = strPass + number
        }
        txt_remove_number.visibility = View.VISIBLE
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
