/**
 * Copyright (C) 2017 Cesar Valiente & Corey Shaw
 *
 * https://github.com/CesarValiente
 * https://github.com/coshaw
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.leslie.carousellkotlin.recyclerview

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.getStableId
import com.example.leslie.itemslist.recyclerview.ItemsDiffCallback
import com.example.leslie.store.Listing

internal interface ItemTouchHelperAdapter {
    fun onItemDeleted(position: Int)
}

class ItemsAdapter(
        private var items: List<Listing>,
        private val itemClick: (Listing) -> Unit,
        private val setFavorite: (Listing) -> Unit,
        private val share: (Listing) -> Unit,
        private val updateItemsPositions: (List<Listing>) -> Unit,
        private val deleteItem: (Listing) -> Unit)
    : RecyclerView.Adapter<ItemViewHolder>(), ItemTouchHelperAdapter {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.li_item, parent, false)
        return ItemViewHolder(view, itemClick, setFavorite, share)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        itemViewHolder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): Listing = items[position]

    override fun getItemId(position: Int): Long =
            getItem(position).getStableId()

    fun removeAt(position: Int) {
        items = items.minus(items[position])
        notifyItemRemoved(position)
    }

    fun updateItems(newItems: List<Listing>) {
        val oldItems = items
        items = newItems
        applyDiff(oldItems, items)
    }

    private fun applyDiff(oldItems: List<Listing>, newItems: List<Listing>) {
        val diffResult = DiffUtil.calculateDiff(ItemsDiffCallback(oldItems, newItems))
        diffResult.dispatchUpdatesTo(this)
    }

    private fun updateItemsPositions() {
        updateItemsPositions(items)
    }

    override fun onItemDeleted(position: Int) {
        deleteItem(items[position])
        removeAt(position)
    }

}