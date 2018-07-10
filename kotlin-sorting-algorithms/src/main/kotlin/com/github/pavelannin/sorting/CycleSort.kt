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
 * Cycle Sort.
 * Average Performance = O(n^2).
 *
 * https://en.wikipedia.org/wiki/Cycle_sort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class CycleSort : Algorithm, Sortable {

    override val name: String = "Cycle Sort"

    override val averagePerformance: String = "O(n^2)"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        var writes = 0
        for (index in 0..collection.size - 2) {

            var element = collection[index]
            var position = index

            for (i in index + 1 until collection.size) {
                if (collection[i] < element) {
                    position++
                }
            }

            if (position == index) {
                continue
            }

            while (element == collection[position]) {
                position++
            }

            if (position != index) {
                element = collection.replace(element, position)
                writes++
            }

            while (position != index) {
                position = index

                for (i in index + 1 until collection.size) {
                    if (collection[i] < element) {
                        position++
                    }
                }

                while (element == collection[position]) {
                    position++
                }

                if (element != collection[position]) {
                    element = collection.replace(element, position)
                    writes++
                }
            }
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.cycleSort(): Unit {
    return CycleSort().perform(collection = wrapSortCollection())
}