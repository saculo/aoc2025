package org.saculo.aoc2025

interface Solution<T, R> {
    fun firstSolution(input: List<T>): R
    fun secondSolution(input: List<T>): R
}