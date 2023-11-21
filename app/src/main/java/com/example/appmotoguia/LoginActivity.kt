package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.appmotoguia.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<AppCompatButton>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {

            val intent = Intent(this, IniciarSeccionActivity::class.java)
            startActivity(intent)

        }
        val buttonRegister = findViewById<AppCompatButton>(R.id.buttonRegister)

        buttonRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }


    }
}