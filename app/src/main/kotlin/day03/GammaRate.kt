package day03

@JvmInline
value class GammaRate(override val bits: Bits) : Rate {
    companion object {
        fun fromInput(input: List<Bits>): GammaRate {
            return input
                .fold(List(input.maxOf { it.size }) { OccurrenceCounter() }) { acc, bitList ->
                    acc.mapIndexed { index, counter ->
                        counter + bitList[index]
                    }
                }
                .map(OccurrenceCounter::getMostCommonBit)
                .let { GammaRate(it) }
        }
    }
}
