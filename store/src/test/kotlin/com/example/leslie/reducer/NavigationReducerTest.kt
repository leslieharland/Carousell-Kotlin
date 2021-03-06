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

import com.example.leslie.store.EditItemScreen
import com.example.leslie.store.Listing
import com.example.leslie.store.Navigation
import com.example.leslie.store.NavigationAction
import com.example.leslie.store.reducer.NavigationReducer
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as iz

class NavigationReducerTest {

    @Test
    fun should_reduceEditItemScreen_when_EditItemScreenAction() {
        val defaultItem = Listing()
        val editItemScreen = EditItemScreen(currentItem = Listing())

        val item1 = createItem(1)
        val editItemScreenAction = NavigationAction.EditItemScreenAction(item = item1)
        val reducedEditItemScreen = NavigationReducer.reduceEditItemScreen(editItemScreenAction, editItemScreen)

        //ssertThat(reducedEditItemScreen.currentItem, iz(not(defaultItem)))
        //assertThat(reducedEditItemScreen.currentItem, iz(item1))
    }

    @Test
    fun should_reduceNavigation_when_EditItemScreenAction_change_to_EDIT_ITEM() {
        val item1 = createItem(1)
        val editItemScreenAction = NavigationAction.EditItemScreenAction(item = item1)

        val reducedNavigation = NavigationReducer.reduceNavigation(editItemScreenAction, Navigation.ITEMS_LIST)
        assertThat(reducedNavigation, iz(Navigation.EDIT_ITEM))
    }

    @Test
    fun should_reduceNavigation_when_ItemsScreenAction_change_to_ITEMS_LIST() {
        val editItemScreenAction = NavigationAction.ItemsScreenAction()

        val reducedNavigation = NavigationReducer.reduceNavigation(editItemScreenAction, Navigation.EDIT_ITEM)
        assertThat(reducedNavigation, iz(Navigation.ITEMS_LIST))
    }
}