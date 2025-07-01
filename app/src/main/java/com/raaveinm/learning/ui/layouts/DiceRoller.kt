package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.raaveinm.learning.R
import com.raaveinm.learning.ui.viewmodel.DiceRollerViewModel

@Composable
fun DiceRoller(
    modifier: Modifier = Modifier,
) {
    var imageResource by rememberSaveable { mutableIntStateOf(rollAction()) }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        // verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "dice"
        )
        Spacer(Modifier.padding(16.dp))
        Button(
            onClick = { imageResource = rollAction() }
        ) { Text(text = "stringResource(R.string.roll)") }
    }
}

fun rollAction() : Int {
    val diceRollerViewModel = DiceRollerViewModel()
    diceRollerViewModel.rollDice()
    return when (diceRollerViewModel.currentDiceValue.value) {
        1 -> (R.drawable.dice_1)
        2 -> (R.drawable.dice_2)
        3 -> (R.drawable.dice_3)
        4 -> (R.drawable.dice_4)
        5 -> (R.drawable.dice_5)
        else -> (R.drawable.dice_6)
    }
}
