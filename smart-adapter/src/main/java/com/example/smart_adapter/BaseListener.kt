package com.example.smart_adapter

import android.view.View


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 3/5/2018 at 4:06 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 3/5/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

interface BaseListener<T> {
    fun onItemClick(view : View, item : T)
    fun onItemClick(view : View, position : Int)
    fun onItemLongClick(view : View, item : T)
}