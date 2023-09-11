package com.moataz.jetanimation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GoatFootballAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    var animateGoat by remember { mutableStateOf(false) }

    val footballOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 210f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )

    val footballRotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = RepeatMode.Restart,
        ),
        label = "",
    )

    val goatOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -10f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )

    LaunchedEffect(footballOffset) {
        animateGoat = footballOffset >= 201f
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.uefa),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 64.dp),
            )
        }

        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.score_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .offset(y = footballOffset.dp)
                    .rotate(footballRotation),
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter,
        ) {
            Image(
                painter = painterResource(id = R.drawable.goat),
                contentDescription = null,
                modifier = Modifier
                    .size(140.dp)
                    .padding(bottom = 16.dp)
                    .offset(y = if (animateGoat) goatOffset.dp else 0.dp),
            )
        }
    }
}
