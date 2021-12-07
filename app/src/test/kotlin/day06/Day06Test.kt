package day06

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day06Test : FreeSpec({

    val inputPart1: List<String> = listOf("3,4,3,1,2")

    val inputPart2: List<String> = inputPart1

    val sampleSolutionPart1: Int = 5934

    val sampleSolutionPart2: Long = 26_984_457_539

    "Solving day 6" - {
        "part 1 for the sample input should return the correct output" {
            solveDay06Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay06Part2(inputPart2) shouldBe sampleSolutionPart2
        }

        "input maps to proper map" {
            val expectedResult = School(
                mapOf(
                    Fish(8) to 0,
                    Fish(7) to 0,
                    Fish(6) to 0,
                    Fish(5) to 0,
                    Fish(4) to 1,
                    Fish(3) to 2,
                    Fish(2) to 1,
                    Fish(1) to 1,
                    Fish(0) to 0,
                )
            )

            val result = School.fromInput(inputPart1)

            result shouldBe expectedResult
        }

        "advance a day with new fish spawning" {
            val currentDay = School(
                mapOf(
                    Fish(8) to 1,
                    Fish(7) to 1,
                    Fish(6) to 1,
                    Fish(5) to 1,
                    Fish(4) to 1,
                    Fish(3) to 1,
                    Fish(2) to 1,
                    Fish(1) to 1,
                    Fish(0) to 1,
                )
            )
            val expectedResult = School(
                mapOf(
                    Fish(8) to 1,
                    Fish(7) to 1,
                    Fish(6) to 2,
                    Fish(5) to 1,
                    Fish(4) to 1,
                    Fish(3) to 1,
                    Fish(2) to 1,
                    Fish(1) to 1,
                    Fish(0) to 1,
                )
            )

            val result = School.advanceDays(currentDay, 1)

            result shouldBe expectedResult
        }
    }
})
