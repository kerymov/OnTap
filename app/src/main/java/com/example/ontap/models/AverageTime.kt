package com.example.ontap.models

enum class AverageType {
    AVG5, AVG12, AVG50, AVG100, AVG1000, SESSION_AVG
}

class AverageTime(val times: List<Long>) {
    val value: Long?
        get() = calculateAverageTime(times)

    private fun calculateAverageTime(times: List<Long>): Long? {
        with(times) {
            return (sum() - minOrNull()!! - maxOrNull()!!) / size - 2
        }
    }
}
