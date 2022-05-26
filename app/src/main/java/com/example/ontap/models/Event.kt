package com.example.ontap.models

class Event(val name: String) {
    val solves = mutableListOf<Solve>()
    private val results
        get() = getResults()

    fun addSolve(solve: Solve) {
        solves.add(solve)
    }

    @JvmName("getResults1")
    private fun getResults(): Map<AverageType, AverageTime?> {
        return mapOf(
            AverageType.AVG5 to getResult(AverageType.AVG5),
            AverageType.AVG12 to getResult(AverageType.AVG12),
            AverageType.AVG50 to getResult(AverageType.AVG50),
            AverageType.AVG100 to getResult(AverageType.AVG100),
            AverageType.AVG1000 to getResult(AverageType.AVG1000),
        )
    }

    private fun getResult(averageType: AverageType): AverageTime? {

        val times = when (averageType) {
            AverageType.AVG5 -> getLastFive()
            AverageType.AVG12 -> getLastTwelve()
            AverageType.AVG50 -> getLastFifty()
            AverageType.AVG100 -> getLastHundred()
            AverageType.AVG1000 -> getLastThousand()
            AverageType.SESSION_AVG -> getAll()
        }

        times?.map { it.time }?.let {
            return AverageTime(it)
        }
        return null
    }

    private fun getLastFive() = getLast(5)
    private fun getLastTwelve() = getLast(12)
    private fun getLastFifty() = getLast(50)
    private fun getLastHundred() = getLast(100)
    private fun getLastThousand() = getLast(1000)
    private fun getAll() = solves

    private fun getLast(count: Int): List<Solve>? {
        if (count > solves.size) return null
        return solves.takeLast(count)
    }

    companion object {
        val Three = Event(name = "3x3 cube")
    }
}