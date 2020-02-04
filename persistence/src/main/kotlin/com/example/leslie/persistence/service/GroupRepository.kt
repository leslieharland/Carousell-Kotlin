package com.example.leslie.persistence.service

import android.util.Log
import com.example.leslie.persistence.model.ListingResponse
import com.example.leslie.persistence.service.repos.GroupRepos
import com.example.leslie.store.Group
import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Response


class GroupRepository(val api: GroupService) : GroupRepos {


    override fun getGroups(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, title: String) {
        api.getGroups(title).enqueue(object : Callback<List<ListingResponse>> {
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

    override fun getLikedGroups(successHandler: (List<ListingResponse>?) -> Unit, failureHandler: (Throwable?) -> Unit, userId: Long) {
        api.getLikedGroups(userId).enqueue(object : Callback<List<ListingResponse>> {
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

     fun createGroup(successHandler: (ListingResponse?) -> Unit, failureHandler: (Throwable?) -> Unit, item: Group) {
        api.postGroup(item).enqueue(object : Callback<ListingResponse> {
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