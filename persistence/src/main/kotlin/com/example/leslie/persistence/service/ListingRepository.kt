package com.example.leslie.persistence.service

import android.util.Log
import com.example.leslie.persistence.model.ListingResponse
import com.example.leslie.persistence.service.repos.ListingRepos
import com.example.leslie.store.Listing
import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Response


class ListingRepository(val api: ListingService) : ListingRepos {
  /*  fun searchListing(title: String): Observable<Result> {
        return apiService.search(query = title)
    }*/

    /*//region coRoutine
    private fun process(response: ListingsResponse): Listings {
        Log.d("response", response.toString())
        val dataResponse = response.data
        val items = dataResponse.items.map {
            val item = it.data
            ListingItem(item.text, item.condition, item.price,
                    item.description)

        }
        return Listings(
                items)
    }
   suspend fun getListings(title: String = ""): Listings {
        val result = api.getListings("").awaitResult()
        return when (result) {
            is Result.Ok -> process(result.value)
            is Result.Error -> throw Throwable("HTTP error: ${result.response.message()} ${result.exception}")
            is Result.Exception -> throw result.exception
            else -> {
                throw Throwable("Something went wrong, please try again later.")
            }
        }
    }

    //endregion*/

    override fun getListings(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, title: String) {
        api.getListings(title).enqueue(object : Callback<List<ListingResponse>> {
            override fun onResponse(call: retrofit2.Call<List<ListingResponse>>?, response: Response<List<ListingResponse>>?) {
                Log.w("response", Gson().toJson(response?.body()))
                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<ListingResponse>>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }

    override fun getLikedListings(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, userId: Long) {
        api.getLikedListings(userId).enqueue(object : Callback<List<ListingResponse>> {
            override fun onResponse(call: retrofit2.Call<List<ListingResponse>>?, response: Response<List<ListingResponse>>?) {
                Log.w("response", Gson().toJson(response?.body()))
                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<ListingResponse>>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }

     fun createListing(successHandler: (ListingResponse?) -> Unit, failureHandler: (Throwable?) -> Unit, item: Listing ) {
        api.postListing(item).enqueue(object : Callback<ListingResponse> {
            override fun onResponse(call: retrofit2.Call<ListingResponse>?, response: Response<ListingResponse>?) {
                Log.w("response", Gson().toJson(response?.body()))
                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: retrofit2.Call<ListingResponse>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }
}