package uz.gita.addcontact.screen

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import uz.gita.addcontact.R
import kotlin.properties.Delegates

class ThirdActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var index by Delegates.notNull<Int>()
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    lateinit var appCompatButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        editText1 = findViewById(R.id.name_et)
        editText2 = findViewById(R.id.number_et)
        appCompatButton = findViewById(R.id.btn3)
        sharedPreferences = getSharedPreferences("MY_CONTACT", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        appCompatButton.setOnClickListener {
            if (editText1.text.toString() != "" && editText2.text.toString() != "") {
                index = sharedPreferences.getInt("index", 0)
                val name = editText1.text.toString()
                val phone = editText2.text.toString()
                editor.putString("name$index", name)
                editor.putString("phone${index++}", phone)
                editor.putInt("index", index)
                editor.apply()
                editText1.setText("")
                editText2.setText("")
            } else {
                Toast.makeText(this, "Ko'rsatilgan ma'lumotlarni kiriting!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}