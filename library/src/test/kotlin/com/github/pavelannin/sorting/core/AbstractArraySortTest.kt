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

import org.junit.Assert
import org.junit.Test

/** @author Pavel Annin (https://github.com/anninpavel). */
abstract class AbstractArraySortTest<out T : Sortable>(private val sort: T) {

    @Test
    fun `sort an empty array`() {
        val original = emptyArray<Int>()
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(emptyArray<Int>(), original)
    }

    @Test
    fun `sort an array with one element`() {
        val original = arrayOf(1)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1), original)
    }

    @Test
    fun `sort an array with two ordered element`() {
        val original = arrayOf(1, 2)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1, 2), original)
    }

    @Test
    fun `sort an array with two unordered elements`() {
        val original = arrayOf(2, 1)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1, 2), original)
    }

    @Test
    fun `sort an array with two identical elements`() {
        val original = arrayOf(1, 1)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1, 1), original)
    }

    @Test
    fun `sort an array with ten elements`() {
        val original = arrayOf(7, 8, 1, 3, 2, 9, 6, 10, 5, 4)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), original)
    }

    @Test
    fun `sort an array with ten items sorted in descending order`() {
        val original = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        sort.perform(collection = original.wrapSortCollection())
        Assert.assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), original)
    }
}