package org.saculo.aoc2025.day1

import java.lang.Math.floorMod
import kotlin.math.abs

class Rotation(val direction: Direction, val ticks: Int) {
    fun rotate(current: Int) = (current + (movement())) % SecretEntrance.SIZE

    fun rotateWithCrossings(current: Int): Pair<Int, Int> {
        val movement = movement()
        val destination = current + movement
        val newPosition = floorMod(destination, SecretEntrance.SIZE)
        val zeroCrossings = getZeroCrossings(destination, current)

        return newPosition to zeroCrossings
    }

    private fun getZeroCrossings(destination: Int, current: Int): Int =
        abs(destination / 100) + if (destination <= 0 && current != 0) 1 else 0

    private fun movement(): Int = direction.multiplicator * ticks

    companion object {
        fun create(input: String): Rotation {
            val direction = Direction.create(input[0])
            val ticks = input.substring(1).toInt()
            return Rotation(direction, ticks)
        }
    }
}