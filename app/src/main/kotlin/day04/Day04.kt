package day04

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 4
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay04Part1, ::solveDay04Part2)
}


fun solveDay04Part1(input: List<String>): Int {
    val winningNumbers = WinningNumbers.fromInput(input)
    val boards = Board.listFromInput(input)

    val (winningBoard, winningNumber) = findWinningBoardWithWinningNumber(winningNumbers, boards)
    val finalScore = calculateFinalScore(winningBoard, winningNumber)
    return finalScore
}

private fun findWinningBoardWithWinningNumber(
    winningNumbers: WinningNumbers,
    boards: List<Board>,
): Pair<Board, Int> {
    winningNumbers.numbers.forEach { winningNumber ->
        boards.forEach { board ->
            board.setMarkedNumber(winningNumber)
        }
        val wonBoard = boards.firstOrNull { board -> board.hasWon() }
        if (wonBoard != null) return wonBoard to winningNumber
    }
    throw NoSuchElementException("No board has won")
}

fun calculateFinalScore(winningBoard: Board, winningNumber: Int): Int {
    val scoreSum = winningBoard
        .getAllUnmarkedItems()
        .sumOf(BoardItem::number)
    return scoreSum * winningNumber
}

fun solveDay04Part2(input: List<String>): Int {
    TODO()
}
