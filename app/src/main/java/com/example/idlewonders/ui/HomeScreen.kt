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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idlewonders.R
import com.example.idlewonders.data.Mana
import com.example.idlewonders.data.PlayerViewModel
import com.example.idlewonders.ui.components.BuildingScene
import com.example.idlewonders.ui.components.DebugControls
import com.example.idlewonders.ui.components.NavigationButton
import com.example.idlewonders.ui.components.ProgressBar

// TODO: Break out some of these widget sections into reusable components.
@Composable
fun HomeScreen(viewModel: PlayerViewModel) {
    val playerMoney by viewModel.money.collectAsState()
    val playerMana by viewModel.mana.collectAsState()
    val playerCurrentWonder by viewModel.currentWonder.collectAsState()
    val playerTapPower by viewModel.tapPower.collectAsState()

    Box() {
        BuildingScene(level = playerCurrentWonder.level)
        Column {
            Box(modifier = Modifier.padding(top = 48.dp, start = 8.dp, end = 8.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier)

                Image(
                    painter = painterResource(id = R.drawable.settings_block),
                    contentDescription = "Settings Button",
                    modifier = Modifier
                        .clickable {
                            println("Settings Button clicked")
                            viewModel.toggleDebug()
                        }
                        .size(52.dp)
                )

            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Money $playerMoney", fontSize = 20.sp)
                        Image(
                            painter = painterResource(id = R.drawable.coin_symbol),
                            contentDescription = "Coin Symbol",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(28.dp)
                        )
                    }
                    Row {
                        Text(text = "Mana $playerMana")
                        Image(
                            painter = painterResource(id = R.drawable.mana_symbol),
                            contentDescription = "Mana Symbol",
                            modifier = Modifier.padding(start = 18.dp)
                        )
                    }
                }
                ProgressBar(
                    amountDone = playerCurrentWonder.workDone,
                    amountNeeded = playerCurrentWonder.workNeeded,
                    currentPercentage = playerCurrentWonder.percentComplete.toFloat()
                )

                Text(text = "Level ${playerCurrentWonder.level}")
            }
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {
                        viewModel.incrementMana(Mana(2))
                        playerCurrentWonder.applyWork(playerTapPower)
                        //TODO: clean this up, looks gross, you can do better.
                        viewModel.incrementMoney(viewModel.moneyAmountForLabor(playerTapPower))
                    }
            ) {
                if (viewModel.debug) {
                    DebugControls(viewModel)
                }
            }

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 12.dp)
                ) {

                NavigationButton(text = "Employees", onClick = { println("Employees") })
                NavigationButton(text = "Spells", onClick = { println("Spells") })
                NavigationButton(text = "Innovations", onClick = { println("Innovations") })
            }
        }
    }
}

// TODO: add Preview
@Preview
@Composable
fun PreviewHomeScreen() {
    val dummyViewModel = PlayerViewModel()
    HomeScreen(viewModel = dummyViewModel)
}