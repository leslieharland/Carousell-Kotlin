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

import com.example.leslie.carousellkotlin.ControllerView
import com.example.leslie.carousellkotlin.ui.edititem.EditItemViewCallback
import com.example.leslie.store.*
import com.example.leslie.store.CreationAction.CreateItemAction
import com.example.leslie.store.NavigationAction.ItemsScreenAction
import com.example.leslie.store.UpdateAction.UpdateItemAction
import java.lang.ref.WeakReference

class EditItemControllerView(
        val editItemViewCallback: WeakReference<EditItemViewCallback>,
        store: Store,
        mainThread: ThreadExecutor? = null)
    : ControllerView(store, mainThread) {

    fun createItem(T: Any) =
            store.dispatch(CreateItemAction(T))

    fun updateItem(T: EntityItem) =
            store.dispatch(UpdateItemAction(T))

    fun backToItems() =
            store.dispatch(ItemsScreenAction())

    override fun handleState(state: State) {
        println("Thread hadleState: ${Thread.currentThread().name}")
        when (state.navigation) {
            Navigation.EDIT_ITEM -> editItemViewCallback.get()?.updateItem(state.editItemScreen.currentItem as EntityItem)
            Navigation.ITEMS_LIST -> editItemViewCallback.get()?.backToItemsList()
        }
    }
}