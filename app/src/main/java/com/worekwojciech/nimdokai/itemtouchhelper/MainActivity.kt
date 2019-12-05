package com.worekwojciech.nimdokai.itemtouchhelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(getList())
            ItemTouchHelper(SwipeCallback()).attachToRecyclerView(this)
        }
    }

    private fun getList(): List<String> {
        val list = mutableListOf<String>()

        for (i in 1..20) {
            list.add("Item $i")
        }
        return list
    }
}

