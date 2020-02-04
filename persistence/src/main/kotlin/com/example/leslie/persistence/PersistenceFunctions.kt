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
 * WITHOUT WARRANTIES OR CONDITIONS OF EntityItem KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.leslie.persistence

import android.content.Context
import io.realm.*

fun setupPersistence(context: Context, dbName: String = context.getString(R.string.database_name)) {
    configureDb(context, dbName)
}

private fun configureDb(context: Context, dbName: String = context.getString(R.string.database_name)) {
    Realm.init(context)
    val realmConfig = RealmConfiguration.Builder()
            .name(dbName)
            //.deleteRealmIfMigrationNeeded()
            .build()
    Realm.setDefaultConfiguration(realmConfig)
}



fun <RealmObject : RealmModel> Realm.insertOrUpdateInTransaction(model: RealmObject): RealmObject =
        with(this) {
            beginTransaction()
            val managedEntityItem = copyToRealmOrUpdate(model)
            commitTransaction()
            return managedEntityItem
        }

fun RealmObject.update(db: Realm, changes: (RealmObject.() -> Unit)): RealmObject {
    executeTransaction(db) { this.changes() }
    return this
}

public fun executeTransaction(db: Realm, changes: () -> Unit) {
    db.executeTransaction { changes() }
}

