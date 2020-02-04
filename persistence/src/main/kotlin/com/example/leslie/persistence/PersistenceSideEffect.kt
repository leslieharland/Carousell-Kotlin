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

package com.example.leslie.persistence

import com.example.leslie.persistence.handler.CreationHandler
import com.example.leslie.persistence.handler.DeleteHandler
import com.example.leslie.persistence.handler.ReadHandler
import com.example.leslie.persistence.handler.UpdateHandler
import com.example.leslie.store.Action
import com.example.leslie.store.CreationAction
import com.example.leslie.store.DeleteAction
import com.example.leslie.store.ExecutorServices
import com.example.leslie.store.ReadAction
import com.example.leslie.store.SideEffect
import com.example.leslie.store.Store
import com.example.leslie.store.ThreadExecutor
import com.example.leslie.store.ThreadExecutorService
import com.example.leslie.store.UpdateAction

class PersistenceThreadService : ThreadExecutorService(ExecutorServices.persistence)

class PersistenceSideEffect(val store: Store, persistenceThread: ThreadExecutor? = null)
    : SideEffect(persistenceThread) {

    init {
        store.sideEffects.add(this)
    }

    override fun handle(action: Action) {
        println("Persistence thread: ${Thread.currentThread().name}")
        when (action) {
            is CreationAction -> CreationHandler.handle(action) { store.dispatch(it) }
            is UpdateAction -> UpdateHandler.handle(action) { store.dispatch(it) }
            is ReadAction -> ReadHandler.handle(action) { store.dispatch(it) }
            is DeleteAction -> DeleteHandler.handle(action) { store.dispatch(it) }
        }
    }
}