package day16

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day16Test : FreeSpec({

    val inputPart1: List<String> = listOf()

    val inputPart2: List<String> = listOf()

    val sampleSolutionPart1: Int = -1

    val sampleSolutionPart2: Int = -1

    "Solving day 16" - {
        "part 1 for the sample input should return the correct output" {
            solveDay16Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay16Part2(inputPart2) shouldBe sampleSolutionPart2
        }
    }
})
