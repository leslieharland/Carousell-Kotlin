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

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.leslie.store.Listing
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.load
import org.jetbrains.anko.find

internal interface ItemTouchHelperViewHolder {
    fun onItemSelected()
    fun onItemClear()
}

class ItemViewHolder(view: View,
                     private val itemClick: (Listing) -> Unit,
                     private val setFavorite: (Listing) -> Unit,
                     private val share: (Listing) -> Unit)
    : RecyclerView.ViewHolder(view), ItemTouchHelperViewHolder {

    private lateinit var currentItem: Listing
    val cardView: CardView = itemView.find(R.id.card_view)
    val ivLike: ImageView = itemView.find(R.id.ivLike)
    val count: TextView = itemView.find(R.id.count)
    val overflow: ImageView = itemView.find(R.id.overflow)
    val title: TextView = itemView.find(R.id.title)
    val priceText: TextView = itemView.find(R.id.price)
    val thumbnail: ImageView = itemView.find(R.id.thumbnail)
    val description: TextView = itemView.find(R.id.description)
    val userThumbnail: ImageView = itemView.find(R.id.user_thumbnail)
    val username: TextView = itemView.find(R.id.user_name)
    val datePosted: TextView = itemView.find(R.id.date_posted)

    fun bindItem(item: Listing) =
            with(item) {
                currentItem = this
                bindViewContent(this)
                bindClickHandlers(this)
            }

    private fun bindViewContent(item: Listing) =
            with(item) {
                count.text = numberOfLikes.toString()
                title.text = text
                datePosted.text = date.toString()
                priceText.text = price.toString()

                ivLike.load(
                        if (isFavorite) R.drawable.ic_favorite_selected_xml
                        else R.drawable.ic_favorite_xml )
                userThumbnail.load(userImage)
                thumbnail.load(itemImage)
            }

    private fun bindClickHandlers(item: Listing) {
        cardView.setOnClickListener { itemClick(item) }
        ivLike.setOnClickListener { setFavorite(item) }
        overflow.setOnClickListener { share(item)}
    }

    override fun onItemSelected() {
       // itemContentLayout.changeBackgroundColor(R.color.primary)
    }

    override fun onItemClear() {

    }

}