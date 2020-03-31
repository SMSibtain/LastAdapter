package com.smsrn.lastadapter.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smsrn.lastadapter.R
import com.smsrn.lastadapter.adapter.LastAdapter
import com.smsrn.lastadapter.databinding.ActivityMultipleItemClickBinding
import com.smsrn.lastadapter.model.GeneralItem
import com.smsrn.lastadapter.util.Utils
import kotlinx.android.synthetic.main.activity_multiple_item_click.*

class MultipleItemClickActivity : AppCompatActivity() {

    lateinit var binding: ActivityMultipleItemClickBinding
    lateinit var lastAdapter: LastAdapter<GeneralItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multiple_item_click)

        // USE MENTION BELOW LINE IF YOU ONLY WANT TO SHOW THE LIST, NO EXECUTION REQUIRED ON USER TAP
        /*lastAdapter = LastAdapter(R.layout.recycler_item_multiple)*/

        lastAdapter = LastAdapter(R.layout.recycler_item_multiple, object : LastAdapter.OnItemClickListener<GeneralItem> {
            override fun onItemClick(item: GeneralItem) {
                Toast.makeText(this@MultipleItemClickActivity, item.firstValue, Toast.LENGTH_SHORT).show()
            }

            override fun onSubItemOneClick(item: GeneralItem) {
                Toast.makeText(this@MultipleItemClickActivity, item.secondValue, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = lastAdapter
        lastAdapter.items = Utils.getGeneralItemList()
    }
}
