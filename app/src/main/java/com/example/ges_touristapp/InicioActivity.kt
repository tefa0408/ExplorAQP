package com.example.ges_touristapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ges_touristapp.Models.LugaresModel
import com.example.ges_touristapp.databinding.ActivityInicioBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InicioActivity : AppCompatActivity() {
    //private lateinit var lugar: EditText
    //private lateinit var guardar_button: Button

    private lateinit var dbRef: DatabaseReference

    private lateinit var empRecyclerView: RecyclerView
    private  lateinit var tvLoadingData: TextView
    private lateinit var  binding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.fragment_inicio)

        //lugar = findViewById(R.id.lugar)
        //guardar_button = findViewById(R.id.guardar_button)

        dbRef = FirebaseDatabase.getInstance().getReference("Lugares")

        binding.guardarButton.setOnClickListener {
            saveLugarData()
        }

        //Extraer la ata de firebase

    }
//.
    private fun saveLugarData(){

        val lugar_name =  binding.lugar.text.toString()

        val idLugar = dbRef.push().key!!

        val lugarData = LugaresModel(idLugar, lugar_name)

        dbRef.child(idLugar).setValue(lugarData)
            .addOnCompleteListener{
                Toast.makeText(this,"Datos insertados", Toast.LENGTH_LONG).show()
            }.addOnFailureListener { err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun fetchLugaresData(){

    }
}