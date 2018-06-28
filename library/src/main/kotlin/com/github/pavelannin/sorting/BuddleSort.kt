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

package com.github.pavelannin.sorting

import com.github.pavelannin.sorting.core.*

/**
 * Bubble Sort.
 * Average Performance = O(n^2).
 *
 * https://en.wikipedia.org/wiki/Bubble_sort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class BuddleSort : Algorithm, Sortable {

    override val name: String = "Bubble Sort"

    override val averagePerformance: String = "O(n^2)"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        do {
            var swappedElements = false
            for (index in 0 until collection.size - 1) {
                if (collection[index] > collection[index + 1]) {
                    collection.swap(index, index + 1)
                    swappedElements = true
                }
            }
        } while (swappedElements)
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.buddleSort(): Unit {
    return BuddleSort().perform(collection = wrapSortCollection())
}