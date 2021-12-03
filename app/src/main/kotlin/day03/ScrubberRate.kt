package day03

@JvmInline
value class ScrubberRate(override val bits: Bits) : Rate {
    companion object {
        private const val SCRUBBER_PREFERRED_BIT = 0

        fun fromInput(input: List<Bits>): ScrubberRate {
            val bits = input.filterGeneratorRating(
                getPreferredBit = { occurrenceCounter ->
                    occurrenceCounter.getLeastCommonBit(SCRUBBER_PREFERRED_BIT)
                }
            )
            return ScrubberRate(bits)
        }
    }
}
