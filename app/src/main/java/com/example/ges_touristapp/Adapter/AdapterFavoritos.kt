package com.example.ges_touristapp.Adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ges_touristapp.Models.Favoritos
import com.example.ges_touristapp.R

class AdapterFavoritos(private val favoritosList:ArrayList<Favoritos>) : RecyclerView.Adapter<AdapterFavoritos.FavoritosViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritosViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.favoritos_item,
        parent, false)
        return FavoritosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritosViewHolder, position: Int) {

        val currentitem = favoritosList[position]

        holder.lugar.text = currentitem.lugar_nameF
        holder.direccion.text = currentitem.lugar_direccionF
        /*val bytes = android.util.Base64.decode(currentitem.imagenUrl,
        android.util.Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        holder.imagen.setImageBitmap(bitmap)*/
    }

    override fun getItemCount(): Int {
        return favoritosList.size
    }

    class FavoritosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val lugar: TextView = itemView.findViewById(R.id.lugarFavoritos)
        val direccion:  TextView = itemView.findViewById(R.id.direccionFavoritos)
        //val imagen: ImageView = itemView.findViewById(R.id.imageView)

    }
}