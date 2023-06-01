package com.devyash.serializableandparcelable

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.devyash.serializableandparcelable.databinding.ActivityGetDataBinding
import com.devyash.serializableandparcelable.databinding.ActivityMainBinding
import com.devyash.serializableandparcelable.models.PersonWithParcelable
import com.devyash.serializableandparcelable.models.PersonWithSerializable

class GetDataActivity : AppCompatActivity() {

    private var _binding: ActivityGetDataBinding? = null
    private val binding get() = _binding!!
    private var bundle: Bundle? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bundle = intent.extras

        getSerializableData()
        getParcelableData()
    }


    private fun getSerializableData() {

        val person = bundle?.getSerializable("PERSON_S") as? PersonWithSerializable

        person?.let {
            binding.tvId.text = "Id: ${it.id.toString()}"
            binding.tvName.text = "Name: ${it.name.toString()}"
            binding.tvAddress.text = "Address: ${it.address.toString()}"
            binding.tvAge.text = "Age: ${it.age.toString()}"
        }

    }

    private fun getParcelableData(){
        val person = bundle?.getParcelable<PersonWithParcelable>("PERSON_P")


        person?.let {
            binding.tvId.text = "Id: ${it.id.toString()}"
            binding.tvName.text = "Name: ${it.name.toString()}"
            binding.tvAddress.text = "Address: ${it.address.toString()}"
            binding.tvAge.text = "Age: ${it.age.toString()}"
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}