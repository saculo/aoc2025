package org.saculo.aoc2025.day6

import org.saculo.aoc2025.ResourceReader

fun main() {
    val input = ResourceReader.readAsLines("day6.txt")
    println(TrashCompactor().firstSolution(input))
    println(TrashCompactor().secondSolution(input))
}