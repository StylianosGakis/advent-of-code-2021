package day06

@JvmInline
value class Fish(val timer: Int = 8) {
    init {
        require(timer in 0..8)
    }

    fun nextDay(): Fish {
        val newTimer = if (timer == 0) {
            6
        } else {
            timer - 1
        }
        return Fish(newTimer)
    }
}
