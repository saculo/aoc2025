package org.saculo.aoc2025.day5

import org.saculo.aoc2025.ResourceReader
import org.saculo.aoc2025.day4.ParkingDepartment

fun main() {
    val input = ResourceReader.readAsLines("day5.txt")
    println(Cafeteria().firstSolution(input))
    println(Cafeteria().secondSolution(input))
}