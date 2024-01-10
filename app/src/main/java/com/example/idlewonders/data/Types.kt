package com.example.idlewonders.data

// Custom Types for the game

import java.math.BigDecimal

typealias Money = BigDecimal
typealias Mana = BigDecimal
typealias WorkAmount = BigDecimal
typealias Research = BigDecimal
typealias InnovationPoints = Int

typealias AdRewards = Map<String, Int>

typealias EmployeeId = String
typealias SpecialistId = String
typealias WizardId = String
typealias ResearcherId = String
typealias SpellId = String
typealias GreatPersonId = String


typealias EmployeeLevelsDict = Map<EmployeeId, Int>
typealias SpecialistLevelsDict = Map<SpecialistId, Int>
typealias WizardLevelsDict = Map<WizardId, Int>
typealias ResearcherLevelsDict = Map<ResearcherId, Int>
typealias SpellLevelsDict = Map<SpellId, Int>
typealias SpellResearchLevelsDict = Map<SpellId, Research>
typealias GreatPersonLevelsDict = Map<GreatPersonId, Int>

enum class WonderType {
    PYRAMID,
    PARTHENON,
    ORACLE,
    COLOSSUS,
    HANGING_GARDEN,
    STONEHENGE,
    GREAT_WALL
}