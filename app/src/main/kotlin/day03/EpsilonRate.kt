package day03

@JvmInline
value class EpsilonRate(override val bits: Bits) : Rate {
    companion object {
        fun fromGammaRate(gammaRate: GammaRate): EpsilonRate = EpsilonRate(
            gammaRate.bits.flipBits()
        )
    }
}
