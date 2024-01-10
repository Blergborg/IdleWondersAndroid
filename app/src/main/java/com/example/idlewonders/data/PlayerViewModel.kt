package com.example.idlewonders.data

// Trying to use the player as the sharedViewModel of the game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class PlayerViewModel: ViewModel() {
//    var adRewards
//    var wonder: WonderType

    // Current values for cash and mana
    // TODO: synchronized() locks for spells/etc later
    private val _money = MutableStateFlow(Money("0.00"))
    val money: StateFlow<Money> = _money.asStateFlow()
    fun incrementMoney(amount: BigDecimal) {
//        synchronized(this) {
            _money.value += amount
//        }
    }

    private val _mana = MutableStateFlow(Mana("0.00"))
    val mana: StateFlow<Mana> = _mana.asStateFlow()
    fun incrementMana(amount: BigDecimal) {
//        synchronized(this) {
            _mana.value += amount
//        }
    }

    /**
    // TODO: Synchronization stuff for later
    init {
        coroutineScope.launch {
            while (true) {
                delay(1000)
                accumulateResourcesOverTime()
            }
        }
    }

    private fun accumulateResourcesOverTime() = coroutineScope.launch {
        synchronized(this@PlayerViewModel) {
            incrementMoney(Money(1))
            incrementMana(Mana(1))
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
     **/

//    var tapPower
//    var manaPerMillisecond
//    var workPerMillisecond
//    var researchPerMillisecond

//    var lastTick
//    var level

//    var currentResearchSpell: Spell?

//    var employeeLevels
//    var specialistLevels
//    var wizardLevels
//    var spellLevels
//    var spellResearchLevels
//    var greatPersonLevels

    // TODO: DataStore for simple key-value player data?
    // Time when player first started playing Idle Wonders
//    var startTime

//    var innovationPoints

    // Whether or not the player has seen various tutorials
//    var hasSeenTut
//    var hasSeenEmployeeTut
//    var hasSeenEmployeeTut
//    var hasSeenEmployeeTut
//    var hasSeenEmployeeTut
//    var hasSeenEmployeeTut

    companion object {
        val DEFAULT_TAP_POWER = 10 // this probably needs to be a bigint or bigdecimal later
        // TODO: Maybe use DataStore for player data instead?
        val FILENAME = "playerData"
        val DEFAULT_MUSIC_VOLUME = 1.0f
        val LABOR_MONEY_PERCENTAGE = 10
    }
}