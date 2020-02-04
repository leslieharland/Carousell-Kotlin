package com.example.leslie.carousellkotlin

import com.example.leslie.store.Listing

interface ItemsViewCallback {
    fun updateItems(items: List<Listing>)
    fun goToEditItem()
}