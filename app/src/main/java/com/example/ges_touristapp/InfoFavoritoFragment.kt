package com.example.ges_touristapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ges_touristapp.databinding.FragmentInfoFavoritoBinding
import com.google.firebase.database.DatabaseReference

class InfoFavoritoFragment : Fragment() {

    private lateinit var binding: FragmentInfoFavoritoBinding
    private lateinit var bdRef: DatabaseReference
    var sImagen: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InfoFavoritoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFavoritoFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}