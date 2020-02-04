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

import com.example.leslie.store.Action
import com.example.leslie.store.DeleteAction
import com.example.leslie.store.DeleteAction.DeleteItemAction
import com.example.leslie.store.DeleteAction.DeleteLikeAction
import io.realm.Realm



object DeleteHandler : ActionHandler<DeleteAction> {

    override fun handle(action: DeleteAction, actionDispatcher: (Action) -> Unit) {
        when (action) {
            is DeleteItemAction -> deleteItem(action)
            is DeleteLikeAction -> deleteLike(action)
        }
    }

    private fun deleteItem(action: DeleteItemAction) {
        val db = Realm.getDefaultInstance()
        //val managedItem = db.queryByLocalId(action.localId)
        //managedItem?.delete(db)
        db.close()
    }

    private fun deleteLike(action: DeleteLikeAction) {
        val db = Realm.getDefaultInstance()
        //val deleted = db.deleteItemOnOtherField(action.id)
        db.close()
    }


}
