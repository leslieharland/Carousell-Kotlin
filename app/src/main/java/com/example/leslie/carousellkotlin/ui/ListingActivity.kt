package com.example.leslie.carousellkotlin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.leslie.ViewActivity
import com.example.leslie.carousellkotlin.ItemsViewCallback
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.controller.ItemsControllerView
import com.example.leslie.store.Listing

class ListingActivity : ViewActivity<ItemsControllerView>(), ItemsViewCallback {
    override fun setupControllerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateItems(items: List<Listing>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToEditItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //assignViews()
        setupControllerView()
        bindViews()

    }

    @SuppressLint("NewApi")
    private fun bindViews() {
        setContentView(R.layout.items_layout)
    }

}