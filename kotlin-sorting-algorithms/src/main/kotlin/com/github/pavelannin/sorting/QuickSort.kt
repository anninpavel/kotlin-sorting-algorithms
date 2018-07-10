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
 * Quick Sort.
 * Average Performance = O(n*lg(n)).

 * https://en.wikipedia.org/wiki/Quicksort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class QuickSort : Algorithm, Sortable {

    override val name: String = "Quick Sort"

    override val averagePerformance: String = "O(n*lg(n))"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        makeSort(collection, fromIndex = 0, toIndex = collection.size - 1)
    }

    private fun <T : Comparable<T>> makeSort(collection: SortCollection<T>, fromIndex: Int, toIndex: Int) {
        if (fromIndex < toIndex) {
            val partitionIndex = partition(collection, fromIndex, toIndex)
            makeSort(collection, fromIndex, partitionIndex - 1)
            makeSort(collection, partitionIndex + 1, toIndex)
        }
    }

    private fun <T : Comparable<T>> partition(collection: SortCollection<T>, fromIndex: Int, toIndex: Int): Int {
        val lastElement = collection[toIndex]
        var index = fromIndex - 1
        for (internalIndex in fromIndex until toIndex) {
            if (collection[internalIndex] <= lastElement) {
                index++
                collection.swap(index, internalIndex)
            }
        }
        collection.swap(index + 1, toIndex)
        return index + 1
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.quickSort(): Unit {
    return QuickSort().perform(collection = wrapSortCollection())
}