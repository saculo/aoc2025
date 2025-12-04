package org.saculo.aoc2025.day3

import org.saculo.aoc2025.Solution

class Lobby : Solution<String, Long> {
    override fun firstSolution(input: List<String>): Long {
        return Bank(input).batteriesSum(2)
    }

    override fun secondSolution(input: List<String>): Long {
        return Bank(input).batteriesSum(12)
    }
}