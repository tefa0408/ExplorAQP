package com.example.ges_touristapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ges_touristapp.Adapter.AdapterFavoritos
import com.example.ges_touristapp.Models.Favoritos
import com.google.firebase.database.*


class FavoritosFragment : Fragment() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var favoritosRecyclerView: RecyclerView
    private lateinit var favoritosArrayList: ArrayList<Favoritos>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoritos, container, false)

        favoritosRecyclerView = view.findViewById(R.id.favoritosList)
        favoritosRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        favoritosRecyclerView.setHasFixedSize(true)

        favoritosArrayList = arrayListOf<Favoritos>()
        getFavoritosData()

        return view
    }

    private fun getFavoritosData() {
        dbRef = FirebaseDatabase.getInstance().getReference("Favoritos")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    favoritosArrayList.clear()

                    for (favoritosSnapshot in snapshot.children) {
                        val favoritos = favoritosSnapshot.getValue(Favoritos::class.java)
                        favoritos?.let { favoritosArrayList.add(it) }
                    }

                    favoritosRecyclerView.adapter = AdapterFavoritos(favoritosArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejo del error si es necesario
            }
        })
    }
}