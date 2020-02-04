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

import io.realm.RealmModel
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*


internal const val LOCAL_ID = "localId"
internal const val DATE = "date"



@RealmClass
open class Chat() : RealmModel {
    constructor(localId: String, text: String, userId: Long = 0, date: Date) : this() {
        this.localId = localId
        this.text = text
        this.userId = userId
        this.date = date
    }

    @PrimaryKey open var localId: String = ""
    open var text: String = ""
    open var userId: Long = 0
    open var date: Date = Date()

}


@RealmClass
open class Search() : RealmModel {
    constructor(localId: String, searchText: String, userId: Long, isSaved: Boolean = false) : this() {
        this.localId = localId
        this.searchText = searchText
        this.isSaved = isSaved
    }

    @PrimaryKey open var localId: String = ""
    open var searchText: String = ""
    open var userId: Long = 0
    open var isSaved: Boolean = false

}