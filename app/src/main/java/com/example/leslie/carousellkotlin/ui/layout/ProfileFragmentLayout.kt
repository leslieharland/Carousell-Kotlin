package com.example.leslie.carousellkotlin.ui.layout

import android.graphics.Color
import android.graphics.Typeface.DEFAULT_BOLD
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.ui.ProfileFragment
import com.example.leslie.carousellkotlin.ui.layout.view.ViewBinder
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.find


class ProfileFragmentLayout : ViewBinder<ProfileFragment> {
    override fun unbind(t: ProfileFragment) {
        val ivProfile: ImageView = t.find(R.id.ivProfile)
        val userName: TextView = t.find(R.id.userName)
        val location: TextView = t.find(R.id.location)
        ivProfile.setImageDrawable(null)
    }

    override fun bind(t: ProfileFragment): View =
            t.activity.UI {
                verticalLayout {
                    linearLayout {
                        imageView {
                            id = R.id.ivProfile
                            setImageResource(R.drawable.ic_avatar)
                            backgroundResource = R.drawable.circle
                        }.lparams(width = dip(100), height = dip(100))

                        verticalLayout {

                            linearLayout {

                                verticalLayout {
                                    textView {
                                        id = R.id.userName
                                        text = context.getString(R.string.default_user)
                                        textSize = 20f
                                        textColor = Color.GRAY
                                        typeface = DEFAULT_BOLD
                                        textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                                    }

                                    textView {
                                        id = R.id.location
                                        text = context.getString(R.string.location)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_TEXT_START 
                                    }
                                }

                                imageView(R.drawable.ic_settings)
                                        .lparams(width = dip(24), height = dip(24))
                                        .setOnClickListener{
                                            //startActivity<>()
                                        }
                            }.lparams(weight = 1f, width = matchParent)

                            linearLayout {

                                imageView(R.drawable.ic_positive)
                                        .lparams(width = dip(24), height = dip(24), weight = 0.33F)

                                imageView(R.drawable.ic_neutral).lparams(width = dip(24), height = dip(24), weight = 0.33F)
                                imageView(R.drawable.ic_negative).lparams(width = dip(24), height = dip(24), weight = 0.33F)
                                backgroundColor = Color.GRAY

                                setOnClickListener{

                                }
                            }.lparams(width = matchParent)
                            backgroundResource = R.drawable.rect_border
                        }.lparams(width = matchParent, weight = 1f)
                    } //end of first row

                    verticalLayout {
                        //start first row actions
                        linearLayout {
                            //start followers
                            linearLayout {
                                verticalLayout {
                                    textView {
                                        id = R.id.followerNumber
                                        text = context.getString(R.string.zero)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER

                                    }

                                    textView {
                                        text = context.getString(R.string.followers)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50), width = dip(0))
                            //end of followers

                            //start following
                            linearLayout {
                                verticalLayout {
                                    textView {
                                        id = R.id.followingNumber
                                        text = context.getString(R.string.zero)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER

                                    }

                                    textView {
                                        text = context.getString(R.string.following)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER

                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50), width = dip(0))
                            //end of following

                            //start edit profile
                            linearLayout {
                                verticalLayout {

                                    imageView {
                                        setImageResource(R.drawable.ic_edit)
                                        gravity = Gravity.CENTER
                                    }.lparams(width = dip(24), height = dip(24))


                                    textView {
                                        text = context.getString(R.string.edit_profile)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER

                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50), width = dip(0))
                            //end of edit profile

                        }.lparams(weight = 1f, width = matchParent)
                        //end first row actions

                        //start second row actions

                        linearLayout {
                            //start offers made
                            linearLayout {
                                verticalLayout {
                                    imageView {
                                        setImageResource(R.drawable.ic_basket)
                                        gravity = Gravity.CENTER
                                    }.lparams(width = dip(24), height = dip(24))

                                    textView {
                                        text = context.getString(R.string.offers_made)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                        width = wrapContent

                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50))
                            //end of offers made

                            //start get coins
                            linearLayout {
                                verticalLayout {
                                    imageView {
                                        setImageResource(R.drawable.ic_coin)
                                        gravity = Gravity.CENTER
                                    }.lparams(width = dip(24), height = dip(24))

                                    textView {
                                        text = context.getString(R.string.get_coins)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                        width = wrapContent

                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50))
                            //end of get coins

                            //start share
                            linearLayout {
                                verticalLayout {
                                    imageView {
                                        setImageResource(R.drawable.ic_share)
                                        gravity = Gravity.CENTER
                                    }.lparams(width = dip(24), height = dip(24))


                                    textView {
                                        text = context.getString(R.string.share)
                                        textSize = 14f
                                        textColor = Color.GRAY
                                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                                        width = wrapContent
                                    }
                                }.lparams(width = matchParent)
                                gravity = Gravity.CENTER
                                backgroundResource = R.drawable.rect_border
                            }.lparams(weight = 0.33f, height = dip(50))
                            //end of share
                        }.lparams(weight = 1f, width = matchParent)
                        //end second row actions
                    }
                    //start listings
                    //end listings

                    // list button


                }
            }.view


}

