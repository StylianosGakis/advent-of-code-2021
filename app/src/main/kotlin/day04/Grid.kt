package day04

interface Grid<T> {
    val grid: List<List<T>>

    fun getColumn(index: Int): List<T> {
        return grid.map { it[index] }
    }

    fun getAllColumns(): List<List<T>> {
        return grid[0]
            .indices
            .map { index ->
                getColumn(index)
            }
    }

    fun getAllRows(): List<List<T>> {
        return grid
    }
}
