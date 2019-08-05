package com.android.uitoux

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.submit_btn -> {

//                    val bundle = Bundle()
//                    bundle.putSerializable("Attachments", dataList)

                    val intent = Intent(this, DataActivity::class.java)
                    intent.putExtra("Attachments", dataList)
                    startActivity(intent)


                    for(data in dataList.indices){
                        Log.e(TAG, "Question "+dataList[data].title)
                        Log.e(TAG, "Answer "+dataList[data].answer)
                    }
                }
            }
        }
    }

    var dataList: ArrayList<FormData> = ArrayList()
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dataList.add(FormData("Number",""))

        submit_btn.setOnClickListener(this)

        dynamic_rv.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        var goodCatchListAdapter = DynamicFormAdapter(dataList, applicationContext)
        dynamic_rv.adapter = goodCatchListAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
