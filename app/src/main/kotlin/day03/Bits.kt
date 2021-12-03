package day03

typealias Bits = List<Int>

fun Bits.flipBits(): Bits {
    return this.map { bit ->
        when (bit) {
            0 -> 1
            1 -> 0
            else -> throw IllegalArgumentException()
        }
    }
}

fun String.toBits(): Bits {
    return List(length) { this[it].digitToInt(2) }
}

tailrec fun List<Bits>.filterGeneratorRating(
    getPreferredBit: (OccurrenceCounter) -> Int,
    index: Int = 0,
): Bits {
    val occurrenceCounter: OccurrenceCounter = occurrencesForIndex(index)
    val preferredBit = getPreferredBit(occurrenceCounter)
    val filteredInput = filter { bits ->
        bits[index] == preferredBit
    }
    if (filteredInput.size == 1) return filteredInput.first()
    return filteredInput.filterGeneratorRating(getPreferredBit, index + 1)
}

private fun List<Bits>.occurrencesForIndex(index: Int): OccurrenceCounter {
    return map { it[index] }
        .fold(OccurrenceCounter()) { acc, number ->
            acc + number
        }
}
