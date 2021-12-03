package day03

@JvmInline
value class OxygenRate(override val bits: Bits) : Rate {
    companion object {
        private const val OXYGEN_PREFERRED_BIT = 1

        fun fromInput(input: List<Bits>): OxygenRate {
            val bits = input.filterGeneratorRating(
                getPreferredBit = { occurrenceCounter ->
                    occurrenceCounter.getMostCommonBit(OXYGEN_PREFERRED_BIT)
                }
            )
            return OxygenRate(bits)
        }
    }
}
