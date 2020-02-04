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
import com.example.leslie.store.Action
import com.example.leslie.store.ReadAction
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.realm.Realm
import io.realm.RealmConfiguration
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.core.Is.`is` as iz

@RunWith(AndroidJUnit4::class)
class ReadHandlerTest {
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
    fun fetch_item_check() {
        val item1 = createListing(1)
        val fetchItemsAction = ReadAction.FetchItemsAction("text")
        val actionDispatcherSpy = mock<(Action) -> Unit> { }
        ReadHandler.handle(action = fetchItemsAction, actionDispatcher = actionDispatcherSpy)
        argumentCaptor<ReadAction.ItemsLoadedAction>().apply {
            verify(actionDispatcherSpy).invoke(capture())

            with(lastValue.items) {
                assertThat(this, iz(not(emptyList())))
/*
                assertThat(component1(), iz(item1.toStoreItem()))
                assertThat(component2(), iz(item2.toStoreItem()))
                assertThat(component3(), iz(item3.toStoreItem()))*/
            }
        }
    }
    @Test
    fun should_fetch_like_items() {
        val item1 = createListing(1)
        val item2 = createListing(2)
        val item3 = createListing(3)

        val fetchItemsAction = ReadAction.FetchLikedItemsAction(1)
        val actionDispatcherSpy = mock<(Action) -> Unit> { }

        ReadHandler.handle(action = fetchItemsAction, actionDispatcher = actionDispatcherSpy)
        argumentCaptor<ReadAction.ItemsLoadedAction>().apply {
            verify(actionDispatcherSpy).invoke(capture())

            with(lastValue.items) {
                assertThat(this, iz(not(emptyList())))
                assertThat(this?.size, iz(3))
/*
                assertThat(component1(), iz(item1.toStoreItem()))
                assertThat(component2(), iz(item2.toStoreItem()))
                assertThat(component3(), iz(item3.toStoreItem()))*/
            }
        }
    }
}