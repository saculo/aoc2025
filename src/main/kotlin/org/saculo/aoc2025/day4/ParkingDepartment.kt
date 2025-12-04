package org.saculo.aoc2025.day4

import org.saculo.aoc2025.Solution

class ParkingDepartment : Solution<String, Int> {
    override fun firstSolution(input: List<String>): Int {
        val data = grid(input)
        return data.liftedPapers()
            .count()
    }

    override fun secondSolution(input: List<String>): Int {
        val data = grid(input)
        var totalRemovals = 0
        while (true) {
            val removed = data.removePapers()
            if (removed == 0) break
            totalRemovals += removed
        }

        return totalRemovals
    }

    typealias PaperGrid = MutableList<MutableList<Char>>

    private fun PaperGrid.liftedPapers(): List<Point> = this.mapIndexed { y, row ->
        row
            .mapIndexed { x, cell ->
                if (cell == '@' && this.canBeLifted(x to y)) Point.ExistingPoint(x, y) else Point.EmptyPoint()
            }
            .filter { it is Point.ExistingPoint }
    }
        .flatMap { it }

    private fun PaperGrid.removePapers(): Int =
        liftedPapers()
            .map { this[it.y][it.x] = '.'}
            .count()

    fun PaperGrid.canBeLifted(point: Pair<Int, Int>) =
        listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
            .map { (x, y) -> (x + point.first) to (y + point.second) }
            .filter { (x, y) -> y in this.indices && x in this[y].indices }
            .map { (x, y) -> this[y][x] }.count { it == '@' } < 4


    companion object {
        fun grid(input: List<String>): PaperGrid =
            input
                .map { it.toMutableList() }
                .toMutableList()
    }
}