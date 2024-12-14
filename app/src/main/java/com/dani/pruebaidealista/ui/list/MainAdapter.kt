package com.dani.pruebaidealista.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dani.domain.Ads
import com.dani.pruebaidealista.databinding.MyadListItemBinding

class MainAdapter(
    var itemList: List<Ads> = emptyList(),
    private val listener: (Ads) -> Unit,
    private val listenerLong: (Ads) -> Unit,
    private val listenerFavorite: (Ads, Int) -> Unit,
    private val listenerReload:() -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: MyadListItemBinding =
            MyadListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        val view: View = binding.root
        return ViewHolder(view, binding, listenerFavorite)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
        /*
        if (position > 12 && position == itemList.size-6){
            listenerReload.invoke()
        }
        */
        holder.itemView.setOnClickListener { listener(item) }
        holder.itemView.setOnLongClickListener {
            listenerLong(item)
            false
        }
    }

    class ViewHolder(itemView: View, private val binding: MyadListItemBinding,
                     private val favorite: (Ads, Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Ads){
            binding.item = item
            Log.e("item", item.favorite.toString())

            binding.ratingBar.setOnTouchListener(View.OnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    favorite(item, layoutPosition)
                    true
                }
                return@OnTouchListener true
            })
        }
    }
}
