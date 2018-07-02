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
 * Merge Sort.
 * Average Performance = O(n*lg(n)).
 *
 * https://en.wikipedia.org/wiki/Merge_sort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class MergeSort : Algorithm, Sortable {

    override val name: String = "Merge Sort"

    override val averagePerformance: String = "O(n*lg(n))"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        makeSort(collection = collection, fromIndex = 0, toIndex = collection.size - 1)
    }

    private fun <T : Comparable<T>> makeSort(collection: SortCollection<T>, fromIndex: Int, toIndex: Int) {
        if (fromIndex < toIndex) {
            val middleIndex = (fromIndex + toIndex) / 2

            makeSort(collection, fromIndex, middleIndex)
            makeSort(collection, middleIndex + 1, toIndex)

            merge(collection, fromIndex, middleIndex, toIndex)
        }
    }

    private fun <T : Comparable<T>> merge(
        collection: SortCollection<T>,
        fromIndex: Int,
        middleIndex: Int,
        toIndex: Int
    ) {
        val leftArray = collection.copyOfRange(fromIndex, middleIndex)
        val rightArray = collection.copyOfRange(middleIndex + 1, toIndex)

        var leftIndex = 0
        var rightIndex = 0

        for (index in fromIndex..toIndex) {
            if ((leftIndex <= leftArray.count() - 1) &&
                ((rightIndex >= rightArray.count()) || (leftArray[leftIndex] <= rightArray[rightIndex]))
            ) {
                collection[index] = leftArray[leftIndex]
                leftIndex++
            } else {
                collection[index] = rightArray[rightIndex]
                rightIndex++
            }
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.mergeSort(): Unit {
    return MergeSort().perform(collection = wrapSortCollection())
}