package com.example.idlewonders.ui

// Main screen of the game where users see progress on wonders, tap for labor, etc.

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.idlewonders.data.Mana
import com.example.idlewonders.data.Money
import com.example.idlewonders.data.PlayerViewModel

// TODO: Break out some of these widget sections into reusable components.
@Composable
fun HomeScreen(viewModel: PlayerViewModel) {
    val playerMoney by viewModel.money.collectAsState()
    val playerMana by viewModel.mana.collectAsState()

    Box(modifier = Modifier.padding(8.dp)) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier)

                Button(onClick = { println("Settings Button clicked") }) {
                    Image(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Row {
                        Text(text = "Money $playerMoney")
                        Text(text = "💰", modifier = Modifier.padding(start = 8.dp))
                    }
                    Row {
                        Text(text = "Mana $playerMana")
                        Text(text = "🪄", modifier = Modifier.padding(start = 8.dp))
                    }
                }
                Box(contentAlignment = Alignment.Center) {
                    LinearProgressIndicator(
                        progress = playerMoney.toFloat()/100f,
                        color = Color(0xFFFBC901),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                            .height(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Text(
                        text = "$playerMoney / X.XX",
                        modifier = Modifier.zIndex(1f)
                        )
                }

                Text(text = "Level X")
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {
                        viewModel.incrementMoney(Money(1))
                        viewModel.incrementMana(Mana(1))
                    }
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Employees")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Spells")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Innovations")
                }
            }
        }
    }
}

// TODO: add Preview