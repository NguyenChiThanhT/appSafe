package nguyenchithanh.com.appsafe.ui.screen.contact.adapter

import android.app.Dialog
import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import nguyenchithanh.com.appsafe.R
import nguyenchithanh.com.appsafe.ui.screen.contact.model.PhoneAddContact
import java.util.ArrayList

class MyRecyclerViewAdapter(internal var context: Context, var mylist: ArrayList<PhoneAddContact>) : BaseAdapter() {
    internal var posi = 0
    internal var txtArrPinner = ArrayList<TextView>()


    override fun getCount(): Int {
        return mylist.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class Holder {
        internal var tvRateNum: LinearLayout? = null
        internal var edtAnimal: EditText? = null
        internal var btn_xoa: ImageView? = null
        internal var type_spinner: TextView? = null
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val holder = MyRecyclerViewAdapter.Holder()
        val rowView: View
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rowView = inflater.inflate(R.layout.item_add_contact_phone, null)

        holder.btn_xoa = rowView.findViewById<View>(R.id.img_removePhone) as ImageView
        holder.btn_xoa!!.setVisibility(View.GONE)
        holder.btn_xoa!!.setOnClickListener(View.OnClickListener {
            mylist.removeAt(position)
            posi = position
            notifyDataSetChanged()
        })

        holder.edtAnimal = rowView.findViewById<View>(R.id.edt_number) as EditText
        holder.type_spinner = rowView.findViewById<View>(R.id.txt_spinner) as TextView


        txtArrPinner.add(position, holder.type_spinner!!)
        holder.edtAnimal!!.setText(mylist[position].number_phone)

        txtArrPinner[position].setText(mylist[position].name_spinner)


        if (holder.edtAnimal!!.getText().length > 0) {
            holder.btn_xoa!!.setVisibility(View.VISIBLE)
            mylist[position] =
                    PhoneAddContact(
                        holder.edtAnimal!!.getText().toString(),
                        position,
                        holder.type_spinner!!.getText().toString(),
                        true
                    )

        } else {
            holder.btn_xoa!!.setVisibility(View.GONE)
            mylist[position] =
                    PhoneAddContact(
                        holder.edtAnimal!!.getText().toString(),
                        position,
                        holder.type_spinner!!.getText().toString(),
                        false
                    )
        }

        if (position == posi) {
            holder.edtAnimal!!.setSelection(holder.edtAnimal!!.getText().length)
            holder.edtAnimal!!.requestFocus()
        }


        holder.edtAnimal!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                posi = position
                if (i == 0 && i1 == 0 && i2 == 1) {

                    if (position == 0) {

                        mylist.add(PhoneAddContact("", mylist.size, "Cơ quan", false))

                    } else if (position == 1) {

                        mylist.add(PhoneAddContact("", mylist.size, "Nhà riêng", false))

                    } else if (position == 2) {

                        mylist.add(PhoneAddContact("", mylist.size, "Số chính", false))

                    } else if (position == 3) {

                        mylist.add(PhoneAddContact("", mylist.size, "Số fax cơ quan", false))

                    } else if (position == 4) {

                        mylist.add(PhoneAddContact("", mylist.size, "số fax nhà riêng", false))

                    } else if (position == 5) {

                        mylist.add(PhoneAddContact("", mylist.size, "Số máy nhắn tin", false))

                    } else if (position > 6) {

                        mylist.add(PhoneAddContact("", mylist.size, "Khác", false))

                    } else if (position >= 7) {
                        mylist.add(PhoneAddContact("", mylist.size, "Tuỳ chỉnh", false))
                    }

                    notifyDataSetChanged()
                }


                try {
                    if (position == 0) {

                        mylist[position] = PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Di động", true)

                    } else if (position == 1) {

                        mylist[position] = PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Cơ quan", true)

                    } else if (position == 2) {

                        mylist[position] = PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Nhà riêng", true)

                    } else if (position == 3) {

                        mylist[position] = PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Số chính", true)

                    } else if (position == 4) {

                        mylist[position] =
                                PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Số fax cơ quan", true)

                    } else if (position == 5) {

                        mylist[position] =
                                PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "số fax nhà riêng", true)

                    } else if (position == 6) {

                        mylist[position] =
                                PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Số máy nhắn tin", true)

                    } else if (position >= 7) {

                        mylist[position] = PhoneAddContact(holder.edtAnimal!!.getText().toString(), position, "Khác", true)
                    }
                } catch (e: Exception) {
                    Log.d("thank", e.message)
                }


            }

            override fun afterTextChanged(charSequence: Editable) {
                posi = position


                if (TextUtils.isEmpty(charSequence.toString().trim { it <= ' ' })) {
                    for (l in mylist.indices) {
                        if (mylist[l].check_remove === false && mylist[l].count_spinner !== position) {
                            mylist.removeAt(l)
                        }
                    }
                    notifyDataSetChanged()
                }
            }
        })


        return rowView
    }
}
