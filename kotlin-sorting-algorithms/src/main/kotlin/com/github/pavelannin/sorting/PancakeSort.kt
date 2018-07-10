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
 * Pancake Sort.
 * Average Performance = Unknown.
 *
 * https://en.wikipedia.org/wiki/Pancake_sorting
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class PancakeSort : Algorithm, Sortable {

    override val name: String = "Pancake Sort"

    override val averagePerformance: String = "Unknown"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        for (index in collection.size downTo 2) {
            val maxIndex = collection.indexOfMax(count = index)
            if (maxIndex != index - 1) {
                if (maxIndex > 0) {
                    collection.flip(index = maxIndex)
                }
                collection.flip(index = index - 1)
            }
        }
    }

    private fun <T : Comparable<T>> SortCollection<T>.flip(index: Int) {
        var firstIndex = index
        var secondIndex = 0
        while (secondIndex < firstIndex) {
            swap(firstIndex = secondIndex, secondIndex = firstIndex)
            secondIndex++
            firstIndex--
        }
    }

    private fun <T : Comparable<T>> SortCollection<T>.indexOfMax(count: Int): Int {
        var index = 0
        for (i in 1 until count) {
            if (this[i] > this[index]) {
                index = i
            }
        }
        return index
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.pancakeSort(): Unit {
    return PancakeSort().perform(collection = wrapSortCollection())
}