package com.example.idlewonders.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.idlewonders.R

@Composable
fun NavigationButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .paint(
                painter = painterResource(id = R.drawable.employee_buy_button_2),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )
            .requiredSize(width = 120.dp, height = 40.dp)
            .padding(4.dp)
            .clickable { onClick() }

    ){
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PreviewNavigationButton() {
    NavigationButton(text = "Test", onClick = {println("Test")})
}