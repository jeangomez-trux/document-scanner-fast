/**
    Copyright 2021 Krobys

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
    associated documentation files (the "Software"), to deal in the Software without restriction,
    including without limitation the rights to use, copy, modify, merge, publish, distribute,
    sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or
    substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
    NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
    DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.krobys.documentscanner.common.extensions

import android.view.View

internal fun View.hide() {
    visibility = View.GONE
}

internal fun View.show() {
    visibility = View.VISIBLE
}

internal fun View.setThrottledOnClickListener(millis: Long = 300, callback: (View) -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClick = 0L

        override fun onClick(v: View) {
            val now = System.currentTimeMillis()
            if (now - lastClick > millis) {
                callback.invoke(this@setThrottledOnClickListener)
            }
            lastClick = now
        }
    })
}
