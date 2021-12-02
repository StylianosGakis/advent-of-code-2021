package day02

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day02Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )

    val inputPart2: List<String> = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )

    val sampleSolutionPart1: Int = 150

    val sampleSolutionPart2: Int = 900

    "Solving day 2" - {
        "part 1 for the sample input should return the correct output" {
            solveDay02Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay02Part2(inputPart2) shouldBe sampleSolutionPart2
        }
    }
})
