package nguyenchithanh.com.appsafe.ui.screen.contact


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import nguyenchithanh.com.appsafe.R
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList
import nguyenchithanh.com.appsafe.ui.screen.contact.adapter.MyRecyclerViewAdapter
import nguyenchithanh.com.appsafe.ui.screen.contact.model.PhoneAddContact
import nguyenchithanh.com.appsafe.utils.layout.MyScrollListView


class AddContactFragment : Fragment() {

    lateinit var img_tb_left: ImageView
    lateinit var lv_phone: ListView
    var listPhone = ArrayList<PhoneAddContact>()
    lateinit var adapterPhone:MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view: View) {

//        img_tb_left = view.findViewById(R.id.img_tb_left)
//        img_tb_left.setImageResource(R.drawable.ic_cloud_download)

        lv_phone = view.findViewById(R.id.lv_phone)
        listPhone.add(PhoneAddContact("",0,"Di động",false))
        adapterPhone = MyRecyclerViewAdapter(context as AppCompatActivity,listPhone)
        lv_phone.adapter = adapterPhone


//        adapterPhone.notifyDataSetChanged()



    }

}
