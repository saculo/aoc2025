package org.saculo.aoc2025.day4

sealed class Point(open val x: Int, open val y: Int) {
    class EmptyPoint() : Point(x = -1, y = -1)
    class ExistingPoint(override val x: Int, override val y: Int) : Point(x = x, y = y)
}
