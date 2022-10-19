package com.seamless.customrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seamless.customrecyclerview.R

class ProductsAdapter(val requireContext: Context, val productsList: List<String>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsVH>() {

    inner class ProductsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvLevel = itemView.findViewById<TextView>(R.id.tvLevel)
        val tvStart=itemView.findViewById<TextView>(R.id.textViewStart)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsVH {
        return ProductsVH(
            LayoutInflater.from(requireContext).inflate(R.layout.item_circle, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return productsList.size
    }


    override fun onBindViewHolder(holder: ProductsVH, position: Int) {
        holder.tvLevel.text=productsList.get(position)
        if (position==3){
            holder.tvStart.visibility=View.VISIBLE
        }



        val bounceAnimation = AnimationUtils.loadAnimation(requireContext, R.anim.bounce_animation)
        holder.tvStart.startAnimation(bounceAnimation)
    }
}
