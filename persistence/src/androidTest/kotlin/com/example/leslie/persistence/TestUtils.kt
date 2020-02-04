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

import com.example.leslie.store.Listing
import org.junit.Assert.assertThat
import java.util.*
import org.hamcrest.core.Is.`is` as iz

const val LOCAL_ID_VALUE = "localId"
const val TEXT_VALUE = "text"
const val USERID_VALUE = 1.toLong()
val USER_IMAGE = ""
val ITEM_IMAGE = ""
val DATE_VALUE = Date()
val DESCRIPTION = "Long text"
val PRICE = 1.23
val CONDITION = "Used"
val CATEGORYID = 1.toLong()
val AVAILABILITY = "Meetup"
val LOCATION = "Singapore"
val IS_FAVORITE = true
val NUMBER_OF_LIKES = 5.toLong()

/*
fun createPersistenceItem(index: Int): PersistenceItem =
        createStoreItem(index).toPersistenceItem()*/

fun createListing(index: Int): Listing =
        Listing(
                localId = LOCAL_ID_VALUE + index,
                text = TEXT_VALUE + index,
                userId = USERID_VALUE + index,
                userImage =  USER_IMAGE,
                itemImage = ITEM_IMAGE + index,
                date = DATE_VALUE,
                description = DESCRIPTION,
                price = PRICE,
                condition = CONDITION,
                categoryId =  CATEGORYID,
                availability = AVAILABILITY,
                location = LOCATION,
                isFavorite = IS_FAVORITE,
                numberOfLikes = NUMBER_OF_LIKES

                )

/**
This function asserts that the current item is the same the given item.
We can not use equals() from Item, since a result from Realm is not a real Item, but
a proxy that matches our Item, so equals() always fails since we are comparing Item with a ProxyItem */
fun Listing.assertIsEqualsTo(otherItem: Listing) {
    assertThat(localId, iz(otherItem.localId))
    assertThat(text, iz(otherItem.text))
}


