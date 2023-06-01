package com.devyash.serializableandparcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devyash.serializableandparcelable.databinding.ActivityGetDataBinding
import com.devyash.serializableandparcelable.databinding.ActivityMainBinding

class GetDataActivity : AppCompatActivity() {

    private var _binding: ActivityGetDataBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}