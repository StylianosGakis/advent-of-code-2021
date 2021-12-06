package day05

import kotlin.math.abs
import kotlin.math.min

data class Point(val x: Int, val y: Int) {
    operator fun rangeTo(end: Point): List<Point> {
        return if (x == end.x) {
            val startingIndex = min(y, end.y)
            val length = abs(y - end.y)
            val endingIndex = startingIndex + length
            (startingIndex..endingIndex).map { y ->
                Point(this.x, y)
            }
        } else if (y == end.y) {
            val startingIndex = min(x, end.x)
            val length = abs(x - end.x)
            val endingIndex = startingIndex + length
            (startingIndex..endingIndex).map { x ->
                Point(x, this.y)
            }
        } else {
            emptyList()
        }
    }

    companion object {
        fun fromCommaSeparatedInput(input: String): Point {
            return input
                .split(",")
                .map(String::toInt)
                .let { Point(it[0], it[1]) }
        }
    }
}
