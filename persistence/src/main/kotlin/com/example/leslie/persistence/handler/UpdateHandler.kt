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

import com.example.leslie.persistence.update
import com.example.leslie.store.Action
import com.example.leslie.store.UpdateAction
import com.example.leslie.store.UpdateAction.ReorderItemsAction
import com.example.leslie.store.UpdateAction.UpdateItemAction
import io.realm.Realm

object UpdateHandler : ActionHandler<UpdateAction> {

    override fun handle(action: UpdateAction, actionDispatcher: (Action) -> Unit) {
        when (action) {
            is ReorderItemsAction -> reorderItems(action)
            is UpdateItemAction -> updateItem(action)
        }
    }

    private fun reorderItems(action: ReorderItemsAction) {
        if (action.items.isEmpty()) return

        val db = Realm.getDefaultInstance()
        action.items.forEach { item ->
            /*       val managedItem = db.queryByLocalId(item.localId)
            managedItem?.update(db) { position = item.position }*/
        }
        db.close()
    }

    private fun updateItem(action: UpdateItemAction) {
        val db = Realm.getDefaultInstance()
        //val managedItem = db.queryByLocalId(action.T.localId)
        /*managedItem?.update(db) {

        }*/
        db.close()
    }
}