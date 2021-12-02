package day17

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day17Test : FreeSpec({

    val inputPart1: List<String> = listOf()

    val inputPart2: List<String> = listOf()

    val sampleSolutionPart1: Int = -1

    val sampleSolutionPart2: Int = -1

    "Solving day 17" - {
        "part 1 for the sample input should return the correct output" {
            solveDay17Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay17Part2(inputPart2) shouldBe sampleSolutionPart2
        }
    }
})
