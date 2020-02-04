package com.example.leslie.carousellkotlin.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.EditText
import com.example.leslie.MainThread
import com.example.leslie.ViewActivity
import com.example.leslie.carousellkotlin.AppStore
import com.example.leslie.carousellkotlin.ItemsViewCallback
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.adapter.ChatPagerAdapter
import com.example.leslie.carousellkotlin.ui.edititem.EditItemActivity
import com.example.leslie.carousellkotlin.controller.ItemsControllerView
import com.example.leslie.carousellkotlin.recyclerview.ItemsAdapter
import com.example.leslie.carousellkotlin.ui.StuffLikedActivity.Companion.createShareIntent
import com.example.leslie.store.Listing
import java.lang.ref.WeakReference


class ChatActivity : ViewActivity<ItemsControllerView>(), ItemsViewCallback {

    //region declare toolbar
    private var toolbar: Toolbar? = null
    private var searchEditText: EditText? = null
    //endregion
    //region declare tabs
    private var tabsMain: TabLayout? = null
    private var viewpagerMain: ViewPager? = null
    //endregion

    //region declare recycler view
    private var itemsRecyclerView: RecyclerView? = null
    //endregion
    //region instantiating views
    private fun assignTabLayoutViews(){
        tabsMain = findViewById<TabLayout>(R.id.tabs_main)
        viewpagerMain = findViewById<ViewPager>(R.id.viewpager_main)
    }

    private fun assignToolbar(){
        toolbar = findViewById(R.id.toolbar)
    }

    private fun assignRecyclerView(){
        itemsRecyclerView = findViewById(R.id.itemsRecyclerView)
    }
    private fun assignViews(){
        assignTabLayoutViews()
        assignToolbar()
        assignRecyclerView()
    }
    //endregion


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

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assignViews()
        setupControllerView()
        bindViews()
        setupTabs()

    }

    private fun setupTabs(){
        val fragmentAdapter = ChatPagerAdapter(supportFragmentManager)
        viewpagerMain?.adapter = fragmentAdapter

        tabsMain?.setupWithViewPager(viewpagerMain)
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
        setContentView(R.layout.items_layout)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
          val linearLayoutManager = LinearLayoutManager(this)
          itemsRecyclerView?.layoutManager = linearLayoutManager
          itemsRecyclerView?.adapter = itemsAdapter
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


