package com.example.ontap

import kotlin.random.Random

private enum class Move {
    U, D, R, L, F, B
}

private enum class Direction {
    ORDINARY, PRIME, DOUBLE
}

class ScrambleGenerator {

    private val moves = listOf("U", "D", "R", "L", "F", "B")
    private val directions = listOf("", "'", "2")
    private var length = Random.nextInt(17, 22)

    fun getNext() = buildString {
        var move: String? = null
        for (i in 0..this@ScrambleGenerator.length) {
            move = moves.nextRandomMove(move)
            append(move)
            append(directions.random())
            if (i != this@ScrambleGenerator.length - 1) append(" ")
        }
    }

    private fun List<String>.nextRandomMove(previous: String?): String {
        var next: String = this.random()

        while (next == previous) {
            next = this.random()
        }
        return next
    }
}