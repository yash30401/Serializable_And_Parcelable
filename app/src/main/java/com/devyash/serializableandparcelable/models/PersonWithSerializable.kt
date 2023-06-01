package com.devyash.serializableandparcelable.models

import java.io.Serializable

data class PersonWithSerializable(
    val id: Int? = 0,
    val name: String? = "",
    val address: String? = "",
    val age: Int? = 18
) : Serializable