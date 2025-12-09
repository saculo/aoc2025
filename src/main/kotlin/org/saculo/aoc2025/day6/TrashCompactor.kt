package org.saculo.aoc2025.day6

import org.saculo.aoc2025.Solution
import org.saculo.aoc2025.day5.Cafeteria.Companion.splitOnEmptyLine

class TrashCompactor : Solution<String, Long> {
    override fun firstSolution(input: List<String>): Long {
        val operations = operations(input.last())
        val operands = input.dropLast(1).map { it.trim().split("\\s+".toRegex()) }.map { it.map { a -> a.toLong() } }
        return operations.withIndex().sumOf { (index, operator) ->
            operands.map { it[index] }.reduce(operator)
        }
    }

    override fun secondSolution(input: List<String>): Long {
        val operators = operations(input.last())
        val dataRows = input.dropLast(1)
        val maxLength = dataRows.maxOfOrNull { it.length } ?: -1
        val paddedRows = dataRows.map { it.padEnd(maxLength) }

        val transposed = buildList {
            for (i in paddedRows[0].indices) {
                val transposedRow = buildList {
                    paddedRows.map { add(it[i]) }
                }
                add(transposedRow.joinToString(""))
            }
        }
        val numbers = transposed.fold(mutableListOf(mutableListOf<String>())) { acc, s ->
            if (s.isBlank())
                acc.add(mutableListOf())
            else
                acc.last().add(s)
            acc
        }
            .filter {
                it.isNotEmpty()
            }
            .map { it.map { str -> str.trim().toLong() } }
        return numbers
            .asReversed()
            .zip(operators.asReversed())
            .sumOf { (nums, op) -> nums.reduce(op) }
    }

    fun operations(operators: String): List<(Long, Long) -> Long> =
        operators.trim().toList().filter { !it.isWhitespace() }.map(::operator)

    private fun operator(operator: Char): ((Long, Long) -> Long) = when (operator) {
        '+' -> Long::plus
        '*' -> Long::times
        else -> { a, _ -> a }
    }
}