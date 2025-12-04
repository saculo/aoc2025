package org.saculo.aoc2025.day3

import org.saculo.aoc2025.ResourceReader

fun main() {
    val input = ResourceReader.readAsLines("day3.txt")
    println(Lobby().firstSolution(input))
    println(Lobby().secondSolution(input))
}