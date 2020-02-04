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

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.leslie.persistence.createListing
import io.realm.Realm
import io.realm.RealmConfiguration
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.core.Is.`is` as iz

@RunWith(AndroidJUnit4::class)
class UpdateHandlerTest {
    lateinit var config: RealmConfiguration
    lateinit var db: Realm

    @Before
    fun setup() {
        Realm.init(InstrumentationRegistry.getTargetContext())
        config = RealmConfiguration.Builder()
                .name("test.realm")
                .inMemory()
                .build()
        Realm.setDefaultConfiguration(config)
        db = Realm.getInstance(config)
    }

    @After
    fun clean() {
        db.close()
        Realm.deleteRealm(config)
    }

    @Test
    fun should_update_Item() {
        val item1 = createListing(1)

/*        item1.insertOrUpdate(db)

        val NEW_TEXT = "new text"
        val NEW_COLOR = StoreColor.YELLOW
        val updateItemAction = UpdateAction.UpdateItemAction(
                localId = item1.localId, text = NEW_TEXT, color = NEW_COLOR)

        UpdateHandler.handle(updateItemAction, {})

        val managedItem = db.queryByLocalId(item1.localId)
        assertThat(managedItem, iz(not(nullValue())))
        assertThat(managedItem!!.text, iz(NEW_TEXT))
        assertThat(managedItem.getColorAsEnum(), iz(NEW_COLOR.toPersistenceColor()))*/
    }

    @Test
    fun should_update_favorite_field() {
     /*   val item1 = createListing(1)

        item1.insertOrUpdate(db)

        val NEW_FAVORITE = true
        val updateFavoriteAction = UpdateAction.UpdateFavoriteAction(
                localId = item1.localId, favorite = NEW_FAVORITE)

        UpdateHandler.handle(updateFavoriteAction, {})

        val managedItem = db.queryByLocalId(item1.localId)
        assertThat(managedItem, iz(not(nullValue())))
        assertThat(managedItem!!.favorite, iz(NEW_FAVORITE))*/
    }

}