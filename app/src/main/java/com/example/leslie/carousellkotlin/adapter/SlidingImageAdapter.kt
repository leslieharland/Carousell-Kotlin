package com.example.leslie.carousellkotlin.adapter

import android.content.Context
import android.os.Parcelable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView
import com.example.leslie.carousellkotlin.model.ImageModel
import com.example.leslie.carousellkotlin.R


class SlidingImageAdapter(private val context: Context, private val imageModelArrayList: ArrayList<ImageModel>) : PagerAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int) : View?{
        val imageLayout = LayoutInflater.from(context).inflate(R.layout.image_slider, view, false)!!
        val imageView = imageLayout.
        findViewById<ImageView>(R.id.image)

        imageView.setImageResource(imageModelArrayList[position].getImage_drawable())

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }


}