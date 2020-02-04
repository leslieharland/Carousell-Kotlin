package com.example.leslie.carousellkotlin.ui.layout

import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.view.Gravity
import android.view.View
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.ui.UpdateProfileActivity
import com.example.leslie.carousellkotlin.ui.layout.view.ViewBinder
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

class UpdateProfileLayout : ViewBinder<UpdateProfileActivity> {

    override fun unbind(t: UpdateProfileActivity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bind(t: UpdateProfileActivity): View =
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
                        //start username
                        linearLayout {
                            textView {
                                text = context.getString(R.string.username)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.userName
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end username

                        //start firstname
                        linearLayout {
                            textView {
                                text = context.getString(R.string.firstName)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.firstName
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end firstname

                        //start lastname
                        linearLayout {
                            textView {
                                text = context.getString(R.string.lastName)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.lastName
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end lastname


                        //start mycity
                        linearLayout {
                            textView {
                                text = context.getString(R.string.myCity)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.myCity
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end mycity

                        //start website
                        linearLayout {
                            textView {
                                text = context.getString(R.string.website)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.website
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end website

                        //start bio
                        linearLayout {
                            textView {
                                text = context.getString(R.string.bio)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                id = R.id.biography
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end bio

                        //start profile
                        linearLayout {
                            textView {
                                text = context.getString(R.string.profilePhoto)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            imageView(R.drawable.ic_person)
                                    .lparams(width = dip(80), height = wrapContent)
                                    .setOnClickListener {
                                        //startActivity<>()
                                    }
                        }.lparams(width = matchParent)
                        //end profile

                        //preference category Private Profile

                        textView {
                            text = context.getString(R.string.privateProfile)
                            textSize = 20f
                            textColor = Color.GRAY
                            textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                        }.lparams(width = matchParent)


                        //start email
                        linearLayout {
                            textView {
                                text = context.getString(R.string.email)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            imageView(R.drawable.ic_person)
                                    .lparams(width = dip(80), height = wrapContent)
                                    .setOnClickListener {
                                        //startActivity<>()
                                    }
                        }.lparams(width = matchParent)
                        //end email

                        //start mobile
                        linearLayout {
                            textView {
                                text = context.getString(R.string.mobile)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            textView {
                                text = context.getString(R.string.empty)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end mobile

                        //start gender
                        linearLayout {
                            textView {
                                text = context.getString(R.string.gender)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            spinner {
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }
                        }.lparams(width = matchParent)
                        //end gender


                        //start birthday
                        linearLayout {
                            textView {
                                text = context.getString(R.string.birthday)
                                textSize = 20f
                                textColor = Color.GRAY
                                textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            }

                            linearLayout {
                                backgroundColor = Color.GRAY
                                gravity = Gravity.CENTER
                                textView {
                                    text = context.getString(R.string.selectBirthday)
                                    textSize = 20f
                                    textColor = Color.GRAY
                                }
                                setOnClickListener{
                                    //start DatePicker
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent)
                        //end birthday
                    }.lparams(width = matchParent, height = matchParent) {
                        behavior = AppBarLayout.ScrollingViewBehavior()
                    }

                }
            }.view

}