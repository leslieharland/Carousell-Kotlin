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

package com.example.leslie.carousellkotlin.ui.itemslist

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.os.Handler
import com.example.leslie.MainThread
import com.example.leslie.ViewActivity
import com.example.leslie.carousellkotlin.AppStore
import com.example.leslie.carousellkotlin.ItemsViewCallback
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.controller.ItemsControllerView
import com.example.leslie.carousellkotlin.recyclerview.ItemsAdapter
import com.example.leslie.carousellkotlin.ui.edititem.EditItemActivity
import com.example.leslie.store.Listing
import org.jetbrains.anko.doFromSdk
import java.lang.ref.WeakReference

class ItemsActivity : ViewActivity<ItemsControllerView>(), ItemsViewCallback {

    private val itemsAdapter: ItemsAdapter
    init {
        itemsAdapter = ItemsAdapter(
                items = emptyList<Listing>(),
                itemClick = { item -> openEditItemScreen(item) },
                setFavorite = { item -> changeFavoriteStatus(item) },
                updateItemsPositions = { items -> reorderItems(items) },
                deleteItem = { item -> deleteItem(item) },
                share = {}
        )
    }


    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        //controllerView.fetchItems()
    }

    @SuppressLint("NewApi")
    private fun bindViews() {
        setContentView(R.layout.activity_main)
        setStatusBarColor()
        setupRecyclerView()
       // newItem.setOnClickListener { openEditItemScreen(controllerView.currentItem) }
    }

    private fun setupRecyclerView() {
      /*  val linearLayoutManager = LinearLayoutManager(this)
        itemsRecyclerView.layoutManager = linearLayoutManager
        itemsRecyclerView.adapter = itemsAdapter

        val touchHelperCallback = ItemTouchHelperCallback(itemsAdapter)
        val touchHelper = ItemTouchHelper(touchHelperCallback)
        touchHelper.attachToRecyclerView(itemsRecyclerView)*/
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setStatusBarColor() =
            doFromSdk(Build.VERSION_CODES.LOLLIPOP) {
              /*  window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)*/
            }

    private fun openEditItemScreen(item: Listing) =
            controllerView.toEditItemScreen(item)

    private fun reorderItems(items: List<Listing>) =
            controllerView.reorderItems(items)

    private fun changeFavoriteStatus(item: Listing) =
            controllerView.changeFavoriteStatus(item)

    private fun deleteItem(item: Listing) {
        val TIME_TO_WAIT = 2000
        val deleteItemRunnable = Runnable { controllerView.deleteItem(item) }
      /*  Snackbar.make(itemsCoordinatorLayout, R.string.item_deleted, TIME_TO_WAIT)
                .setAction(R.string.item_deleted_undo,
                        {
                            handler.removeCallbacksAndMessages(null)
                            with(controllerView.state.itemsListScreen) {
                                updateItems(items)
                            }
                        })
                .addCallback(object : Snackbar.Callback() {
                    override fun onShown(snackbar: Snackbar?) {
                        super.onShown(snackbar)
                        handler.postDelayed(deleteItemRunnable, TIME_TO_WAIT.toLong())
                    }
                })
                .show()*/
    }


    override fun updateItems(items: List<Listing>) =
            itemsAdapter.updateItems(items)

    override fun goToEditItem() {
        val intent = EditItemActivity.createEditItemActivityIntent(this)
        startActivity(intent)
    }
}
