package day01

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 1
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay01Part1, ::solveDay01Part2)
}


fun solveDay01Part1(input: List<String>): Int {
    return input
        .map(String::toInt)
        .zipWithNext()
        .count { pair -> pair.second > pair.first }
}

fun solveDay01Part2(input: List<String>): Int {
    return input
        .map(String::toInt)
        .windowed(size = 3, transform = List<Int>::sum)
        .zipWithNext()
        .count { pair -> pair.second > pair.first }
}
