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
        } else if (abs(x - end.x) == abs(y - end.y)) {
            val start = this
            val xRange = if (start.x < end.x) {
                start.x..end.x
            } else {
                start.x downTo end.x
            }
            val yRange = if (start.y < end.y) {
                start.y..end.y
            } else {
                start.y downTo end.y
            }
            (xRange zip yRange).map { (x, y) ->
                Point(x, y)
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
