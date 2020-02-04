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
import com.example.leslie.persistence.service.GroupRepository
import com.example.leslie.persistence.service.GroupRepositoryProvider
import com.example.leslie.persistence.service.ListingRepository
import com.example.leslie.persistence.service.ListingRepositoryProvider
import com.example.leslie.store.Action
import com.example.leslie.store.CreationAction
import com.example.leslie.store.CreationAction.CreateItemAction
import com.example.leslie.store.Group
import com.example.leslie.store.Listing

object CreationHandler : ActionHandler<CreationAction> {
    lateinit var repository: Any
    var apiError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    var listing = MutableLiveData<ListingResponse>()
    override fun handle(action: CreationAction, actionDispatcher: (Action) -> Unit) {
        when (action) {
            is CreateItemAction -> createItem(action)
        }
    }

    private fun createItem(action: CreateItemAction) =
            with(action) {
                if (T is Listing) {
                    val item = T as Listing
                    repository = ListingRepositoryProvider.provideSearchRepository()
                    (repository as ListingRepository).createListing(
                            {
                                listing.value = it
                                isLoading.value = false
                            },

                            {
                                apiError.value = it
                                isLoading.value = false
                            },
                            item)
                } else if (T is Group) {
                    val item = T as Group

                    repository = GroupRepositoryProvider.provideSearchRepository()
                    (repository as GroupRepository).createGroup(
                            {
                                listing.value = it
                                isLoading.value = false
                            },

                            {
                                apiError.value = it
                                isLoading.value = false
                            },
                            item)
                }

            }
}