package day07

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day07Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "16,1,2,0,4,2,7,1,2,14"
    )

    val inputPart2: List<String> = inputPart1

    val sampleSolutionPart1: Int = 37

    val sampleSolutionPart2: Int = 168

    "Solving day 7" - {
        "part 1 for the sample input should return the correct output" {
            solveDay07Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay07Part2(inputPart2) shouldBe sampleSolutionPart2
        }
    }
})
