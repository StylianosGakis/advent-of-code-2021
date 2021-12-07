package day06

@JvmInline
value class School(private val fishMap: Map<Fish, Long>) {

    fun totalNumberOfFish(): Long {
        return fishMap.values.sum()
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun nextDay(): School {
        val newFish = fishMap[Fish(0)]!!
        return buildMap<Fish, Long> {
            put(Fish(8), newFish)
            put(Fish(7), fishMap[Fish(8)]!!)
            put(Fish(6), fishMap[Fish(7)]!! + fishMap[Fish(0)]!!)
            (5 downTo 0).forEach { index ->
                put(Fish(index), fishMap[Fish(index + 1)]!!)
            }
        }.let(::School)
    }

    companion object {
        fun fromInput(input: List<String>): School {
            val fishList = input
                .first()
                .split(",")
                .map(String::toInt)
                .map(::Fish)
            val emptyMapWithAllKeys = List(9, ::Fish).associateWith { 0L }
            val mapFromInput = fishList.associateWith { fish ->
                fishList.count { it == fish }.toLong()
            }
            return emptyMapWithAllKeys
                .plus(mapFromInput)
                .let(::School)
        }

        tailrec fun advanceDays(school: School, daysLeft: Int): School {
            if (daysLeft == 0) return school
            return advanceDays(school.nextDay(), daysLeft - 1)
        }
    }
}
