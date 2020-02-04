package com.example.leslie.carousellkotlin.ui.layout.view

import android.view.View


interface ViewBinder<in T> {
    fun bind(t: T) : View
    fun unbind(t: T)
}