package com.smsrn.lastadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.smsrn.lastadapter.R
import com.smsrn.lastadapter.adapter.LastAdapter
import com.smsrn.lastadapter.databinding.ActivityMultipleItemClickBinding
import com.smsrn.lastadapter.databinding.ActivityMultipleItemClickWithFilterBinding
import com.smsrn.lastadapter.model.GeneralFilterItem
import com.smsrn.lastadapter.model.GeneralItem
import com.smsrn.lastadapter.util.Utils
import kotlinx.android.synthetic.main.activity_multiple_item_click.*
import kotlinx.android.synthetic.main.activity_multiple_item_click.recyclerView
import kotlinx.android.synthetic.main.activity_multiple_item_click_with_filter.*

class MultipleItemClickWithFilterActivity : AppCompatActivity() {
    lateinit var binding: ActivityMultipleItemClickWithFilterBinding
    lateinit var lastAdapter: LastAdapter<GeneralFilterItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_multiple_item_click_with_filter)

        editTextFilter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (::lastAdapter.isInitialized) {
                    lastAdapter.filter.filter(s)
                }
            }
        })

        // USE MENTION BELOW LINE IF YOU ONLY WANT TO SHOW THE LIST, NO EXECUTION REQUIRED ON USER TAP
        /*lastAdapter = LastAdapter(R.layout.recycler_item_multiple_filter)*/

        lastAdapter = LastAdapter(
            R.layout.recycler_item_multiple_filter,
            object : LastAdapter.OnItemClickListener<GeneralFilterItem> {
                override fun onItemClick(item: GeneralFilterItem) {
                    Toast.makeText(this@MultipleItemClickWithFilterActivity, item.firstValue, Toast.LENGTH_SHORT).show()
                }

                override fun onSubItemOneClick(item: GeneralFilterItem) {
                    Toast.makeText(this@MultipleItemClickWithFilterActivity, item.thirdValue, Toast.LENGTH_SHORT).show()
                }
            })

        recyclerView.adapter = lastAdapter
        lastAdapter.items = Utils.getGeneralFilterItemList()
    }
}
