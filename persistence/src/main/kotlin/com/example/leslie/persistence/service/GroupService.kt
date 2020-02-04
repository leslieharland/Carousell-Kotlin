package com.example.leslie.persistence.service

import com.example.leslie.persistence.BuildConfig
import com.example.leslie.persistence.model.ListingResponse
import com.example.leslie.store.Group
import io.realm.log.RealmLog.warn
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface GroupService {
    //moshi
     /*   @GET("p/search")
        fun getListings(@Query("title") id: String): Single<List<ListingEntity>>*/
  /*  @POST("p/search")
    @FormUrlEncoded
    fun search(@Field("title") query: String): Observable<Result>*/

    @GET("p/search")
    fun getGroups(@Query("title") query: String): Call<List<ListingResponse>>

    @GET("p/user/{id}")
    fun getLikedGroups(@Query("id") userId: Long): Call<List<ListingResponse>>

    @POST("p")
    fun postGroup(@Body group: Group) : Call<ListingResponse>

    @GET("p/{id}/")
    fun getSingleGroup(@Path("id") id: Int): Call<ListingResponse>

    @PUT("p/{id}/")
    fun updateGroup(@Path("id") id: Int, @Body listing: ListingResponse): Call<ListingResponse>

    @DELETE("p/{id}/")
    fun deleteGroup(@Path("id") id: Int): Call<Void>
    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): GroupService {
            val retrofit = Retrofit.Builder()
                    //In retrofit1 rxjava is integrated but now we have to include when using rxjava
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.API_ENDPOINT)
                    .build()
            warn(BuildConfig.API_ENDPOINT)
            return retrofit.create(GroupService::class.java);
        }
    }
}