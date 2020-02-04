package com.example.leslie.carousellkotlin.ui.layout

import android.graphics.Color
import android.view.View
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.ui.ListingActivity
import com.example.leslie.carousellkotlin.ui.layout.view.ViewBinder
import org.jetbrains.anko.UI
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class ListingActivityLayout : ViewBinder<ListingActivity> {
    override fun unbind(t: ListingActivity) {

    }

    override fun bind(t: ListingActivity): View =
            t.UI {
                verticalLayout {
                    verticalLayout {
                        textView {
                            text = context.getString(R.string.listing_helper)
                            textSize = 35f
                            textColor = Color.GRAY
                            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                        }

                        textView {
                            text = context.getString(R.string.listing_helper_subtext)
                            textSize = 15f
                            textColor = Color.GRAY
                            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                        }
                    }


                }
            }.view


}

