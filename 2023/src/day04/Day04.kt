package day04

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {

        return input.sumOf { line ->
            var nOfMatches = 0
            val card = line.split(": ")[1].split("| ")
            val winningNumbers = card[0].split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            val numbers = card[1].split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            numbers.forEach { it ->
                if (winningNumbers.contains(it)) nOfMatches = if (nOfMatches == 0) 1 else nOfMatches * 2
            }
            nOfMatches
        }
    }

    fun part2(input: List<String>): Int {
        var nOfCards = 0
        val cardsCopies = MutableList(input.size) { 1 } // initial number of cards
        cardsCopies.indices.forEach { cardIdx ->
            val card = input[cardIdx]
            nOfCards += cardsCopies[cardIdx] // add the number of copies of the current card
            val cardNumbers = card.split(": ")[1].split("| ")[1].split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            val cardMatches = card.split(": ")[1].split("| ")[0].split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            var nOfMatches = 0
            cardNumbers.forEach { if (cardMatches.contains(it)) nOfMatches++ }
            // loop through the next cards and add the number of copies of the current card to them
            for (nextCard in (cardIdx + 1) .. (cardIdx + nOfMatches))
                cardsCopies[nextCard] = cardsCopies[nextCard] + cardsCopies[cardIdx]
        }
        return nOfCards
    }

    val input = readInput("day04/Day04")
    //val input = readInput("day04/Day04_test")
    part1(input).println()
    part2(input).println()
}
