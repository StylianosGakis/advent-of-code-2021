package day04

@JvmInline
value class WinningNumbers(val numbers: List<Int>) {
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
