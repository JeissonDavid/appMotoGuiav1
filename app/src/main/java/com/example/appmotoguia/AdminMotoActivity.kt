package com.example.appmotoguia

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.appmotoguia.db.Db_Motos

class AdminMotoActivity : AppCompatActivity() {

    lateinit var dbh: Db_Motos
    lateinit var umarca: ArrayList<String>
    lateinit var umodelo: ArrayList<String>
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_moto)

        val recycleMoto = findViewById<RecyclerView>(R.id.recycleMoto)
        val floatingActionButton2 = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        dbh = Db_Motos(this)

        floatingActionButton2.setOnClickListener {
            val intent = Intent(this, EditarMotoActivity::class.java)
            startActivity(intent)
        }

        umarca = ArrayList()
        umodelo = ArrayList()

        myAdapter = MyAdapter(this, umarca, umodelo)
        recycleMoto.layoutManager = LinearLayoutManager(this)

        displayData()
    }

    private fun displayData() {
        val cursor: Cursor = dbh.getdata()
        if (cursor.count == -1) {
            Toast.makeText(this, "No hay modelos", Toast.LENGTH_SHORT).show()
            return
        } else {
            while (cursor.moveToNext()) {
                umarca.add(cursor.getString(0))
                umodelo.add(cursor.getString(1))
            }
        }
    }
}
