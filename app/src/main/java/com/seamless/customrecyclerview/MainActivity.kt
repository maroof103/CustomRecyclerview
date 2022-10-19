package com.seamless.customrecyclerview

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seamless.customrecyclerview.adapter.ParentHouseAdapter
import com.seamless.customrecyclerview.adapter.ProductsAdapter
import com.seamless.customrecyclerview.models.parentModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tvStart=findViewById<TextView>(R.id.textViewStart)
//
//
//        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation)
//        tvStart.startAnimation(bounceAnimation)

       // tvStart.setOnClickListener {

        //}

        var parentList=ArrayList<parentModel>()
        var list=ArrayList<String>()


        list.add("1")
        list.add("2")
        list.add("3")
        list.add("4")
        list.add("5")
        list.add("6")
        list.add("7")

        var parent1=parentModel("1","Lorem ipsum dolor sit amet, consectetur adipiscing elit",list)
        var parent2=parentModel("2","Lorem ipsum dolor sit amet, consectetur adipiscing elit",list)
        parentList.add(parent1)
        parentList.add(parent2)




        val rv=findViewById<RecyclerView>(R.id.parent_recyclerview)


        rv.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)

        var adapter = ParentHouseAdapter(this)
        rv.adapter=adapter
        adapter.addData(parentList)
        adapter.notifyDataSetChanged()


    }
}