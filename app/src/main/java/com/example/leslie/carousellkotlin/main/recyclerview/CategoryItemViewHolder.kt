package com.example.leslie.carousellkotlin.main.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.leslie.store.Listing
import com.example.leslie.carousellkotlin.recyclerview.ItemTouchHelperViewHolder

class CategoryItemViewHolder(view: View,
                             private val itemClick: (Listing) -> Unit,
                             private val setFavorite: (Listing) -> Unit) : RecyclerView.ViewHolder(view), ItemTouchHelperViewHolder {
    override fun onItemClear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}