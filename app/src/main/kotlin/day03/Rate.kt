package day03

interface Rate {
    val bits: Bits

    fun toDecimalNumber(): Int {
        return bits
            .joinToString(separator = "") { it.toString() }
            .toInt(2)
    }
}
