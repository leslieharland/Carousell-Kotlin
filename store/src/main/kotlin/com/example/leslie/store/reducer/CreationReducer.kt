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

import com.example.leslie.store.CreationAction
import com.example.leslie.store.CreationAction.CreateItemAction
import com.example.leslie.store.CreationAction.CreateGroupAction

object CreationReducer : Reducer<CreationAction>() {

    fun reduceItemsCollection(action: CreationAction, currentItems: List<Any>): List<Any> =
            when (action) {
                is CreateItemAction -> currentItems + createNewItem(action)
                is CreateGroupAction -> currentItems + createNewGroup(action)
            }

    private fun createNewItem(action: CreateItemAction): Any =
            with(action) {

            }

    private fun createNewGroup(action: CreateGroupAction): Any =
            with(action) {

            }
}