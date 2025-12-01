package org.saculo.aoc2025.day1

enum class Direction(val multiplicator: Int) {
    L(-1), R(1), OTHER(0);

    companion object {
        fun create(input: Char): Direction {
            return when (input) {
                'L' -> L
                'R' -> R
                else -> OTHER
            }
        }
    }
}