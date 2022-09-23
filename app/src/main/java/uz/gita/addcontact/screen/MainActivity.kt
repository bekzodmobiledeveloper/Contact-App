package uz.gita.addcontact.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import uz.gita.addcontact.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.btn1).setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        findViewById<AppCompatButton>(R.id.btn2).setOnClickListener {
            intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}