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

import com.example.leslie.store.DeleteAction
import com.example.leslie.store.DeleteAction.DeleteItemAction
import com.example.leslie.store.DeleteAction.DeleteLikeAction
import com.example.leslie.store.EntityItem


object DeleteReducer : Reducer<DeleteAction>() {

    fun reduceItemsCollection(action: DeleteAction, currentItems: List<EntityItem>): List<EntityItem> =
            when (action) {
                is DeleteItemAction -> currentItems.filterNot { it.localId == action.localId }
                is DeleteLikeAction -> currentItems.filterNot { it.localId == action.id }
            }

    override fun reduceCurrentItem(action: DeleteAction, currentItem: EntityItem): EntityItem =
            when (action) {
                is DeleteItemAction -> if (action.localId == currentItem.localId) EntityItem() else currentItem
                is DeleteLikeAction -> if (action.id == currentItem.localId) EntityItem() else currentItem
            }

}