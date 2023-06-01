# Serializable_And_Parcelable
#### This project demonstrates the usage of Serializable and Parcelable interfaces in Android to pass data between activities.

## Introduction
#### This app showcases the usage of Serializable and Parcelable interfaces for data serialization and deserialization in Android. It includes two data classes: PersonWithSerializable and PersonWithParcelable. The MainActivity allows you to send data using either Serializable or Parcelable, and the GetDataActivity retrieves the data and displays it on the screen.

## Usage
1. Clone the repository: git clone https://github.com/yash30401/Serializable_And_Parcelable.git
2. Open the project in Android Studio.
3. Run the app on an Android device or emulator.
4. The MainActivity will be displayed, featuring two buttons: "Send Data (Serializable)" and "Send Data (Parcelable)".
5. Click on the "Send Data (Serializable)" button to send data using Serializable.
``` kotlin
binding.btnSendDataSerializable.setOnClickListener {
    val person = PersonWithSerializable(2, "Yashveer Singh", "Delhi", 20)
    val intent = Intent(this, GetDataActivity::class.java)
    intent.putExtra("PERSON_S", person)
    startActivity(intent)
}
```
6. Click on the "Send Data (Parcelable)" button to send data using Parcelable.
``` kotlin
binding.btnSendDataParcelable.setOnClickListener {
    val person = PersonWithParcelable(1,"Yash","Noida",20)
    val intent = Intent(this, GetDataActivity::class.java)
    intent.putExtra("PERSON_P",person)
    startActivity(intent)
}
```
7. The GetDataActivity will be launched, retrieving and displaying the sent data.
``` kotlin
private fun getSerializableData() {
    val person = bundle?.getSerializable("PERSON_S") as? PersonWithSerializable

    person?.let {
        binding.tvId.text = "Id: ${it.id.toString()}"
        binding.tvName.text = "Name: ${it.name.toString()}"
        binding.tvAddress.text = "Address: ${it.address.toString()}"
        binding.tvAge.text = "Age: ${it.age.toString()}"
    }
}
```
GetDataActivity code snippet for retrieving Parcelable data
``` kotlin
private fun getParcelableData(){
    val person = bundle?.getParcelable<PersonWithParcelable>("PERSON_P")

    person?.let {
        binding.tvId.text = "Id: ${it.id.toString()}"
        binding.tvName.text = "Name: ${it.name.toString()}"
        binding.tvAddress.text = "Address: ${it.address.toString()}"
        binding.tvAge.text = "Age: ${it.age.toString()}"
    }
}
```

## Data Classes
### PersonWithSerializable
``` kotlin
data class PersonWithSerializable(
    val id: Int? = 0,
    val name: String? = "",
    val address: String? = "",
    val age: Int? = 18
) : Serializable
```

### PersonWithParcelable
``` kotlin
data class PersonWithParcelable(
    val id: Int? = 0,
    val name: String? = "",
    val address: String? = "",
    val age: Int? = 18
): Parcelable {
    // Parcelable implementation code
    // ...
}
```


