package com.example.leslie.carousellkotlin.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.leslie.carousellkotlin.AppStore
import com.example.leslie.MainThread
import com.example.leslie.ViewActivity
import com.example.leslie.store.Listing
import com.example.leslie.carousellkotlin.ItemsViewCallback
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.ui.edititem.EditItemActivity
import com.example.leslie.carousellkotlin.controller.ItemsControllerView
import com.example.leslie.carousellkotlin.recyclerview.ItemsAdapter
import io.realm.log.RealmLog.warn
import kotlinx.android.synthetic.main.items_layout.*
import java.lang.ref.WeakReference

class StuffLikedActivity : ViewActivity<ItemsControllerView>(), ItemsViewCallback {

    private val itemsAdapter: ItemsAdapter
    init {
        itemsAdapter = ItemsAdapter(
                items = emptyList<Listing>(),
                itemClick = { item -> openEditItemScreen(item) },
                updateItemsPositions = {},
                setFavorite = { item -> changeFavoriteStatus(item) },
                share = { item -> createShareIntent(this, item) },
                deleteItem = { item -> deleteItem(item) }
        )
    }

    companion object {
        fun getSendImageIntent(filePath: String, subject: String, body: String): Intent {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/jpg"
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://$filePath"))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, body)
            return Intent.createChooser(intent, "Share File")

        }

        fun createShareIntent(context: Context, item: Listing): Intent {

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            val message = item.text + " for " + "$" + item.price + " https://carousell.com/p/" + item.localId + " on #carousell"
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            return Intent.createChooser(shareIntent, "Share this via")
        }

    }

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.items_layout)
        setupControllerView()
        bindViews()
    }


    override fun setupControllerView() {
        val controllerView = ItemsControllerView(
                itemsViewCallback = WeakReference(this),
                store = AppStore,
                mainThread = MainThread(WeakReference(this)))
        registerControllerViewForLifecycle(controllerView)
    }


    override fun onResume() {
        super.onResume()
        controllerView.fetchLikedItems(1)
        warn("Items Fetched")
    }

    @SuppressLint("NewApi")
    private fun bindViews() {
        setContentView(R.layout.items_layout)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
          val linearLayoutManager = LinearLayoutManager(this)
          itemsRecyclerView.layoutManager = linearLayoutManager
          itemsRecyclerView.adapter = itemsAdapter
    }

    private fun openEditItemScreen(item: Listing) =
            controllerView.toEditItemScreen(item)


    private fun changeFavoriteStatus(item: Listing) =
            controllerView.changeFavoriteStatus(item)

    private fun deleteItem(item: Listing) {
        val TIME_TO_WAIT = 2000
        val deleteItemRunnable = Runnable { controllerView.deleteItem(item) }
    }

    override fun updateItems(items: List<Listing>) =
            itemsAdapter.updateItems(items)

    override fun goToEditItem() {
        val intent = EditItemActivity.createEditItemActivityIntent(this)
        startActivity(intent)
    }
}


