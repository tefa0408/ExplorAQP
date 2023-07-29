package com.example.ges_touristapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ges_touristapp.databinding.FragmentInicioBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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

        dbRef = FirebaseDatabase.getInstance().getReference("Lugar")

        binding.guardarButton.setOnClickListener {
            saveLugarData()
        }

        // Extraer los datos de Firebase (si es necesario)
    }

    private fun saveLugarData() {
        val lugar_name = binding.lugar.text.toString()
        val idLugar = dbRef.push().key!!

        val lugarData = LugaresModel(idLugar, lugar_name)

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