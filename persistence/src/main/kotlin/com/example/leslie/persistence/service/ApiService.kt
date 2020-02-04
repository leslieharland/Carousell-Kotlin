package com.example.leslie.persistence.service

import com.example.leslie.persistence.BuildConfig


object APIService {

    val getListingService: ListingService
        get() = RetrofitClient.getClient(BuildConfig.API_ENDPOINT)!!.create(ListingService::class.java)
}