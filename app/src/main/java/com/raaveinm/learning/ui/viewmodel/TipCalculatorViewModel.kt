package com.raaveinm.learning.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class TipCalculatorViewModel : ViewModel() {
    val amountInput: MutableState<String> = mutableStateOf("")
    var tip: MutableState<String> = mutableStateOf("No tips, hooray")
    val percentageInput: MutableState<String> = mutableStateOf("")
    val roundUp: MutableState<Boolean> = mutableStateOf(false)

    fun onAmountInputChanged(amount: String) {
        amountInput.value = amount
        if (amount != "" && amount != "0") {
            tip.value = calculateTip(billAmount = amount.toDouble(), tipPercentage = 15.0)
        } else {
            tip.value = "No tips, hooray!"
        }
    }

    private fun calculateTip(billAmount: Double, tipPercentage: Double) : String {
        var calculatedTip = tipPercentage / 100 * billAmount
        if (roundUp.value) calculatedTip = kotlin.math.ceil(calculatedTip)
        return NumberFormat.getCurrencyInstance().format(calculatedTip)
    }

    fun onPercentageInputChanged(percentage: String) {
        percentageInput.value = percentage
        if (percentage != "" && percentage != "0") {
            tip.value = calculateTip(billAmount = amountInput.value.toDouble(),
                tipPercentage = percentage.toDouble())
        } else {
            tip.value = "No tips, hooray!"
        }
    }

    fun roundUpChanged(roundUp: Boolean) {
        this.roundUp.value = roundUp
        if (amountInput.value != "" && amountInput.value != "0") {
            tip.value = calculateTip(billAmount = amountInput.value.toDouble(),
                tipPercentage = percentageInput.value.toDouble())
        }
    }
}