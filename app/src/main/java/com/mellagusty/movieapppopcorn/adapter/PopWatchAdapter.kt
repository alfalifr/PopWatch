package com.mellagusty.movieapppopcorn.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mellagusty.movieapppopcorn.R
import com.mellagusty.movieapppopcorn.data.Poster
import com.mellagusty.movieapppopcorn.databinding.ItemListContainerBinding

class PopWatchAdapter(private val listener: (Poster) -> Unit) :
    RecyclerView.Adapter<PopWatchAdapter.CardViewHolder>() {


    private val list = ArrayList<Poster>()
    fun setListData(entertaint: ArrayList<Poster>) {
        Log.d("Popwatch Adp", "size = ${entertaint.size}")
        list.clear()
        list.addAll(entertaint)
        notifyDataSetChanged()
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val popwatch = list[position]
            itemView.setOnClickListener {
                listener(list[adapterPosition])
            }
            val binding = ItemListContainerBinding.bind(itemView)
            val txtTitle = binding.tvTitleCard
            val txtDateCard = binding.tvDateCard
            val imgPoster = binding.ivCard


            Glide.with(itemView.context)
                .load(popwatch.baseUrl + popwatch.poster_path)
                .into(imgPoster)

            txtTitle.text = popwatch.original_title?: popwatch.original_name
            txtDateCard.text = popwatch.release_date?: popwatch.first_air_date

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_container, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}