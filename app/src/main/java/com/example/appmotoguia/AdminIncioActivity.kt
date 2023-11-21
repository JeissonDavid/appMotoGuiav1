package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AdminIncioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_incio)

        val iconregresaradminv1 = findViewById<androidx.appcompat.widget.AppCompatImageButton>(R.id.iconregresaradminv1)



        iconregresaradminv1.setOnClickListener{

            val intent = Intent(this, IniciarSeccionAdminActivity::class.java)
            startActivity(intent)

        }



    }




}