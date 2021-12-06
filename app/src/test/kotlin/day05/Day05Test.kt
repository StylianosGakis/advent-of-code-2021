package day05

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class Day05Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2",
    )

    val inputPart2: List<String> = listOf()

    val sampleSolutionPart1: Int = 5

    val sampleSolutionPart2: Int = -1

    "Solving day 5" - {
        "part 1 for the sample input should return the correct output" {
            solveDay05Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay05Part2(inputPart2) shouldBe sampleSolutionPart2
        }

        "map input to list of lines" {
            val input = """
                1,0 -> 1,1
                191,191 -> 999,0
            """.trimIndent().lines()
            val expectedResult = listOf(
                Line(Point(1, 0), Point(1, 1)),
                Line(Point(191, 191), Point(999, 0)),
            )

            val lines = Line.listFromInput(input)

            lines shouldContainExactly expectedResult
        }

        "Point range works horizontally" {
            val startPoint = Point(0, 10)
            val endPoint = Point(10, 10)
            val expectedResult = List(11) { x ->
                Point(x, 10)
            }

            val result = startPoint..endPoint

            result shouldContainExactly expectedResult
        }

        "Point range works vertically" {
            val startPoint = Point(10, 10)
            val endPoint = Point(10, 0)
            val expectedResult = List(11) { y ->
                Point(10, y)
            }

            val result = startPoint..endPoint

            result shouldContainExactly expectedResult
        }
    }
})
