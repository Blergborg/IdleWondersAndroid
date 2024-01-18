package com.example.idlewonders.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import java.math.BigDecimal

@Composable
fun ProgressBar(amountDone: BigDecimal, amountNeeded: BigDecimal, currentPercentage: Float) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        LinearProgressIndicator(
            progress = currentPercentage,
            color = Color(0xFFFBC901),
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = "$amountDone / $amountNeeded",
            modifier = Modifier.zIndex(1f)
        )
    }
}