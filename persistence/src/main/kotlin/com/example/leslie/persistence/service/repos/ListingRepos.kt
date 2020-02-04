package com.example.leslie.persistence.service.repos

import com.example.leslie.persistence.model.ListingResponse


interface ListingRepos {

    fun getListings(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, title: String = "")
    fun getLikedListings(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, userId: Long = 0)

}