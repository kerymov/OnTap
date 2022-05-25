package com.example.ontap.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ontap.R

@Composable
fun TopBar(
    eventLabel: String,
    onSelectEventButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = "Logo",
        tint = MaterialTheme.colors.primary,
        modifier = Modifier.size(48.dp)
    )
    SelectEventButton(
        label = eventLabel,
        onClick = onSelectEventButtonClick
    )
}

@Composable
private fun SelectEventButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) = OutlinedButton(
    shape = MaterialTheme.shapes.small,
    colors = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colors.primaryVariant,
        backgroundColor = Color.Transparent
    ),
    border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.primaryVariant),
    modifier = modifier,
    onClick = onClick
) {
    Text(
        text = label,
        style = MaterialTheme.typography.button
    )
    Icon(
        imageVector = Icons.Default.ArrowDropDown,
        contentDescription = "Drop down"
    )
}