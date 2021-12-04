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
    return winningBoard.calculateScore(winningNumber)
}

private tailrec fun findWinningBoardWithWinningNumber(
    winningNumbers: WinningNumbers,
    boards: List<Board>,
): Pair<Board, Int> {
    val winningNumber = winningNumbers.numbers.first()
    boards.forEach { board ->
        board.setMarkedNumber(winningNumber)
    }
    val wonBoard = boards.firstOrNull { board -> board.hasWon() }
    if (wonBoard != null) return wonBoard to winningNumber
    return findWinningBoardWithWinningNumber(winningNumbers.dropFirst(), boards)
}

fun solveDay04Part2(input: List<String>): Int {
    val winningNumbers = WinningNumbers.fromInput(input)
    val boards = Board.listFromInput(input)

    val (winningBoard, winningNumber) = findLastWinningBoardWithWinningNumber(winningNumbers, boards)
    return winningBoard.calculateScore(winningNumber)
}

private tailrec fun findLastWinningBoardWithWinningNumber(
    winningNumbers: WinningNumbers,
    boards: List<Board>,
): Pair<Board, Int> {
    val winningNumber = winningNumbers.numbers.first()
    boards.forEach { board ->
        board.setMarkedNumber(winningNumber)
    }
    if (boards.size == 1 && boards.first().hasWon()) return boards.first() to winningNumber
    val boardsWithoutTheWinningOnes = boards.filterNot { board -> board.hasWon() }
    return findLastWinningBoardWithWinningNumber(
        winningNumbers.dropFirst(), boardsWithoutTheWinningOnes
    )
}
