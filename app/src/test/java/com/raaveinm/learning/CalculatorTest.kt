package com.raaveinm.learning

import com.raaveinm.learning.ui.viewmodel.TipCalculatorViewModel
import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.*

class CalculatorTest {

    @Test
    fun calculateTwentyPercentTip(){
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = TipCalculatorViewModel().calculateTip(amount, tipPercent)
        assertEquals(expectedTip, actualTip)
    }


}