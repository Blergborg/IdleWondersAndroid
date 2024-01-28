package com.example.idlewonders.ui.components

import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.idlewonders.R

@Composable
fun AlienAnimation(modifier: Modifier = Modifier) {
    val ufoFrames = remember {
        listOf(
            R.drawable.ufo_sprite_frame1,
            R.drawable.ufo_sprite_frame2,
            R.drawable.ufo_sprite_frame3
        )
    }
    val beamFrames = remember {
        listOf(
            R.drawable.alien_beam_1,
            R.drawable.alien_beam_2,
            R.drawable.alien_beam_3,
            R.drawable.alien_beam_4
        )
    }
    val ufoTransition = rememberInfiniteTransition(label = "ufo")
    val ufoIndex by ufoTransition.animateValue(
        initialValue = 0,
        targetValue = ufoFrames.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
            }
        ),
        label = "ufo"
    )

    val beamTransition = rememberInfiniteTransition(label = "beam")
    val beamIndex by beamTransition.animateValue(
        initialValue = 0,
        targetValue = beamFrames.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
            }
        ),
        label = "beam"
    )

    Box(modifier = modifier) {
        Image(painter = painterResource(id = ufoFrames[ufoIndex]), contentDescription = "ufo animation")
        Image(
            painter = painterResource(id = beamFrames[beamIndex]),
            contentDescription = "beam animation",
            modifier = Modifier.offset(40.dp, 50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlienAnimationPreview() {
    AlienAnimation()
}