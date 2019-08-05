package com.android.uitoux

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.content_main.*


class DataActivity : AppCompatActivity() {

    private val TAG = "DataActivity"

    lateinit var dataList: ArrayList<FormData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)


        val data = intent.extras
        if (data != null) {
            dataList = data.getParcelableArrayList<FormData>("Attachments")
            Log.e(TAG, "  "+dataList.count())
        }

        dynamic_rv.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        var goodCatchListAdapter = DataListAdapter(dataList, applicationContext)
        dynamic_rv.adapter = goodCatchListAdapter

    }
}
