/**
 * Copyright (C) 2017 Cesar Valiente & Corey Shaw
 *
 * https://github.com/CesarValiente
 * https://github.com/coshaw
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.leslie.persistence.handler

import android.arch.lifecycle.MutableLiveData
import com.example.leslie.persistence.model.ListingResponse
import com.example.leslie.persistence.service.ListingRepository
import com.example.leslie.persistence.service.ListingRepositoryProvider
import com.example.leslie.persistence.toStoreItemsList
import com.example.leslie.store.Action
import com.example.leslie.store.ReadAction
import com.example.leslie.store.ReadAction.FetchLikedItemsAction
import com.example.leslie.store.ReadAction.ItemsLoadedAction
import io.realm.Realm

object ReadHandler : ActionHandler<ReadAction> {
    lateinit var repository: ListingRepository
    var apiError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    var listings = MutableLiveData<List<ListingResponse>>()
    override fun handle(action: ReadAction, actionDispatcher: (Action) -> Unit) {
        when (action) {
            is FetchLikedItemsAction -> fetchAllLikedItems(actionDispatcher)
            is ReadAction.FetchItemsAction -> fetchAllItems(actionDispatcher)
        }
    }

    private fun fetchAllCategories(actionDispatcher: (Action) -> Unit) {
        val db = Realm.getDefaultInstance()
         //val persistenceItems = db.queryAllListingByUser("1")
        //val storeItems = persistenceItems.toStoreItemsList()
        db.close()

        //  actionDispatcher.invoke(ItemsLoadedAction(storeItems))
    }

    private fun fetchAllItems(actionDispatcher: (Action) -> Unit) {
        repository = ListingRepositoryProvider.provideSearchRepository()
        repository.getListings(
                {
                    listings.value = it
                    isLoading.value = false
                },

                {  apiError.value = it
                    isLoading.value = false})
        actionDispatcher.invoke(ItemsLoadedAction(listings.value))

    }
    private fun fetchAllLikedItems(actionDispatcher: (Action) -> Unit) {
        repository = ListingRepositoryProvider.provideSearchRepository()
        repository.getLikedListings(
                {
                    listings.value = it
                    isLoading.value = false
                },

                {  apiError.value = it
                    isLoading.value = false},
                userId = 1)
        println("items: " + listings.value?.size)
        actionDispatcher.invoke(ItemsLoadedAction(listings.value))
    }
}