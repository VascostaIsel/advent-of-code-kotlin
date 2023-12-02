package day02

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val bag = mapOf(
            "red" to 12,
            "green" to 13,
            "blue" to 14
        )
        return input.sumOf { line ->
            val gameId = line.split(": ")[0].filter { it.isDigit() }.toInt()
            val sets = line.split(": ")[1].split("; ")
            sets.forEach { subSet ->
                val cubes = subSet.split(", ")
                cubes.forEach { cub ->
                    val number = cub.split(" ")[0].toInt()
                    val color = cub.split(" ")[1]
                    val limit = bag[color]
                    if (number > limit!!)
                        return@sumOf 0
                }
            }
            gameId
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val maxOfColor = mutableMapOf(
                "red" to 0,
                "green" to 0,
                "blue" to 0
            )
            val sets = line.split(": ")[1].split("; ")
            sets.forEach { subSet ->
                val cubes = subSet.split(", ")
                cubes.forEach { cub ->
                    val number = cub.split(" ")[0].toInt()
                    val color = cub.split(" ")[1]
                    val maxOfColorValue = maxOfColor[color]
                    if (number > maxOfColorValue!!)
                        maxOfColor[color] = number
                }
            }
            maxOfColor["red"]!! * maxOfColor["green"]!! * maxOfColor["blue"]!!
        }
    }

    val input = readInput("day02/Day02")
    //val input = readInput("day02/Day02_test")
    part1(input).println()
    part2(input).println()
}
