package com.example.idlewonders.data.models

import java.math.BigDecimal

interface Purchasable {
    var baseCost: BigDecimal

    fun costForLevel(level: Int): BigDecimal {
        return baseCost //.costCalc(level)
    }
}