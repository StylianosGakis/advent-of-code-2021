package day05

import kotlin.math.max

data class Line(val start: Point, val end: Point) {
    fun allPoints(): List<Point> {
        return start..end
    }

    companion object {
        fun listFromInput(input: List<String>): List<Line> {
            return input.map(::fromInputLine)
        }

        private fun fromInputLine(inputLine: String): Line {
            return inputLine.split(" -> ")
                .map(Point::fromCommaSeparatedInput)
                .let { it[0] to it[1] }
                .let { (from, to) ->
                    Line(from, to)
                }
        }
    }
}

fun List<Line>.maxX(): Int {
    return this.maxOf { line -> max(line.start.x, line.end.x) } + 1
}

fun List<Line>.maxY(): Int {
    return this.maxOf { line -> max(line.start.y, line.end.y) } + 1
}
