package day04

@JvmInline
value class Board(override val grid: List<List<BoardItem>>) : Grid<BoardItem> {
    init { // Require squared board
        val height = grid.size
        require(getAllRows().all { row -> row.size == height })
    }

    fun setMarkedNumber(winningNumber: Int) {
        findItemWithNumber(winningNumber)?.marked = true
    }

    fun hasWon(): Boolean {
        val hasWinningRow = getAllRows().any { it.all(BoardItem::marked) }
        val hasWinningColumn = getAllColumns().any { it.all(BoardItem::marked) }
        return hasWinningRow || hasWinningColumn
    }

    fun calculateScore(winningNumber: Int): Int {
        val scoreSum = getAllUnmarkedItems().sumOf(BoardItem::number)
        return scoreSum * winningNumber
    }

    private fun getAllUnmarkedItems(): List<BoardItem> {
        return grid
            .flatten()
            .filterNot(BoardItem::marked)
    }

    private fun findItemWithNumber(number: Int): BoardItem? {
        return grid.flatten().firstOrNull { it.number == number }
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
