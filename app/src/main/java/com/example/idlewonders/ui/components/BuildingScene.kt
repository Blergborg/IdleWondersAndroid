package com.example.idlewonders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.idlewonders.R

@Composable
fun BuildingScene(modifier: Modifier = Modifier, level: Int) {

    val pyramidLocation = 480 - ((level/5) * 2)

    Box(modifier = modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.building_screen_background),
            contentScale = ContentScale.FillBounds
        )
    ) {
        // TODO: animated skybox here?
        Image(
            painter = painterResource(id = R.drawable.pyramid_texture),
            contentDescription = "wonder",
            modifier = modifier
                .fillMaxSize()
                .offset(y = (pyramidLocation).dp)
        )
        // TODO: alien animation here?
//        AlienAnimation(
//            modifier = modifier.offset(y=70.dp)
//        )
        // TODO: building clouds animation here?
        Image(
            painter = painterResource(id = R.drawable.building_screen_foreground),
            contentDescription = "foreground",
            modifier = modifier.fillMaxSize()
                .offset(y= 80.dp)
        )
    }


}

@Preview
@Composable
fun BuildingScenePreview() {
    BuildingScene(level = 1)
}