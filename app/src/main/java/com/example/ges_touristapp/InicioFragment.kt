package com.example.ges_touristapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ges_touristapp.Models.Favoritos
import com.example.ges_touristapp.Models.LugaresModel
import com.example.ges_touristapp.databinding.FragmentInicioBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.*

class InicioFragment : Fragment() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbRef = FirebaseDatabase.getInstance().getReference("Favoritos")

        binding.guardarButton.setOnClickListener {
            saveLugarData()
        }

        binding.btnSelectImage.setOnClickListener {
            //seleccionarImagen()
        }

        // Extraer los datos de Firebase (si es necesario)
    }

    private fun saveLugarData() {
        val lugar_nameF = binding.lugar.text.toString()
        val lugar_direccionF = binding.direccion.text.toString()
        val lugar_imagenF = binding.btnSelectImage.urls.toString()
        val idLugar = dbRef.push().key!!

        val lugarData = Favoritos(idLugar, lugar_nameF, lugar_direccionF, 0.0,0.0,lugar_imagenF)

        dbRef.child(idLugar).setValue(lugarData)
            .addOnCompleteListener {
                Toast.makeText(requireContext(), "Datos insertados", Toast.LENGTH_LONG).show()
            }.addOnFailureListener { err ->
                Toast.makeText(requireContext(), "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }


    private fun fetchLugaresData() {
        // Implementar la lógica para extraer datos de Firebase (si es necesario)
    }
}