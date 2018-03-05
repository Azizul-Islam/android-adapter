package com.example.smart_adapter

import android.support.v7.widget.RecyclerView
import android.view.View


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 3/5/2018 at 3:04 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 3/5/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BaseViewHolder<T>(itemView : View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item : T)
    fun bind(item : T, position : Int){}
}