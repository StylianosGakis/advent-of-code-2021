package day03

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 3
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay03Part1, ::solveDay03Part2)
}

fun solveDay03Part1(input: List<String>): Int {
    return input.map(String::toBits)
        .let(GammaRate::fromInput)
        .let { gammaRate ->
            gammaRate to EpsilonRate.fromGammaRate(gammaRate)
        }
        .let { it.first.toDecimalNumber() * it.second.toDecimalNumber() }
}

fun solveDay03Part2(input: List<String>): Int {
    return input.map(String::toBits)
        .let {
            OxygenRate.fromInput(it) to ScrubberRate.fromInput(it)
        }
        .let { (oxygenRate, scrubberRate) ->
            oxygenRate.toDecimalNumber() * scrubberRate.toDecimalNumber()
        }
}
