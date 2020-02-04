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

package com.example.leslie.carousellkotlin.ui.edititem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.leslie.MainThread
import com.example.leslie.ViewActivity
import com.example.leslie.carousellkotlin.AppStore
import com.example.leslie.carousellkotlin.R
import com.example.leslie.carousellkotlin.controller.EditItemControllerView
import com.example.leslie.store.EntityItem
import java.lang.ref.WeakReference

class EditItemActivity : ViewActivity<EditItemControllerView>(), EditItemViewCallback {

    companion object {
        fun createEditItemActivityIntent(context: Context): Intent =
                Intent(context, EditItemActivity::class.java)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupControllerView()
        bindViews()
    }

    override fun setupControllerView() {
        val controllerView = EditItemControllerView(
                editItemViewCallback = WeakReference(this),
                store = AppStore,
                mainThread = MainThread(WeakReference(this)))
        registerControllerViewForLifecycle(controllerView)
    }

    override fun onResume() {
        super.onResume()
        controllerView.let {
            //setDetails(it.currentItem)
        }
    }

    private fun bindViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /*
        private fun setDetails(item: Item) {
            item.text?.let {
                editText.setText(it)
                editText.setSelection(editText.length())
            }
            when (item.color) {
                Color.RED -> itemRedColor.isChecked = true
                Color.BLUE -> itemBlueColor.isChecked = true
                Color.GREEN -> itemGreenColor.isChecked = true
                Color.WHITE -> itemWhiteColor.isChecked = true
                Color.YELLOW -> itemYellowColor.isChecked = true
            }
        }

        private fun createOrUpdateItem(item: Item) =
                editText.isNotBlankThen(blockTextNotBlank = {
                    if (item.isEmpty()) createItem(item.localId)
                    else updateItem(item.localId)
                })

        private fun createItem(localId: String) =
                controllerView.let {
                    with(it.currentItem) {
                        it.createItem(
                                localId = localId,
                                text = editText.text.toString(),
                                favorite = favorite,
                                color = color,
                                position = position)
                    }
                }


        override fun onBackPressed() {
            backAndUpdate()
        }

        private fun backAndUpdate() {
            createOrUpdateItem(controllerView.currentItem)
            controllerView.backToItems()
        }

        override fun onOptionsItemSelected(item: MenuItem?): Boolean {
            if (item?.itemId == android.R.id.home) {
                backAndUpdate()
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        override fun updateItem(item: Item) {
            editText.updateText(item.text)
            itemLayout.changeBackgroundColor(item.color)
        }


    }*/
    private fun createItem(localId: String) =
            controllerView.let {
                with(it.currentItem) {
                    //it.createItem()
                }
            }


    override fun updateItem(T: EntityItem) =
            controllerView.let {
                it.updateItem(T)
            }

    override fun backToItemsList() =
            finish()
}

interface EditItemViewCallback {
    fun updateItem(item: EntityItem)
    fun backToItemsList()
}
