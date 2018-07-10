# Sorting Algorithms for Kotlin

[ ![Download](https://api.bintray.com/packages/pavelannin/algorithms/kotlin-sorting-algorithms/images/download.svg) ](https://bintray.com/pavelannin/algorithms/kotlin-sorting-algorithms/_latestVersion)

The repository presents the implementation of sorting algorithms in the Kotlin programming language.

## The Sorting Algorithms
* [Bitonic Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/BitonicSort.kt)
* [Bogo Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/BogoSort.kt)
* [Buddle Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/BuddleSort.kt)
* [Cocktail Shaker Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/CocktailShakerSort.kt)
* [Comb Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/CombSort.kt)
* [Cycle Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/CycleSort.kt)
* [Gnome Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/GnomeSort.kt)
* [Heap Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/HeapSort.kt)
* [Insertion Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/InsertionSort.kt)
* [Merge Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/MergeSort.kt)
* [Pancake Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/PancakeSort.kt)
* [Patience Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/PatienceSort.kt)
* [Quick Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/QuickSort.kt)
* [Selection Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/SelectionSort.kt)
* [Shell Sort](kotlin-sorting-algorithms/src/main/kotlin/com/github/pavelannin/sorting/ShellSort.kt)

## Using
Gradle:
```groovy
repositories {
    maven {
        url  "https://dl.bintray.com/pavelannin/algorithms" 
    }
}

dependencies {
  implementation 'com.github.anninpavel:kotlin-sorting-algorithms:1.0.0'
}
```

or Maven:

```xml
<dependency>
  <groupId>com.github.anninpavel</groupId>
  <artifactId>kotlin-sorting-algorithms</artifactId>
  <version>1.0.0</version>
</dependency>
```

## License
MIT License

Copyright (c) 2018 Pavel Annin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.