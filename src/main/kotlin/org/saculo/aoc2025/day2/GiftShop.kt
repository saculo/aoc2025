package org.saculo.aoc2025.day2

import org.saculo.aoc2025.Solution

class GiftShop : Solution<String, Long> {
    override fun firstSolution(input: List<String>): Long {
        return create(input)
            .flatMap { filterInvalid(isInvalid, it) }
            .sum()
    }

    override fun secondSolution(input: List<String>): Long {
        return create(input)
            .flatMap { filterInvalid(isInvalidWithRepeatedPattern, it) }
            .sum()
    }

    private fun filterInvalid(func: (Long) -> Boolean, range: LongRange): List<Long> {
        return range.filter { func(it) }
    }

    private val isInvalid: (Long) -> Boolean = isInvalid@{ value ->
        val asString = value.toString()

        if (asString.length % 2 != 0) {
            return@isInvalid false
        }

        asString.take(asString.length / 2) == asString.substring(asString.length / 2)
    }

    private val isInvalidWithRepeatedPattern: (Long) -> Boolean = isInvalidWithRepeatedPattern@{ it ->
        val value = "$it"
        if (value.isEmpty()) return@isInvalidWithRepeatedPattern false
        val length = value.length

        (1..(length / 2))
            .asSequence()
            .filter { length % it == 0 }
            .map { blockSize ->
                val repeats = length / blockSize
                blockSize to repeats
            }
            .filter { (_, repeats) -> repeats >= 2 }
            .any { (blockSize, _) ->
                val block = value.take(blockSize)
                value.chunked(blockSize).all { it == block }
            }
    }

    companion object {
        fun create(input: List<String>): List<LongRange> {
            return input
                .map { it.substringBefore("-").toLong() .. it.substringAfter("-").toLong() }
        }
    }
}