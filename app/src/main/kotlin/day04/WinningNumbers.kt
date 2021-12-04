package day04

@JvmInline
value class WinningNumbers(val numbers: List<Int>) {
    fun dropFirst(): WinningNumbers {
        return WinningNumbers(
            numbers = numbers.drop(1)
        )
    }

    companion object {
        fun fromInput(input: List<String>): WinningNumbers {
            return WinningNumbers(
                input.first()
                    .split(",")
                    .map(String::toInt)
            )
        }
    }
}
