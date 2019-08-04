package com.android.uitoux

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_dynamic.view.*
import java.util.ArrayList

class DynamicFormAdapter() : RecyclerView.Adapter<DynamicFormAdapter.ViewHolder>(){
    constructor(dataList: ArrayList<FormData>, applicationContext: Context?) : this() {
        this.dataList = dataList
        this.context = applicationContext
    }

    private val TAG = "DynamicFormAdapter"
    var context: Context? = null
    lateinit var dataList: ArrayList<FormData>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listTxt = itemView.list_txt
        val listEdt = itemView.list_edt!!

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_dynamic, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        if (holder != null) {
            holder.listEdt.tag = position
            holder.listTxt.text = dataList[position].title
            holder.listEdt.setText(dataList[position].answer)

            holder.listTxt.setOnClickListener { Log.e(TAG, dataList[position].answer) }


            holder.listEdt.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(
                    s: CharSequence, start: Int, before: Int,
                    count: Int
                ) {
                    val position2 = holder.listEdt.id
                    if (holder.listEdt.text.toString().isNotEmpty()) {
                        dataList[position].answer = s.toString()

                        if (position==dataList.size-1){
                            dataList.add(FormData("Number "+dataList.size,""))
                            notifyItemInserted(position+1)
                        }

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int,
                    after: Int
                ) {
                    // TODO Auto-generated method stub
                }

                override fun afterTextChanged(s: Editable) {

                }

            })
        }

    }

}