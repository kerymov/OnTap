package com.example.ontap

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

internal class Timer {

    var formattedTime by mutableStateOf("00:00.00")

    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    var isActive = false
        private set

    private var timeMillis = 0L
    private var lastTimestamp = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    fun start() {
        if (isActive) return

        coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            this@Timer.isActive = true
            while (this@Timer.isActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }

    fun pause() {
        isActive = false
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        isActive = false
        timeMillis = 0L
        lastTimestamp = 0L
        formattedTime = "00:00.00"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis),
            ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern(
            "mm:ss:SS"
        )
        return localDateTime.format(formatter)
    }
}