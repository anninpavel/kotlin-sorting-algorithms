/*
 * MIT License
 *
 * Copyright (c) 2018 Pavel Annin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.pavelannin.sorting.core

/** @author Pavel Annin (https://github.com/anninpavel). */
public interface SortCollection<T> {

    public val size: Int

    public operator fun get(index: Int): T

    public operator fun set(index: Int, value: T): Unit

    public operator fun iterator(): Iterator<T>
}

/** @author Pavel Annin (https://github.com/anninpavel). */
internal fun <T> SortCollection<T>.swap(firstIndex: Int, secondIndex: Int) {
    this[firstIndex] = this[secondIndex].also { this[secondIndex] = this@swap[firstIndex] }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
internal fun <T> SortCollection<T>.copyOfRange(fromIndex: Int, toIndex: Int): MutableList<T> {
    return (fromIndex..toIndex).map { this[it] }.toMutableList()
}

/** @author Pavel Annin (https://github.com/anninpavel). */
internal fun <T> SortCollection<T>.replace(element: T, index: Int): T {
    val previousElement = this[index]
    this[index] = element
    return previousElement
}