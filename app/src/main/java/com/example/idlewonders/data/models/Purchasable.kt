package com.example.idlewonders.data.models

import com.example.idlewonders.utils.costCalc
import java.math.BigDecimal

interface Purchasable {
    var baseCost: BigDecimal

    fun costForLevel(level: Int): BigDecimal {
        return baseCost.costCalc(level)
    }
}