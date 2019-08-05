package com.android.uitoux

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_data.view.*
import java.util.ArrayList

class DataListAdapter() : RecyclerView.Adapter<DataListAdapter.ViewHolder>(){
    constructor(dataList: ArrayList<FormData>, applicationContext: Context?) : this(){
        this.dataList = dataList
        this.context = applicationContext
    }

    private val TAG = "DynamicFormAdapter"
    var context: Context? = null
    lateinit var dataList: ArrayList<FormData>

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val qusTxt = itemView.question_txt
        val ansTxt = itemView.answer_txt!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_data, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.count()-1
        //-1 bcz last data is always Empty
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            holder.qusTxt.text = dataList[position].title
            holder.ansTxt.text = (dataList[position].answer)
        }
    }
}