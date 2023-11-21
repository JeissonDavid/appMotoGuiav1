package com.example.appmotoguia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.appmotoguia.db.Db_Usuarios

class IniciarSeccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_seccion)

        val iconregresar = findViewById<ImageButton>(R.id.iconregresar)
        val edituser = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.editpass)
        val editpass = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.edituser)

        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)

        buttonIngresar.setOnClickListener {

            val usuario = edituser.text.toString()
            val pass = editpass.text.toString()

            if (usuario.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar el usuario", Toast.LENGTH_LONG).show()
            } else if (pass.isEmpty()) {
                Toast.makeText(this, "Se debe diligenciar la contraseña", Toast.LENGTH_LONG).show()
            } else {
                // Validar el id_rol antes de verificar el usuario y la contraseña
                val dbUsuarios = Db_Usuarios(this)
                val id_rol = dbUsuarios.obtenerIdRol(usuario)

                if (id_rol == 2) {
                    val isValidUser = dbUsuarios.verificarUsuarioContraseña(usuario, pass)

                    if (isValidUser) {
                        val intent = Intent(this, AdminIncioActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Usuario / Contraseña incorrecto", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "El usuario no tiene el rol adecuado", Toast.LENGTH_LONG).show()
                }
            }
        }



        iconregresar.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

    }
}