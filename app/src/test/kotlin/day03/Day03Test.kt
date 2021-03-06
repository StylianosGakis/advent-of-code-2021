package day03

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day03Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )

    val inputPart2: List<String> = inputPart1

    val sampleSolutionPart1: Int = 198

    val sampleSolutionPart2: Int = 230

    "Solving day 3" - {
        "part 1 for the sample input should return the correct output" {
            solveDay03Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay03Part2(inputPart2) shouldBe sampleSolutionPart2
        }

        "given list of int lists, extract the gamma rate" {
            val input = listOf(
                listOf(0, 0, 1, 0, 0),
                listOf(1, 0, 1, 0, 0),
                listOf(1, 1, 1, 0, 1),
            )
            val expectedResult =
                listOf(1, 0, 1, 0, 0)

            val actual = GammaRate.fromInput(input)

            actual.bits shouldBe expectedResult
        }

        "get epsilon rate from gamma rate" {
            val input = GammaRate(
                listOf(0, 0, 1, 1, 0)
            )
            val expectedResult = EpsilonRate(
                listOf(1, 1, 0, 0, 1)
            )

            val actual = EpsilonRate.fromGammaRate(input)

            actual shouldBe expectedResult
        }

        "bitList converts to decimal" {
            val list = object : Rate {
                override val bits: Bits
                    get() = listOf(1, 0, 1, 0, 1)
            }
            val expectedResult = 16 + 4 + 0 + 1

            val actual = list.toDecimalNumber()

            actual shouldBe expectedResult
        }

        "convert input to oxygen rate" {
            val input = inputPart2.map(String::toBits)
            val expected = listOf(1, 0, 1, 1, 1)

            val actual = OxygenRate.fromInput(input)

            actual.bits shouldBe expected
        }

        "convert input to scrubber rate" {
            val input = inputPart2.map(String::toBits)
            val expected = listOf(0, 1, 0, 1, 0)

            val actual = ScrubberRate.fromInput(input)

            actual.bits shouldBe expected
        }
    }
})
