package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.appmotoguia.db.Db_Motos

class EditarMotoActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_moto)

        val textInputLayout =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.textInputLayout)
        val textInputLayoutv2 =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.textInputLayoutv2)
        val button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)
        val ano = ""
        val manual = ""
        val creado = ""
        val imagen = ""



        button.setOnClickListener {

            val marca = textInputLayout.toString()
            val modelo = textInputLayoutv2.toString()

            if (marca.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar la marca", Toast.LENGTH_LONG).show()
            } else if (modelo.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el modelo", Toast.LENGTH_LONG).show()
            } else {
                val db_Motos = Db_Motos(this)
                val id = db_Motos.insertarMotos(
                    modelo,
                    marca,
                    ano,
                    manual,
                    creado,
                    imagen
                )
                if (id > 0) {
                    Toast.makeText(this, "Datos Creados", Toast.LENGTH_LONG).show()
                    limpiarCampos()
                    val intent = Intent(this, LoginActivity::class.java)
                   // startActivity(intent)

                } else {
                    Toast.makeText(this, "Error al crear los datos", Toast.LENGTH_LONG).show()
                }



            }
        }

    }
    private fun limpiarCampos() {
        val textInputLayout =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.textInputLayout)
        val textInputLayoutv2 =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.textInputLayoutv2)

        textInputLayout.editText?.text?.clear()
        textInputLayoutv2.editText?.text?.clear()

    }

}