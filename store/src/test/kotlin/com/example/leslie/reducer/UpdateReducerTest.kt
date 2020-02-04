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

package com.example.leslie.reducer

import com.example.leslie.store.Listing
import com.example.leslie.store.UpdateAction
import com.example.leslie.store.reducer.UpdateReducer
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as iz


class UpdateReducerTest {



    @Test
    fun should_not_shouldReduceItem_when_ReorderItemsAction() {
        val item1 = createItem(1)
        val item2 = createItem(2)
        val item3 = createItem(3)
        val itemsList = listOf(item1, item2, item3)

        val reorderItemsAction = UpdateAction.ReorderItemsAction(itemsList)
        val shouldReduceItem = UpdateReducer.shouldReduceItem(reorderItemsAction, item1)

        assertThat(shouldReduceItem, iz(false))
    }


    @Test
    fun should_changeItemFields_when_UpdateFavoriteAction() {
        val item = createItem(1)
        val updateFavoriteAction = UpdateAction.UpdateText(localId = item.localId, text = "hello")

        val reducedItem = UpdateReducer.changeItemFields(updateFavoriteAction, item) as Listing

        assertThat(reducedItem, iz(not(item)))
        assertThat(reducedItem.text, iz(item.text))
    }


}