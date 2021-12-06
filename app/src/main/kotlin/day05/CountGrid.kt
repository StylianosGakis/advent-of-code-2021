package day05

class CountGrid(maxX: Int, maxY: Int) {
    private val grid: List<List<Counter>> = List(maxY) {
        List(maxX) {
            Counter()
        }
    }

    fun get(x: Int, y: Int): Counter {
        return grid[y][x]
    }

    fun populateWithLines(lines: List<Line>) {
        lines.forEach { line ->
            line.allPoints()
                .forEach { point ->
                    get(point.x, point.y).count++
                }
        }
    }

    fun calculatePoints(): Int {
        return grid
            .flatten()
            .count { counter -> counter.count >= 2 }
    }
}
