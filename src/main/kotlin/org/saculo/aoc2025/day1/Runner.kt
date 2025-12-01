package org.saculo.aoc2025.day1

import org.saculo.aoc2025.ResourceReader

fun main() {
    val input = ResourceReader.readAsLines("day1.txt")
    println(SecretEntrance().firstSolution(input))
    println(SecretEntrance().secondSolution(input))
}