package com.example.smart_adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 3/5/2018 at 3:02 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 3/5/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {

    private val mItemList: ArrayList<T> = arrayListOf()
    lateinit var itemClickListener : BaseListener<T>

    override fun getItemCount(): Int {
        return mItemList.size
    }

    fun getItem(pos: Int): T {
        return mItemList.get(pos)
    }

    fun addItems(itemList: List<T>) {
        mItemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun removeItem(t: T) {
        var index: Int = mItemList.indexOf(t);

        if (index < 0 || index >= mItemList.size) return

        mItemList.removeAt(index)
        notifyItemMoved(index, mItemList.size)
    }

    fun clear() {
        mItemList.clear()
        notifyDataSetChanged()
    }

    fun getItems(): List<T> {
        return mItemList
    }

    fun getCount(): Int {
        return mItemList.size
    }

    fun addItem(item: T, position: Int) {
        mItemList.add(position, item)
    }

    fun addItem(item: T) {
        mItemList.add(item)
        notifyItemChanged(mItemList.size - 1)
    }


    fun updateItem(item: T) {
        val index = mItemList.indexOf(item);
        if(index < 0 || index >= mItemList.size) return
        mItemList.set(index, item)
        notifyItemChanged(index)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>?, position: Int) {
        holder?.bind(getItem(position))
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<T> {
        return newViewHolder(parent, viewType)
    }

    abstract fun newViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<T>

    abstract fun isEqual(leftItem: T, rightItem: T): Boolean
}