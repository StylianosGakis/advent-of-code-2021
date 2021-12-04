package day04

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

@OptIn(ExperimentalStdlibApi::class)
class Day04Test : FreeSpec({

    val inputPart1: List<String> = listOf(
        "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
        "",
        "22 13 17 11  0",
        "8  2 23  4 24",
        "21  9 14 16  7",
        "6 10  3 18  5",
        "1 12 20 15 19",
        "",
        "3 15  0  2 22",
        "9 18 13 17  5",
        "19  8  7 25 23",
        "20 11 10 24  4",
        "14 21 16 12  6",
        "",
        "14 21 17 24  4",
        "10 16 15  9 19",
        "18  8 23 26 20",
        "22 11 13  6  5",
        "2  0 12  3  7",
    )

    val inputPart2: List<String> = listOf()

    val sampleSolutionPart1: Int = 4512

    val sampleSolutionPart2: Int = -1

    "Solving day 4" - {
        "part 1 for the sample input should return the correct output" {
            solveDay04Part1(inputPart1) shouldBe sampleSolutionPart1
        }

        "part 2 for the sample input should return the correct output" {
            solveDay04Part2(inputPart2) shouldBe sampleSolutionPart2
        }

        "raw input maps to the board" {
            val input = """
droppedLine
droppedLine
12  3 31 10  5
10 30  1 10 10
10 10 10 10 10
10 10 10 10 10
10 10 10 10 10

10  5 31 10  5
10 30  3 10 10
10 10 10 10 10
10 10 10 10 10
10 10 10 10 10
            """.lines().drop(1).dropLast(1)
            val expectedBoards = listOf(
                Board(
                    buildList {
                        add(listOf(BoardItem(12), BoardItem(3), BoardItem(31), BoardItem(10), BoardItem(5)))
                        add(listOf(BoardItem(10), BoardItem(30), BoardItem(1), BoardItem(10), BoardItem(10)))
                        addAll(List(3) { List(5) { BoardItem(10) } })
                    },
                ),
                Board(
                    buildList {
                        add(listOf(BoardItem(10), BoardItem(5), BoardItem(31), BoardItem(10), BoardItem(5)))
                        add(listOf(BoardItem(10), BoardItem(30), BoardItem(3), BoardItem(10), BoardItem(10)))
                        addAll(List(3) { List(5) { BoardItem(10) } })
                    },
                )
            )

            val actualBoard = Board.listFromInput(input)

            actualBoard shouldBe expectedBoards
        }

        "can find specific items containing a number" {
            val board = Board(
                List(5) { y -> List(5) { x -> BoardItem(y * x) } }
            )

            board.findItemWithNumber(16) shouldBe BoardItem(16)
        }
    }
})
