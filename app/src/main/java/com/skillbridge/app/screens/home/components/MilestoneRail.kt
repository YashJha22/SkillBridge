package com.skillbridge.app.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun MilestoneRail(
    learnProgress: Int,
    earnProgress: Int,
    investProgress: Int,
    modifier: Modifier = Modifier
) {
    val overallProgress =
        (learnProgress + earnProgress + investProgress) / 3f

    val railColor = MaterialTheme.colorScheme.outlineVariant
    val progressColor = MaterialTheme.colorScheme.primary

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "YOUR BRIDGE",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            val railY = size.height / 2
            val railStart = 0f
            val railEnd = size.width

            drawLine(
                color = railColor,
                start = Offset(railStart, railY),
                end = Offset(railEnd, railY),
                strokeWidth = 2.dp.toPx()
            )

            val progressX =
                railStart + (railEnd - railStart) *
                        (overallProgress / 100f)

            drawLine(
                color = progressColor,
                start = Offset(railStart, railY),
                end = Offset(progressX, railY),
                strokeWidth = 2.dp.toPx()
            )

            drawCircle(
                color = progressColor,
                radius = 5.dp.toPx(),
                center = Offset(progressX, railY)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MilestoneLabel(
                title = "LEARN",
                progress = learnProgress
            )

            MilestoneLabel(
                title = "EARN",
                progress = earnProgress
            )

            MilestoneLabel(
                title = "INVEST",
                progress = investProgress
            )
        }
    }
}

@Composable
private fun MilestoneLabel(
    title: String,
    progress: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "$progress%",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}