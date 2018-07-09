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
import java.util.*
import kotlin.text.Typography.less

/**
 * Bogo Sort.
 * Average Performance = O((n + 1)!).
 *
 * https://en.wikipedia.org/wiki/Bogosort
 *
 * @author Pavel Annin (https://github.com/anninpavel).
 */
public class BogoSort : Algorithm, Sortable {

    override val name: String = "Bogo Sort"

    override val averagePerformance: String = "O((n + 1)!)"

    private val random by lazy { Random() }

    override fun <T : Comparable<T>> perform(collection: SortCollection<T>) {
        while (!collection.isSorted()) {
            collection.nextPermutation()
        }
    }

    private fun <T : Comparable<T>> SortCollection<T>.isSorted(): Boolean {
        for (index in 0 until size - 1) {
            if (this[index + 1] < this[index]) {
                return false
            }
        }
        return true
    }

    private fun <T : Comparable<T>> SortCollection<T>.nextPermutation() {
        for (index in 0 until size) {
            val randomIndex = index + random.nextInt(size - index)
            swap(firstIndex = randomIndex, secondIndex = index)
        }
    }
}

/** @author Pavel Annin (https://github.com/anninpavel). */
public fun <T : Comparable<T>> Array<out T>.bogoSort(): Unit {
    return BogoSort().perform(collection = wrapSortCollection())
}