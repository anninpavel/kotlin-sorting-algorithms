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
 * Shell Sort.
 * Average Performance = Depends on gap sequence.
 *
 * https://en.wikipedia.org/wiki/Shellsort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class ShellSort : Algorithm, Sortable {

    override val name: String = "Shell Sort"

    override val averagePerformance: String = "Depends on gap sequence"

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        var h = 1
        while (h < collection.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            for (firstIndex in h until collection.size) {
                for (secondIndex in firstIndex downTo h step h) {
                    if (collection[secondIndex - h] < collection[secondIndex]) break
                    collection.swap(secondIndex, secondIndex - h)
                }
            }
            h /= 3
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.shellSort(): Unit {
    return ShellSort().perform(collection = wrapSortCollection())
}