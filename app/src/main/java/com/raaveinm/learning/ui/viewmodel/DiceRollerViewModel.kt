package com.raaveinm.learning.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceRollerViewModel : ViewModel() {
    private val _currentDiceValue = MutableLiveData<Int>()
    var currentDiceValue: LiveData<Int>
        get() = _currentDiceValue
        set(value) { _currentDiceValue.value = value.value }

    fun rollDice() {
        _currentDiceValue.value = (1..6).random()
        currentDiceValue = _currentDiceValue
    }
}