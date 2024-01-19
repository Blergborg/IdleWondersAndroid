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
import java.math.RoundingMode

class PlayerViewModel: ViewModel() {
//    var adRewards
    private val _currentWonder = MutableStateFlow(Wonder())
    val currentWonder: StateFlow<Wonder> = _currentWonder.asStateFlow()


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

    private val _innovationPoints = MutableStateFlow(0)
    val innovationPoints: StateFlow<InnovationPoints> = _innovationPoints

    fun incrementInnovationPoints(newPoints: InnovationPoints) {
        if (newPoints > 0) {
            _innovationPoints.value += newPoints
        }
        else {
            println("invalid input: $newPoints")
        }
    }
    fun spendInnovationPoints(pointCost: InnovationPoints) {
        if (pointCost <= 0) {
            println("invalid input: $pointCost, positive integers only")
        }
        else if (pointCost > _innovationPoints.value) {
            println("not enough innovation points. current points: ${_innovationPoints.value} cost: $pointCost")
        }
        else {
            _innovationPoints.value -= pointCost
        }
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

    private val _tapPower = MutableStateFlow(DEFAULT_TAP_POWER)
    val tapPower: StateFlow<WorkAmount> = _tapPower

    fun moneyAmountForLabor(labor: WorkAmount): Money {
        val earnedMoney = (labor * LABOR_PERCENTAGE_AS_MONEY).setScale(2, RoundingMode.CEILING)
        println("earned money $earnedMoney for labor $labor")
        return earnedMoney
    }
//    var manaPerMillisecond
//    var workPerMillisecond
//    var researchPerMillisecond

//    var lastTick
//    var difficultyLevel: Int  // the current level for the player, used to generate wonders

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
        val DEFAULT_TAP_POWER = WorkAmount("10.00")
        // TODO: Maybe use DataStore for player data instead?
        val FILENAME = "playerData"
        val DEFAULT_MUSIC_VOLUME = 1.0f
        val LABOR_PERCENTAGE_AS_MONEY = BigDecimal("0.10")
    }
}