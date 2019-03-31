package nguyenchithanh.com.appsafe.ui.screen.contact


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import nguyenchithanh.com.appsafe.R
import android.widget.*
import es.dmoral.toasty.Toasty
import nguyenchithanh.com.appsafe.utils.fragment.SetUpFrgment




class ContactFragment : Fragment(){

    lateinit var fab_add: FloatingActionButton
    lateinit var txt_tb_center: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view: View) {

        txt_tb_center = view.findViewById(R.id.txt_tb_center)
        txt_tb_center.text = "Danh bạ"

        fab_add = view.findViewById(R.id.fab_add)
        fab_add.setOnClickListener {
            val addContactFragment = AddContactFragment()
            SetUpFrgment.replaceFragment(context as AppCompatActivity, addContactFragment, (R.id.containerScreen))
        }

    }
}
