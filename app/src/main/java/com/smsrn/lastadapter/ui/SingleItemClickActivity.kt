package com.smsrn.lastadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.smsrn.lastadapter.R
import com.smsrn.lastadapter.adapter.LastAdapter
import com.smsrn.lastadapter.databinding.ActivitySingleItemClickBinding
import com.smsrn.lastadapter.util.Utils
import kotlinx.android.synthetic.main.activity_single_item_click.*

class SingleItemClickActivity : AppCompatActivity() {

    lateinit var binding: ActivitySingleItemClickBinding
    lateinit var lastAdapter: LastAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_item_click)

        // USE MENTION BELOW LINE IF YOU ONLY WANT TO SHOW THE LIST, NO EXECUTION REQUIRED ON USER TAP
        /*lastAdapter = LastAdapter(R.layout.recycler_item_single)*/

        lastAdapter = LastAdapter(R.layout.recycler_item_single, object : LastAdapter.OnItemClickListener<String> {
            override fun onItemClick(item: String) {
                Toast.makeText(this@SingleItemClickActivity, item, Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = lastAdapter
        lastAdapter.items = Utils.getStringList()
    }
}
