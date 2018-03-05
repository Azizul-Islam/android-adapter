package com.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.smart_adapter.BaseAdapter
import com.example.smart_adapter.BaseViewHolder


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 3/5/2018 at 4:13 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 3/5/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class UserAdapter : BaseAdapter<User> {
    private var context: Context

    constructor(context: Context) {
        this.context = context
    }

    override fun isEqual(leftItem: User, rightItem: User): Boolean {
        return leftItem.name.equals(rightItem.name)
    }

    override fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<User> {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserHolder(view)
    }

    private inner class UserHolder(itemView: View) : BaseViewHolder<User>(itemView), View.OnClickListener {
        private var userName: TextView
        init {
            userName = itemView.findViewById(R.id.name)
            userName.setOnClickListener(this)
        }

        override fun bind(item: User) {
            userName.text = item.name
        }

        override fun onClick(v: View?) {
            itemClickListener.onItemClick(v!!, getItem(adapterPosition))
        }
    }

}