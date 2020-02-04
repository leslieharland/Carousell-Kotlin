package com.example.leslie.carousellkotlin.model

open class ImageModel {
    private var image_drawable: Int = 0

    fun getImage_drawable(): Int {
        return image_drawable
    }

    fun setImage_drawable(image_drawable: Int) {
        this.image_drawable = image_drawable
    }
}