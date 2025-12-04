package org.saculo.aoc2025.day2

import org.saculo.aoc2025.ResourceReader
import org.saculo.aoc2025.day1.SecretEntrance

fun main() {
    val input = ResourceReader.readAsCsv("day2.csv")
    println(GiftShop().firstSolution(input))
    println(GiftShop().secondSolution(input))
}