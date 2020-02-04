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

package com.example.leslie.store

import java.util.*

const val LOCAL_ID = "localId"

interface PositionsFactory {
    fun newPosition() = System.nanoTime()
}

fun generateLocalId(): String = LOCAL_ID + "_" + UUID.randomUUID().toString().replace("-".toRegex(), "")

enum class Gender {
    M, F, Unspecified
}

open class EntityItem(
        open val localId: String = generateLocalId()
)

data class Category(

        val text: String = "",
        val image: String = "",
        val isParentCategory: Boolean = false,
        val parentId: Long = 0) : EntityItem()

data class Group(
        val localId: String = "",
        val text: String? = null,
        val image: String = "",
        val lastActivity: Date = Date()
)


data class Activity(
        val localId: String = "",
        val userId: Long = 0,
        val date: Date = Date())

data class Profile(


        val localId: String = "",
        val text: String? = null,
        val followerId: Long = 0,
        val followingId: Long = 0,
        val username: String = "",
        val firstName: String = "",
        val lastName: String = "",
        val city: String = "",
        val website: String = "",
        val bio: String = "",
        val photo: String = "",
        val email: String = "",
        val mobile: String = "",
        val birthday: Date = Date()
)

data class Listing(
        override val localId: String = "",
        val text: String = "",
        val userId: Long = 0,
        val userImage: String = "",
        val itemImage: String = "",
        val date: Date = Date(),
        val description: String? = "",
        val price: Double = 0.0,
        val condition: String = "",
        val categoryId: Long = 0,
        val availability: String = "",
        val location: String = "",
        val isFavorite: Boolean = false,
        val numberOfLikes: Long = 0
) : EntityItem() {

    fun isEmpty(): Boolean = description == null

    fun isNotEmpty(): Boolean = !isEmpty()

}


data class Like(
        val localId: String = "",
        val userId: String = "",
        val itemId: String = ""
)

data class Chat(
        val localId: String = "",
        val text: String = "",
        val userId: Long = 0,
        val date: Date = Date()
)

data class User(
        val localId: String = "",
        val password: String = "",
        val salt: String = ""
)


data class Search(
        val localId: String = "",
        val searchText: String = "",
        val userId: Long = 0,
        val isSaved: Boolean = false
)