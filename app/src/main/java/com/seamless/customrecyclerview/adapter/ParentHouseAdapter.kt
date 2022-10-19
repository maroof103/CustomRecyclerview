package com.seamless.customrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seamless.customrecyclerview.R
import com.seamless.customrecyclerview.adapter.ParentHouseAdapter.DataViewHolder
import com.seamless.customrecyclerview.models.parentModel

open class ParentHouseAdapter(val requireContext: Context) :
    RecyclerView.Adapter<DataViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    var parentItemList: List<parentModel> = ArrayList()



    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLevel=itemView.findViewById<TextView>(R.id.textViewLevel)
        val tvdesc=itemView.findViewById<TextView>(R.id.textViewDescription)
       val recyclerView_child=itemView.findViewById<RecyclerView>(R.id.child_recyclerview)

    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_parent, parent,
                false
            )
        )




    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.recyclerView_child.setRecycledViewPool(viewPool)
        holder.tvLevel.text="Unit  ${parentItemList.get(position).Level}"
        holder.tvdesc.text=parentItemList.get(position).description
        val childMembersAdapter = ProductsAdapter(requireContext,parentItemList.get(position).childList)
                var layoutManager = GridLayoutManager(requireContext,2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (position) {
//                    0, 1, 2 -> return 2
//                    3, 4 -> return 3
//                    5 -> return 6
//                    else -> return 2
                    0 -> return 2
                    1,2 -> return 1
                    3 -> return 2
                    4,5-> return 1
                    else ->return 2
                }
            }
        }
        holder.recyclerView_child.layoutManager = layoutManager
        holder.recyclerView_child.adapter = childMembersAdapter
    }




    fun addData(list: List<parentModel>) {
        parentItemList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int =parentItemList.size



}