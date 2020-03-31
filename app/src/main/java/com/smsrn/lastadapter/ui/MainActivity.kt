package com.smsrn.lastadapter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.smsrn.lastadapter.R
import com.smsrn.lastadapter.databinding.ActivityMainBinding
import com.smsrn.lastadapter.util.GenericListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.listener = object : GenericListener {
            override fun onSingleItemTapped() {
                startActivity(Intent(this@MainActivity, SingleItemClickActivity::class.java))
            }

            override fun onMultipleItemTapped() {
                startActivity(Intent(this@MainActivity, MultipleItemClickActivity::class.java))
            }
        }
    }
}
