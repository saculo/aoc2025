package org.saculo.aoc2025.day1

import org.saculo.aoc2025.Solution

class SecretEntrance : Solution<String, Int> {
    companion object {
        const val SIZE: Int = 100
        const val STARTING_POINT = 50
    }

    override fun firstSolution(input: List<String>): Int {
        if (input.isEmpty()) return 0

        return input.map { row -> Rotation.create(row) }
            .runningFold(STARTING_POINT) { currentPoint, rotation -> rotation.rotate(currentPoint) }
            .count { it == 0 }
    }

    override fun secondSolution(input: List<String>): Int {
        if (input.isEmpty()) return 0

        return input.map { row -> Rotation.create(row) }
            .fold(RotationState.create(STARTING_POINT)) {
                currentPoint, rotation ->
                val (position, crossings) = rotation.rotateWithCrossings(currentPoint.position)
                RotationState(
                    position,
                    currentPoint.zeroPositions + crossings
                )
            }
            .zeroPositions
    }

    data class RotationState(
        val position: Int,
        val zeroPositions: Int,
    ) {
        companion object {
            fun create(position: Int): RotationState = RotationState(position, 0)
        }
    }
}