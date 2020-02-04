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

package com.example.leslie.store.reducer

import com.example.leslie.store.*
import com.example.leslie.store.Action

abstract class Reducer<in T : Action>{

    open fun reduce(action: T, currentState: State) =
            with(currentState) {
                currentState.copy(
                        itemsListScreen = reduceItemsListScreen(action, itemsListScreen),
                        editItemScreen = reduceEditItemScreen(action, editItemScreen),
                        navigation = reduceNavigation(action, navigation)
                )
            }

    open fun reduceItemsListScreen(action: T, itemsListScreen: ItemsListScreen) =
            itemsListScreen.copy(items = reduceItemCollection(action, itemsListScreen.items))

    open fun reduceItemCollection(action: T, currentItems: List<EntityItem>) =
            currentItems.findAndMap(
                    find = { shouldReduceItem(action, it) },
                    map = { changeItemFields(action, it) })


    open fun reduceEditItemScreen(action: T, editItemScreen: EditItemScreen) =
            editItemScreen.copy(
                    currentItem = reduceCurrentItem(action, EntityItem()))

    open fun reduceCurrentItem(action: T, currentItem: EntityItem) =
            if (shouldReduceItem(action, currentItem)) changeItemFields(action, currentItem)
            else currentItem

    open fun shouldReduceItem(action: T, currentItem: Any) = false

    open fun changeItemFields(action: T, currentItem: EntityItem) = currentItem

    open fun reduceNavigation(action: T, currentNavigation: Navigation) = currentNavigation
}