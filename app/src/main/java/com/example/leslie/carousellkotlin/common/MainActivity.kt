package com.example.leslie.carousellkotlin
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.leslie.carousellkotlin.adapter.MainPagerAdapter
import com.example.leslie.carousellkotlin.adapter.SlidingImageAdapter
import com.example.leslie.carousellkotlin.model.ImageModel
import com.example.leslie.carousellkotlin.ui.ChatActivity
import com.example.leslie.carousellkotlin.ui.StuffLikedActivity
import com.example.leslie.persistence.service.ListingRepository
import com.example.leslie.persistence.service.Listings
import com.viewpagerindicator.CirclePageIndicator
import org.jetbrains.anko.intentFor
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var listings: Listings? = null

    lateinit var repository: ListingRepository
    //region declare toolbar
    private var toolbar: Toolbar? = null
    private var searchEditText: EditText? = null
    //endregion
    //region declare tabs
    private var tabsMain: TabLayout? = null
    private var viewpagerMain: ViewPager? = null
    //endregion
    //region declare main ui
    private var floatingActionButton: Button? = null
    private var imageView: ImageView? = null
    //endregion
    //region instantiating views
    //kotlinx is producing error



    private fun assignTabLayoutViews(){
        tabsMain = findViewById<TabLayout>(R.id.tabs_main)
        viewpagerMain = findViewById<ViewPager>(R.id.viewpager_main)
    }

    private fun assignToolbar(){
        toolbar = findViewById<Toolbar>(R.id.toolbar)
    }
    private fun assignViews() {
        assignTabLayoutViews()
        assignToolbar()
        searchEditText = findViewById<EditText>(R.id.searchEditText)

        floatingActionButton = findViewById<Button>(R.id.floatingActionButton)
        imageView = findViewById<ImageView>(R.id.imageView)
    }

    //endregion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assignViews()
        setSupportActionBar(toolbar)
        setupTabs()
        setupImageSlider()

        //useCoRoutines()

    }

/*    fun useCoRoutines() {
        *//**
         * first time will send empty string for 'after' parameter.
         * Next time we will have redditNews set with the next page to
         * navigate with the 'after' param.
         *//*
        job = launch(UI) {
            try {
                val listing = ListingRepositoryProvider.provideSearchRepository()
                val retrievedNews = listing.getListings("saf")
                listings = retrievedNews
                for(l in retrievedNews.listings) {
                    Log.d("Listing", l.condition)
                }
            } catch (e: Throwable) {
                error(e.localizedMessage)
            }

        }
    }*/


    override fun onDestroy() {
        super.onDestroy()
    }
    private fun setupTabs(){
        val fragmentAdapter = MainPagerAdapter(supportFragmentManager)
        viewpagerMain?.adapter = fragmentAdapter

        tabsMain?.setupWithViewPager(viewpagerMain)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.action_like -> {
                startActivity(intentFor<StuffLikedActivity>())
                return true
            }
            R.id.action_chat -> {
                startActivity(intentFor<ChatActivity>())
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //region sliding image adapter
    private var mPager: ViewPager? = null
    private var currentPage = 0
    private var NUM_PAGES = 0
    private var imageModelArrayList: ArrayList<ImageModel>? = null

    private val myImageList = intArrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6)

    private fun setupImageSlider(){

        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()

        initialize()
    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..5) {
            val imageModel = ImageModel()
            imageModel.setImage_drawable(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    private fun initialize() {

        mPager = findViewById(R.id.pager)
        if (mPager != null)
        mPager!!.adapter = SlidingImageAdapter(this@MainActivity, imageModelArrayList!!)

        val indicator = findViewById<View>(R.id.indicator) as CirclePageIndicator

        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.radius = 5 * density

        NUM_PAGES = imageModelArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage === NUM_PAGES) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 3000, 3000)

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position

            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(pos: Int) {

            }
        })

    }


    //endregion
}


