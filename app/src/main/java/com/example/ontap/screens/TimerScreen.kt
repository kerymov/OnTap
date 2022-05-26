package com.example.ontap.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ontap.utils.ScrambleGenerator
import com.example.ontap.utils.Timer

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun TimerScreen(
    modifier: Modifier = Modifier
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
) {
    val scrambleGenerator = ScrambleGenerator()
    var scramble by remember {
        mutableStateOf(scrambleGenerator.getNext())
    }

    Scramble(
        scramble = scramble,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    )

    val timer = remember { Timer() }
    TimerView(
        formattedTime = timer.formattedTime,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                with(timer) {
                    if (isActive) {
                        pause()
                        scramble = scrambleGenerator.getNext()
                    } else {
                        reset()
                        start()
                    }
                }
            }
            .padding(16.dp)
    )
}

@Composable
private fun Scramble(
    scramble: String,
    modifier: Modifier = Modifier
) = Text(
    text = scramble,
    style = MaterialTheme.typography.subtitle2,
    textAlign = TextAlign.Center,
    modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
)

@Composable
private fun TimerView(
    formattedTime: String,
    modifier: Modifier = Modifier
) = Box(
    contentAlignment = Alignment.Center,
    modifier = modifier
) {
    Text(
        text = formattedTime,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.primaryVariant
    )
}