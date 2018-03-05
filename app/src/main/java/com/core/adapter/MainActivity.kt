package com.core.adapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.smart_adapter.BaseListener

class MainActivity : AppCompatActivity(), BaseListener<User> {


    lateinit var recyclerView : RecyclerView
    lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        userAdapter = UserAdapter(this)
        initRecyclerView()

        loadData()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter
        userAdapter.itemClickListener = this
    }

    private fun loadData(){
        val userList = ArrayList<User>()
        for (i in 1..20){
            val user = User("Item $i", i)
            userList.add(user)
        }
        userAdapter.addItems(userList)
    }


    override fun onItemClick(view: View, item: User) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(view: View, position: Int) {

    }

    override fun onItemLongClick(view: View, item: User) {

    }
}
