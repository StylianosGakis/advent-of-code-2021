package day02

import common.InputRepo
import common.readSessionCookie
import common.solve

fun main(args: Array<String>) {
    val day = 2
    val input = InputRepo(args.readSessionCookie()).get(day = day)

    solve(day, input, ::solveDay02Part1, ::solveDay02Part2)
}

enum class SubmarineAction {
    Forward,
    Down,
    Up,
    ;

    companion object {
        fun fromInput(input: String): SubmarineAction = when (input) {
            "forward" -> Forward
            "down" -> Down
            "up" -> Up
            else -> throw IllegalArgumentException("Wrong input format")
        }
    }
}

data class ActionWithMagnitude(val submarineAction: SubmarineAction, val magnitude: Int) {
    companion object {
        fun fromInput(input: String): ActionWithMagnitude = input
            .split(" ")
            .let { ActionWithMagnitude(SubmarineAction.fromInput(it[0]), it[1].toInt()) }
    }
}

data class Position(val x: Int, val y: Int) {
    fun plus(action: ActionWithMagnitude) = when(action.submarineAction) {
        SubmarineAction.Forward -> Position(x + action.magnitude, y)
        SubmarineAction.Down -> Position(x, y + action.magnitude)
        SubmarineAction.Up -> Position(x, y - action.magnitude)
    }
}

data class SubmarineData(
    val position: Position,
    val aim: Int,
) {
    fun plus(action: ActionWithMagnitude) = when(action.submarineAction) {
        SubmarineAction.Forward -> copy(
            position = position.copy(
                x = position.x + action.magnitude,
                y = position.y + (aim * action.magnitude)
            )
        )
        SubmarineAction.Down -> copy(aim = aim + action.magnitude)
        SubmarineAction.Up -> copy(aim = aim - action.magnitude)
    }
}

fun solveDay02Part1(input: List<String>): Int {
    return input
        .map(ActionWithMagnitude::fromInput)
        .fold(Position(0, 0), Position::plus)
        .let { position -> position.x * position.y }
}

fun solveDay02Part2(input: List<String>): Int {
    return input
        .map(ActionWithMagnitude::fromInput)
        .fold(SubmarineData(Position(0, 0), 0), SubmarineData::plus)
        .let { submarineData -> submarineData.position.x * submarineData.position.y }
}
