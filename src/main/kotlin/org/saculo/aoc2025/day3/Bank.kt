package org.saculo.aoc2025.day3

data class Bank(val joltagesBlock: List<String>) {
    fun batteriesSum(batteries: Int): Long {
        return parse()
            .map { biggestJoltagesInLine(it, batteries).toMutableList() }
            .sumOf { it.joinToString("").toLong() }
    }

    fun biggestJoltagesInLine(joltages: List<Long>, batteries: Int): List<Long> =
        (0 until batteries).fold(Pair(emptyList<Long>(), 0)) { (result, startIndex), _ ->
            val remainingDigitsNeeded = batteries - result.size - 1
            val searchEndIndex = joltages.size - remainingDigitsNeeded

            val maxIndex = (startIndex until searchEndIndex)
                .maxBy { joltages[it] }

            Pair(result + joltages[maxIndex], maxIndex + 1)
        }.first

    private fun parse(): List<List<Long>> = joltagesBlock
        .map { it.map { a -> a.digitToInt().toLong() } }
}
