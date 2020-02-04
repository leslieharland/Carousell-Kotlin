package com.example.leslie.persistence.service.repos

import com.example.leslie.persistence.model.ListingResponse


interface GroupRepos {

    fun getGroups(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, title: String = "")
    fun getLikedGroups(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, userId: Long = 0)

}