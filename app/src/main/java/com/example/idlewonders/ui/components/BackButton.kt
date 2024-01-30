package com.example.idlewonders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.idlewonders.R

@Composable
fun BackButton(modifier: Modifier = Modifier, backNav: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.pyramid_thumbnail),
        contentDescription = "Back",
        modifier = modifier
            .size(50.dp)
            .padding(8.dp)
            .clickable(onClick = backNav)
    )
}

@Preview
@Composable
fun PreviewBackButton() {
    BackButton(backNav = {})
}