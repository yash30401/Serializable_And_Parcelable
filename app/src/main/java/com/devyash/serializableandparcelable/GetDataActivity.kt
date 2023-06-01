package com.devyash.serializableandparcelable

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSerializableData()
        getParcelableData()
    }


    private fun getSerializableData() {
        val intent = intent.extras
        val person = intent?.getSerializable("PERSON_S") as PersonWithSerializable

        binding.tvId.text = "Id: ${person.id.toString()}"
        binding.tvName.text = "Name: ${person.name.toString()}"
        binding.tvAddress.text = "Address: ${person.address.toString()}"
        binding.tvAge.text = "Age: ${person.age.toString()}"

    }

    private fun getParcelableData(){
        val intent = intent.extras
        val person = intent?.getParcelable<PersonWithParcelable>("PERSON_P")


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