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

package com.example.leslie.carousellkotlin.controller

import com.example.leslie.carousellkotlin.Application.Companion.getUserId
import com.example.leslie.carousellkotlin.ControllerView
import com.example.leslie.carousellkotlin.ItemsViewCallback
import com.example.leslie.store.*
import com.example.leslie.store.CreationAction.CreateItemAction
import com.example.leslie.store.DeleteAction.DeleteItemAction
import com.example.leslie.store.DeleteAction.DeleteLikeAction
import com.example.leslie.store.NavigationAction.EditItemScreenAction
import com.example.leslie.store.UpdateAction.ReorderItemsAction
import java.lang.ref.WeakReference

class ItemsControllerView(
        val itemsViewCallback: WeakReference<ItemsViewCallback>,
        store: Store,
        mainThread: ThreadExecutor? = null)
    : ControllerView(store, mainThread) {

    fun fetchItems(title: String) =
            store.dispatch(ReadAction.FetchItemsAction(title))

    fun fetchLikedItems(userId: Long) =
            store.dispatch(ReadAction.FetchLikedItemsAction(userId))

    fun toEditItemScreen(item: Listing) =
            store.dispatch(EditItemScreenAction(item))

    fun reorderItems(items: List<Listing>) =
            store.dispatch(ReorderItemsAction(items))

    fun changeFavoriteStatus(item: Listing) ={
            if (!item.isFavorite){
                store.dispatch(CreateItemAction(Like("",getUserId(), item.localId)))
            }else{
                store.dispatch(DeleteLikeAction(item.localId))

            }
    }



    fun deleteItem(item: Listing) =
            store.dispatch(DeleteItemAction(item.localId))

    override fun handleState(state: State) {
        when (state.navigation) {
            Navigation.ITEMS_LIST -> itemsViewCallback.get()?.updateItems(state.itemsListScreen.items as List<Listing>)
            Navigation.EDIT_ITEM -> itemsViewCallback.get()?.goToEditItem()
        }
    }
}