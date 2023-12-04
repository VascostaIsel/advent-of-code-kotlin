package day04

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {

        return input.sumOf { line ->
            val winningNumbers = mutableListOf<Int>()
            val numbers = mutableListOf<Int>()
            var firstMatch = 0
            var nOfMatches = 0
            val card = line.split(": ")[1].split("| ")
            card[0].split(" ").filter { it.isNotBlank() }.forEach { winningNumbers.add(it.toInt()) }
            card[1].split(" ").filter { it.isNotBlank() }.forEach { numbers.add(it.toInt()) }
            numbers.forEach { number ->
                if (winningNumbers.contains(number)) {
                    if (firstMatch == 0)
                        firstMatch = 1
                    else
                        nOfMatches++
                }
            }
            while (nOfMatches > 0) {
                firstMatch *= 2
                nOfMatches--
            }
            firstMatch
        }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("day04/Day04")
    //val input = readInput("day04/Day04_test")
    part1(input).println()
    //part2(input).println()
}
