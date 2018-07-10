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
 * Heap Sort.
 * Average Performance = O(n*lg(n)).
 *
 * https://en.wikipedia.org/wiki/Heapsort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class HeapSort : Algorithm, Sortable {

    override val name: String = "Heap Sort"

    override val averagePerformance: String = "O(n*lg(n))"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        buildHeap(collection)
        var sizeOfHeap = collection.size - 1
        for (index in sizeOfHeap downTo 1) {
            collection.swap(firstIndex = 0, secondIndex = index)
            sizeOfHeap--
            heapify(collection, index = 0, count = sizeOfHeap)
        }
    }

    private fun <T : Comparable<T>> buildHeap(collection: SortCollection<T>) {
        for (index in ((collection.size - 1) / 2) downTo 0) {
            heapify(collection, index = index, count = collection.size - 1)
        }
    }

    private fun <T : Comparable<T>> heapify(collection: SortCollection<T>, index: Int, count: Int) {
        val leftIndex = 2 * index + 1
        val rightIndex = 2 * index + 2
        var maxIndex: Int = index

        if (leftIndex <= count && collection[leftIndex] > collection[index]) {
            maxIndex = leftIndex
        }

        if (rightIndex <= count && collection[rightIndex] > collection[maxIndex]) {
            maxIndex = rightIndex
        }

        if (maxIndex != index) {
            collection.swap(index, maxIndex)
            heapify(collection, maxIndex, count)
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.heapSort(): Unit {
    return HeapSort().perform(collection = wrapSortCollection())
}