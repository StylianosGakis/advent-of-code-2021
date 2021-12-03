package day03

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 3
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay03Part1, ::solveDay03Part2)
}

typealias BitList = List<Int>

fun String.toBitList(): BitList {
    return List(length) { this[it].digitToInt(2) }
}

data class OccurrenceCounter(val zeros: Int = 0, val ones: Int = 0) {
    val mostCommonBit: Int = if (zeros > ones) 0 else 1

    operator fun plus(number: Int): OccurrenceCounter = when (number) {
        0 -> copy(zeros = zeros + 1)
        1 -> copy(ones = ones + 1)
        else -> throw IllegalArgumentException()
    }
}

fun BitList.flipBits(): BitList {
    return this.map { bit ->
        when (bit) {
            0 -> 1
            1 -> 0
            else -> throw IllegalArgumentException()
        }
    }
}

@JvmInline
value class GammaRate(val bitList: BitList) {
    companion object {
        fun fromInput(input: List<BitList>): GammaRate {
            return input
                .fold(List(5) { OccurrenceCounter() }) { acc, bitList ->
                    acc.mapIndexed { index, counter ->
                        counter + bitList[index]
                    }
                }
                .map(OccurrenceCounter::mostCommonBit)
                .let { GammaRate(it) }
        }
    }
}

@JvmInline
value class EpsilonRate(val bitList: BitList) {
    companion object {
        fun fromGammaRate(gammaRate: GammaRate): EpsilonRate = EpsilonRate(
            gammaRate.bitList.flipBits()
        )
    }
}

fun solveDay03Part1(input: List<String>): Int {
    return input.map(String::toBitList)
        .let { -1 }
}

fun solveDay03Part2(input: List<String>): Int {
    TODO()
}
