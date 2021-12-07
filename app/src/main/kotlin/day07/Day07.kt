package day07

import common.InputRepo
import common.readSessionCookie
import common.solve
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val day = 7
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay07Part1, ::solveDay07Part2)
}

private fun List<String>.toCrabs(): List<Long> = first()
    .split(",")
    .map(String::toLong)

fun solveDay07Part1(input: List<String>): Long {
    val crabPositions = input.toCrabs()
    return (crabPositions.minOrNull()!!..crabPositions.maxOrNull()!!).minOf { possiblePosition ->
        crabPositions.sumOf { crabPosition -> crabPosition distanceTo possiblePosition }
    }
}

private infix fun Long.distanceTo(other: Long): Long = (this - other).absoluteValue

fun solveDay07Part2(input: List<String>): Long {
    val crabPositions = input.toCrabs()
    return (crabPositions.minOrNull()!!..crabPositions.maxOrNull()!!).minOf { possiblePosition ->
        crabPositions.sumOf { crabPosition -> crabPosition exponentialDistanceTo possiblePosition }
    }
}

private infix fun Long.exponentialDistanceTo(
    other: Long,
): Long = (0..this.distanceTo(other)).sum()
