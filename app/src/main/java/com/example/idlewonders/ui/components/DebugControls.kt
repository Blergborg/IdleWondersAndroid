package com.example.idlewonders.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idlewonders.data.PlayerViewModel

@Composable
fun DebugControls(viewModel: PlayerViewModel) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0, 0, 0, 80)),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
               TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }
                ) {
                    Text("Set Mana", textAlign = TextAlign.Center, color = Color.Cyan)
                }
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { /*TODO*/ }) {
                    Text("Set Money", textAlign = TextAlign.Center, fontSize = 12.sp, color = Color.Cyan)
                }
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.debugLvlUp()
                    }) {
                    Text("Finish Level", textAlign = TextAlign.Center, color = Color.Cyan)
                }
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.debugWin() }
                ) {
                    Text("Win", textAlign = TextAlign.Center, color = Color.Cyan)
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.debugLvlUp(-100) }
                ) {
                    Text("Lvl -100", textAlign = TextAlign.Center, color = Color.Cyan)
                }
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.debugLvlUp(100) }
                ) {
                    Text("Lvl +100", textAlign = TextAlign.Center, color = Color.Cyan)
                }
                TextButton(
                    modifier = Modifier.weight(1f),
                    onClick = { viewModel.incrementInnovationPoints(5) }
                ) {
                    Text("Innovation +5", textAlign = TextAlign.Center, fontSize = 12.sp, color = Color.Cyan)
                }

            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextButton(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                    Text("Test Tutorial", textAlign = TextAlign.Center, fontSize = 10.sp, color = Color.Cyan)
                }
                TextButton(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                    Text("Test changelog", textAlign = TextAlign.Center, fontSize = 8.sp, color = Color.Cyan)
                }
                TextButton(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                    Text("Reset Ad Time", textAlign = TextAlign.Center, fontSize = 8.sp, color = Color.Cyan)
                }
                TextButton(modifier = Modifier.weight(1f), onClick = { /*TODO*/ }) {
                    Text("15 Minutes", textAlign = TextAlign.Center, fontSize = 10.sp, color = Color.Cyan)
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DebugControlsPreview() {
    val dummyViewModel = PlayerViewModel()
    DebugControls(dummyViewModel)
}