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

package com.example.leslie.carousellkotlin

import android.support.v4.content.ContextCompat.getColor
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.leslie.store.EntityItem
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream


fun ImageView.load(drawableId: Int) =
//Here we could use an Image library to load our resource on a different way having it isolated
        setImageResource(drawableId)

fun ImageView.load(encryptedString: String)
{
    if (encryptedString.isNotEmpty()) setImageBitmap(convertToBitmap(encryptedString))
    else setImageBitmap(null)
}


fun View.changeBackgroundColor(colorId: Int) =
        setBackgroundColor(getColor(context, colorId))


fun EntityItem.getStableId(): Long = localId.hashCode().toLong()

fun EditText.isNotBlankThen(blockTextNotBlank: () -> Unit,
                            blockTextBlank: (() -> Unit)? = null) {
    if (isNotBlank()) {
        blockTextNotBlank()
    } else {
        blockTextBlank?.invoke()
    }
}

fun EditText.updateText(newText: String?) =
        newText?.let {
            if (isNotBlank() && isDifferentThan(it)) {
                setText(it)
            }
        }

fun EditText.isDifferentThan(newText: String): Boolean =
        text.toString() != newText

fun EditText.isNotBlank(): Boolean =
        text.isNotBlank()


fun convertToBase64(bitmap: Bitmap): String {
    val os = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, os)
    val byteArray = os.toByteArray()
    return Base64.encodeToString(byteArray, 0)
}

fun convertToBitmap(base64String: String): Bitmap? {
    try {
        val decodedString = Base64.decode(base64String, Base64.DEFAULT)
        val bitmapResult = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }

}