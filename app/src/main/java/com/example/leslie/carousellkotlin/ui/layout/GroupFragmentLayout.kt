package com.example.leslie.carousellkotlin.ui.layout

import android.view.View
import com.example.leslie.carousellkotlin.ui.GroupFragment
import com.example.leslie.carousellkotlin.ui.layout.view.ViewBinder
import org.jetbrains.anko.UI


class GroupFragmentLayout : ViewBinder<GroupFragment> {
    override fun unbind(t: GroupFragment) {

    }

    override fun bind(t: GroupFragment): View =
        t.activity.UI {
         //recycler view
        }.view
}