package com.devyash.serializableandparcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.Person
import com.devyash.serializableandparcelable.databinding.ActivityMainBinding
import com.devyash.serializableandparcelable.models.PersonWithParcelable
import com.devyash.serializableandparcelable.models.PersonWithSerializable

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendDataSerializable.setOnClickListener {
            sendDataUsingSerializables()
        }

        binding.btnSendDataParcelable.setOnClickListener {
            sendDataUsingParcelable()
        }

    }

    private fun sendDataUsingSerializables() {
        val person = PersonWithSerializable(2, "Yashveer Singh", "Delhi", 20)
        val intent = Intent(this, GetDataActivity::class.java)
        intent.putExtra("PERSON_S", person)
        startActivity(intent)
    }

    private fun sendDataUsingParcelable() {
        val person = PersonWithParcelable(1,"Yash","Noida",20)
        val intent = Intent(this, GetDataActivity::class.java)
        intent.putExtra("PERSON_P",person)

        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}