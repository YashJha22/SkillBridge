package com.skillbridge.app.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skillbridge.app.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.skillbridge_logo),
                contentDescription = "SkillBridge",
                modifier = Modifier.width(220.dp)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Canvas(
                modifier = Modifier
                    .width(90.dp)
                    .height(20.dp)
            ) {
                val wavePath = Path().apply {
                    moveTo(0f, size.height / 2)

                    cubicTo(
                        size.width * 0.25f, 0f,
                        size.width * 0.75f, size.height,
                        size.width, size.height / 2
                    )
                }

                drawPath(
                    path = wavePath,
                    color = Color(0xFFC9A66B),
                    style = Stroke(
                        width = 1.5.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "LEARN · EARN · INVEST",
                color = Color(0xFFB8B2A8),
                fontSize = 12.sp,
                letterSpacing = 3.sp
            )
        }
    }
}