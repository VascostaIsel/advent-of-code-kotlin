package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val digits = line.filter { it.isDigit() }
            val calibrationDigits = digits.first().toString() + digits.last().toString()
            calibrationDigits.toInt()
        }
    }

    fun part2(input: List<String>): Int {
        val digitsMap = mapOf(
            "one" to "one1one",
            "two" to "two2two",
            "three" to "three3three",
            "four" to "four4four",
            "five" to "five5five",
            "six" to "six6six",
            "seven" to "seven7seven",
            "eight" to "eight8eight",
            "nine" to "nine9nine",
        )
        return input.sumOf { l ->
            var line = l
            digitsMap.forEach { entry ->
                line = line.replace(entry.key, entry.value)
            }
            val digits = line.filter { it.isDigit() }
            val calibrationDigits = digits.first().toString() + digits.last().toString()
            calibrationDigits.toInt()
        }
    }

    val input = readInput("day01/Day01")
    //val input = readInput("day01/Day01_test")
    part1(input).println()
    part2(input).println()
}
