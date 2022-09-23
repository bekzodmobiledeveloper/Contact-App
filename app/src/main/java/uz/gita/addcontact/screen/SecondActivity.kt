package uz.gita.addcontact.screen

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.gita.addcontact.R
import uz.gita.addcontact.adapter.ContactAdapter
import uz.gita.addcontact.data.Contact
import kotlin.properties.Delegates

class SecondActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    private val contactAdapter by lazy { ContactAdapter() }
    private lateinit var recyclerView: RecyclerView
    private var length by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recyclerView = findViewById(R.id.rv)
        sharedPreferences = getSharedPreferences("MY_CONTACT", MODE_PRIVATE)
        length = sharedPreferences.getInt("index", 0)
        contactAdapter.submitList(loadData() as ArrayList<Contact>)
        recyclerView.adapter = contactAdapter
    }

    fun loadData(): MutableList<Contact> {
        val list: MutableList<Contact> = mutableListOf()
        for (i in 0..length) {
            val name = sharedPreferences.getString("name$i", "")
            val phone = sharedPreferences.getString("phone$i", "")
            val contact = Contact(name, phone)
            list.add(contact)
        }
        return list
    }
}