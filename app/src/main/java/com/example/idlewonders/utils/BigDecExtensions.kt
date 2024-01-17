package com.example.idlewonders.utils

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

// Returns this as a percentage of another BigDecimal
fun BigDecimal.percentOf(num: BigDecimal): BigDecimal {
    val perc = (this / num) * BigDecimal(100)
    return perc.setScale(2, RoundingMode.CEILING)
}

// Returns this * 1.07^(level)
fun BigDecimal.costCalc(level: Int): BigDecimal {
    val exponent = BigDecimal(1.07.pow(level))
    val result = this * exponent
    return result.setScale(2, RoundingMode.CEILING)
}

/*
// TODO: See if I need this, or I can get away with just the rounding.
val BigDecimal.formattedString: String
    get() = this.toString()
 */