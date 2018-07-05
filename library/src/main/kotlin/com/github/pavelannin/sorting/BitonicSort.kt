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
 * Bitonic Sort.
 * Average Performance = O(log^2(n)).
 *
 * https://en.wikipedia.org/wiki/Bitonic_sorter
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class BitonicSort : Algorithm, Sortable {

    override val name: String = "Bitonic Sort"

    override val averagePerformance: String = "O(log^2(n))"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        makeSort(collection, fromIndex = 0, count = collection.size, isAscending = true)
    }

    private fun <T : Comparable<T>> makeSort(
        collection: SortCollection<T>,
        fromIndex: Int,
        count: Int,
        isAscending: Boolean
    ) {
        if (count > 1) {
            val middleIndex = count / 2
            makeSort(collection, fromIndex, middleIndex, !isAscending)
            makeSort(collection, fromIndex + middleIndex, count - middleIndex, isAscending)
            merge(collection, fromIndex, count, isAscending)
        }
    }

    private fun <T : Comparable<T>> merge(
        collection: SortCollection<T>,
        fromIndex: Int,
        count: Int,
        isSortingDirection: Boolean
    ) {
        if (count > 1) {
            val power = count.greatestPowerOfTwoLessThan()
            for (index in fromIndex until fromIndex + count - power) {
                if ((collection[index] > collection[index + power]) == isSortingDirection) {
                    collection.swap(firstIndex = index, secondIndex = index + power)
                }
            }
            merge(collection, fromIndex, power, isSortingDirection)
            merge(collection, fromIndex + power, count - power, isSortingDirection)
        }
    }

    private fun Int.greatestPowerOfTwoLessThan(): Int {
        var power = 1
        while (power < this) {
            power = power shl 1
        }
        return power shr 1
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.bitonicSort(): Unit {
    return BitonicSort().perform(collection = wrapSortCollection())
}