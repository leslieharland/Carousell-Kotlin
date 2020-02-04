package com.example.leslie.carousellkotlin.ui.layout

import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.view.View
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.ui.SettingsActivity
import com.example.leslie.carousellkotlin.ui.layout.view.ViewBinder
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

class SettingsLayout: ViewBinder<SettingsActivity> {

    override fun unbind(t: SettingsActivity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bind(t: SettingsActivity): View =
            t.UI {
                coordinatorLayout {
                    fitsSystemWindows = true

                    appBarLayout {
                        fitsSystemWindows = true
/*
                        collapsingToolbarLayout(R.style.AppTheme_PopupOverlay) {
                            fitsSystemWindows = true
                            setContentScrimColor(color(R.color.colorPrimary))
                            id = R.id.toolbar_layout

                            toolbar(R.style.AppTheme_PopupOverlay) {
                                id = R.id.toolbar
                                t.setSupportActionBar(this)
                                t.supportActionBar?.setDisplayHomeAsUpEnabled(true)
                            }.collapseLayoutParams(width = matchParent, height = actionBarSize()) {
                                collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
                            }

                        }.lparams(width = matchParent, height = matchParent) {
                            scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                        }*/

                    }.lparams(width = matchParent, height = dip(200))

                    verticalLayout {
                        //Preference Category Account Settings
                        textView {
                            text = context.getString(R.string.accountSettings)
                            textSize = 20f
                            textColor = Color.GRAY
                            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            setAllCaps(true)
                        }
                        linearLayout{
                            textView {
                                text = context.getString(R.string.editProfile)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                        }.lparams(width = matchParent)

                        linearLayout{
                            textView {
                                text = context.getString(R.string.changePassword)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                        }.lparams(width = matchParent)

                        linearLayout{
                            textView {
                                text = context.getString(R.string.notifications)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                        }.lparams(width = matchParent)

                        linearLayout{
                            textView {
                                text = context.getString(R.string.dataprivacy)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                        }.lparams(width = matchParent)


                        //Preference Category App Settings
                        textView {
                            text = context.getString(R.string.accountSettings)
                            textSize = 20f
                            textColor = Color.GRAY
                            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            setAllCaps(true)
                        }
                    }.lparams(width = matchParent, height = matchParent) {
                        behavior = AppBarLayout.ScrollingViewBehavior()
                    }

                }
            }.view

}