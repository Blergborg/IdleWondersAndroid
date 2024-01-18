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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.idlewonders.data.Mana
import com.example.idlewonders.data.PlayerViewModel
import com.example.idlewonders.ui.components.ProgressBar

// TODO: Break out some of these widget sections into reusable components.
@Composable
fun HomeScreen(viewModel: PlayerViewModel) {
    val playerMoney by viewModel.money.collectAsState()
    val playerMana by viewModel.mana.collectAsState()
    val playerCurrentWonder by viewModel.currentWonder.collectAsState()
    val playerTapPower by viewModel.tapPower.collectAsState()

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
                ProgressBar(
                    amountDone = playerCurrentWonder.workDone,
                    amountNeeded = playerCurrentWonder.workNeeded,
                    currentPercentage = playerCurrentWonder.percentComplete.toFloat()
                )

                Text(text = "Level ${playerCurrentWonder.level}")
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {
                        viewModel.incrementMana(Mana(2))
                        playerCurrentWonder.applyWork(playerTapPower)
                        //TODO: clean this up, looks gross, you can do better.
                        viewModel.incrementMoney(viewModel.moneyAmountForLabor(playerTapPower))
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