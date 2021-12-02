package day01

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day01Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "199",
        "200",
        "208",
        "210",
        "200",
        "207",
        "240",
        "269",
        "260",
        "263",
        "1263",
    )

    val inputPart2: List<String> = listOf(
        "199",
        "200",
        "208",
        "210",
        "200",
        "207",
        "240",
        "269",
        "260",
        "263",
    )

    val sampleSolutionPart1: Int = 8

    val sampleSolutionPart2: Int = 5

    "Solving day 1" - {
        "part 1 for the sample input should return the correct output" {
            solveDay01Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay01Part2(inputPart2) shouldBe sampleSolutionPart2
        }
    }
})
