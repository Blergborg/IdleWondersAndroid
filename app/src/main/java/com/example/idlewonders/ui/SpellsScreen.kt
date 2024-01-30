package com.example.idlewonders.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.idlewonders.R

@Composable
fun SpellsScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.spell_tower_background),
                contentScale = ContentScale.FillBounds
            )
    ) {

    }
}

@Preview
@Composable
fun PreviewSpellsScreen() {
    SpellsScreen()
}