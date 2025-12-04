package org.saculo.aoc2025.day4

import org.saculo.aoc2025.ResourceReader
import org.saculo.aoc2025.day3.Lobby

fun main() {
    val input = ResourceReader.readAsLines("day4.txt")
    println(ParkingDepartment().firstSolution(input))
    println(ParkingDepartment().secondSolution(input))
}