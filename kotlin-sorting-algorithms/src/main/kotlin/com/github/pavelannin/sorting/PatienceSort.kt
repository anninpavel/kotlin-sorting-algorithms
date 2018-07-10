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
 * Patience Sort.
 * Average Performance = O(n*lg(n)).
 *
 * https://en.wikipedia.org/wiki/Patience_sorting
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class PatienceSort : Algorithm, Sortable {

    override val name: String = "Patience Sort"

    override val averagePerformance: String = "O(n*lg(n))"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        if (collection.size < 2) {
            return
        }

        val heaps = mutableListOf<MutableList<T>>()
        outer@ for (element in collection) {
            for (heap in heaps) {
                if (heap.last() > element) {
                    heap.add(element)
                    continue@outer
                }
            }
            heaps.add(mutableListOf(element))
        }

        for (firstIndex in 0 until collection.size) {
            var min = heaps[0].last()
            var minHeapIndex = 0

            for (secondIndex in 1 until heaps.size) {
                if (heaps[secondIndex].last() < min) {
                    min = heaps[secondIndex].last()
                    minHeapIndex = secondIndex
                }
            }
            collection[firstIndex] = min
            val minHeap = heaps[minHeapIndex]
            minHeap.removeAt(minHeap.lastIndex)
            if (minHeap.size == 0) {
                heaps.removeAt(minHeapIndex)
            }
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.patienceSort(): Unit {
    return PatienceSort().perform(collection = wrapSortCollection())
}