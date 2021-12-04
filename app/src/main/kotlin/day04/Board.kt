package day04

@JvmInline
value class Board(private val grid: List<List<BoardItem>>) {
    init { // Require squared board
        val height = grid.size
        require(grid.all { it.size == height })
    }

    fun setMarkedNumber(winningNumber: Int) {
        findItemWithNumber(winningNumber)?.marked = true
    }

    fun hasWon(): Boolean {
        val gri = grid
        val hasWinningRow = getAllRows().any { it.all(BoardItem::marked) }
        val hasWinningColumn = getAllColumns().any { it.all(BoardItem::marked) }
        return hasWinningRow || hasWinningColumn
    }

    fun getAllUnmarkedItems(): List<BoardItem> {
        return grid
            .flatten()
            .filterNot(BoardItem::marked)
    }

    fun findItemWithNumber(number: Int): BoardItem? {
        val gri = grid
        return gri.flatten().firstOrNull { it.number == number }
    }

    private fun getAllColumns(): List<List<BoardItem>> {
        return getRow(0).indices.map { index ->
            getColumn(index)
        }
    }

    private fun getColumn(index: Int): List<BoardItem> {
        return grid.map { it[index] }
    }

    private fun getAllRows(): List<List<BoardItem>> {
        return grid
    }

    private fun getRow(index: Int): List<BoardItem> {
        return grid[index]
    }

    companion object {
        fun listFromInput(input: List<String>): List<Board> {
            return input.asSequence()
                .drop(2)
                .windowed(5, 6, false)
                .map { gridRows ->
                    gridRows.map { numberRow ->
                        """\d{1,2}""".toRegex()
                            .findAll(numberRow)
                            .map(MatchResult::value)
                            .map(String::toInt)
                            .map(::BoardItem)
                            .toList()
                    }
                }
                .toList()
                .map(::Board)
        }
    }
}
