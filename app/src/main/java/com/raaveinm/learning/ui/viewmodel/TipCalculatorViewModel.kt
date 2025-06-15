package com.raaveinm.learning.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class TipCalculatorViewModel : ViewModel() {
    var amountInput: MutableState<String> = mutableStateOf("0")
    var tip: MutableState<String> = mutableStateOf("0")

    fun onAmountInputChanged(amount: String) {
        amountInput.value = amount
        if (amount != "") {
            tip.value = calculateTip(billAmount = amount.toDouble(), tipPercentage = 15.0)
        } else {
            tip.value = "No tips, hooray!"
        }
    }

    private fun calculateTip(billAmount: Double, tipPercentage: Double) : String {
        val tip = tipPercentage / 100 * billAmount
        return NumberFormat.getCurrencyInstance().format(tip)
    }
}