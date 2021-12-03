package day03

data class OccurrenceCounter(val zeros: Int = 0, val ones: Int = 0) {
    fun getMostCommonBit(preferredBit: Int = 0): Int = when {
        zeros == ones -> preferredBit
        zeros > ones -> 0
        else -> 1
    }

    fun getLeastCommonBit(preferredBit: Int): Int = when {
        zeros == ones -> preferredBit
        zeros < ones -> 0
        else -> 1
    }

    operator fun plus(number: Int): OccurrenceCounter = when (number) {
        0 -> copy(zeros = zeros + 1)
        1 -> copy(ones = ones + 1)
        else -> throw IllegalArgumentException()
    }
}
