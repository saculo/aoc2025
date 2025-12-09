package org.saculo.aoc2025.day5

import org.saculo.aoc2025.Solution

class Cafeteria: Solution<String, Long> {
    override fun firstSolution(input: List<String>): Long {
        val data = parseFile(input)
        return data.availableIngredients.count { id -> data.freshIngredients.any { range -> id in range } }.toLong()
    }

    override fun secondSolution(input: List<String>): Long {
        val data = parseFile(input)
        return data.freshIngredients.mergeOverlap()
            .fold(0L) { acc, longs -> acc + (longs.last - longs.first + 1) }
    }

    companion object {
        fun List<String>.splitOnEmptyLine(): List<List<String>> =
            fold(mutableListOf(mutableListOf<String>())) { acc, line ->
                if (line.isBlank()) {
                    acc.add(mutableListOf())
                } else {
                    acc.last().add(line)
                }
                acc
            }.filter { it.isNotEmpty() }

        fun List<LongRange>.mergeOverlap(): List<LongRange> {
            if(size <= 1) return this

            val sorted = this.sortedBy { it.first }

            var current = sorted.first()
            val result = mutableListOf<LongRange>()

            for (range in sorted.drop(1)) {
                if (range.first <= current.last) {
                    current = current.first..maxOf(current.last, range.last)
                } else {
                    result += current
                    current = range
                }
            }

            result += current
            return result
        }

        fun parseFile(lines: List<String>): Ingredients {
            val sections = lines.splitOnEmptyLine()

            val ranges = sections[0].map { line ->
                val (start, end) = line.split("-").map { it.toLong() }
                start..end
            }

            val values = sections[1].map { it.toLong() }
            return Ingredients(ranges, values)
        }
    }
}