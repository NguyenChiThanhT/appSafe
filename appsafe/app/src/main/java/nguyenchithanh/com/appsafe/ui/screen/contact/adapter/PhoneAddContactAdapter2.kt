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

class PhoneAddContactAdapter2(val context: Context, var listPhone: ArrayList<PhoneAddContact>) : BaseAdapter() {

    var countEdtPhone:Int = 0
    internal var txtArrSpinner = java.util.ArrayList<TextView>()
    val arrSpinner = arrayOf("Di động", "Cơ quan", "Nhà riêng", "Số chính", "Số fax cơ quan", "số fax nhà riêng", "Số máy nhắn tin", "Khác", "Tuỳ chỉnh")

    override fun getCount(): Int {
        return listPhone.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val holder = ViewHolder()
        val rowView: View
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rowView = inflater.inflate(R.layout.item_add_contact_phone, null)

        holder.img_removePhone = rowView.findViewById(R.id.img_removePhone) as ImageView
        holder.img_removePhone.visibility = View.GONE

        holder.edt_number = rowView.findViewById(R.id.edt_number) as EditText
        holder.txt_spinner = rowView.findViewById(R.id.txt_spinner) as TextView

        txtArrSpinner.add(position, holder.txt_spinner)
        holder.edt_number.setText(listPhone.get(position).number_phone)

        txtArrSpinner.get(position).setText(listPhone.get(position).name_spinner)


        if (holder.edt_number.text.length > 0) {
            holder.img_removePhone.visibility = View.VISIBLE
            listPhone.set(position, PhoneAddContact(holder.edt_number.getText().toString(), position, holder.txt_spinner.getText().toString(), true))
        } else {
            holder.img_removePhone.visibility = View.GONE
            listPhone.set(position, PhoneAddContact(holder.edt_number.getText().toString(), position, holder.txt_spinner.getText().toString(), false))
        }

        if (countEdtPhone == position) {
            holder.edt_number.setSelection(holder.edt_number.text.length)
            holder.edt_number.requestFocus()
        }

        //event
        holder.img_removePhone.setOnClickListener {
            listPhone.removeAt(position)
            countEdtPhone = position
            notifyDataSetChanged()
        }

        var textWatcher = object :TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {
                countEdtPhone = position

                if (i == 0 && i1 == 0 && i2 == 1) {

                    if (position == 0) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[1], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 1) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[2], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 2) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[3], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 3) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[4], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 4) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[5], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 5) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[6], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position == 6) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[7], false))
                        holder.edt_number.addTextChangedListener(this)

                    } else if (position >= 7) {
                        holder.edt_number.removeTextChangedListener(this)
                        listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[8], false))
                        holder.edt_number.addTextChangedListener(this)
                    }


//                    when (position) {
//                        0 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[1], false))
//
//                        1 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[2], false))
//
//                        2 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[3], false))
//
//                        3 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[4], false))
//
//                        4 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[5], false))
//
//                        5 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[6], false))
//
//                        6 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[7], false))
//
//                        7 -> listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[8], false))
//
//                        else ->{
//                            listPhone.add(PhoneAddContact("", listPhone.size, arrSpinner[8], false))
//                        }
//                    }

                    notifyDataSetChanged()
                }

                if (position == 0) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[0],true))

                } else if (position == 1) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[1],true))

                } else if (position == 2) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[2],true))

                } else if (position == 3) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[3],true))

                } else if (position == 4) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[4],true))
                } else if (position == 5) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[5],true))

                } else if (position == 6) {

                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[6],true))

                }  else if(position == 7) {
                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[7],true))

                }
                else if (position >= 8) {
                    listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[8],true))

                }

//                when(position) {
//
//                    0 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[0],true))
//
//                    1 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[1],true))
//
//                    2 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[2],true))
//
//                    3 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[3],true))
//
//                    4 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[4],true))
//
//                    5 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[5],true))
//
//                    6 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[6],true))
//
//                    7 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[7],true))
//
//                    8 -> listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[8],true))
//
//                    else ->{
//                        listPhone.set(position,PhoneAddContact(holder.edt_number.getText().toString(), position, arrSpinner[8],true))
//                    }
//                }

            }

            override fun afterTextChanged(charSequence: Editable?) {
                countEdtPhone = position

                if (TextUtils.isEmpty(charSequence.toString().trim())) {
                    for (l in listPhone.indices) {
                        if (listPhone.get(l).check_remove === false && listPhone.get(l).count_spinner !== position) {
                            holder.edt_number.removeTextChangedListener(this)
                            Log.d("thank","" + l)
                            listPhone.removeAt(l)
                            notifyDataSetChanged()
                            holder.edt_number.addTextChangedListener(this)
                        }
                    }

                }
            }

        }

        holder.edt_number.addTextChangedListener(textWatcher)

        txtArrSpinner.get(position).setOnClickListener {
            val dialogParent = Dialog(context)
            dialogParent.setContentView(R.layout.custom_item_dialog_spinner)

            var edt_name_spinner = dialogParent.findViewById(R.id.txt_dd) as TextView

            edt_name_spinner.setOnClickListener {
                val dialog = Dialog(context)
                dialog.setContentView(R.layout.custom_dialog_enter_spinner)
                val edt_name = dialog.findViewById(R.id.edt_enter_spinner) as EditText
                val btn_yes = dialog.findViewById(R.id.btn_yes) as Button

                btn_yes.setOnClickListener {
//                    listPhone.set(
//                        position,
//                        PhoneAddContact(holder.edt_number.getText().toString(), position, edt_name.text.toString())
//                    )
//
//                    txtArrSpinner.get(position).setText(listPhone.get(position).name_spinner)
//                    dialog.dismiss()
                }

                dialog.show()
                dialogParent.dismiss()
            }
            dialogParent.show()
        }



        return rowView
    }


    class ViewHolder {
        lateinit var edt_number: EditText
        lateinit var img_removePhone: ImageView
        lateinit var txt_spinner: TextView
    }
}