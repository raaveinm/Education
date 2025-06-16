package com.raaveinm.learning.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.TipsAndUpdates
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raaveinm.learning.R
import com.raaveinm.learning.ui.layouts.EditNumberField
import com.raaveinm.learning.ui.layouts.SwitchLayout
import com.raaveinm.learning.ui.viewmodel.TipCalculatorViewModel

@Composable
fun TipCalculatorScreen (
    modifier: Modifier = Modifier,
    tipViewModel: TipCalculatorViewModel = viewModel()
){
    val billAmount: String = stringResource(R.string.bill_amount)
    val tipPercentage: String = stringResource(R.string.how_was_the_service)

    Column (modifier = modifier
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text (
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            text = tipViewModel.amountInput.value,
            icon = Icons.Outlined.AttachMoney,
            onValueChange = { tipViewModel.onAmountInputChanged(it) },
            label = billAmount,
            action = ImeAction.Next
        )

        EditNumberField(
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth(),
            text = tipViewModel.percentageInput.value,
            icon = Icons.Outlined.TipsAndUpdates,
            label = tipPercentage,
            onValueChange = { tipViewModel.onPercentageInputChanged(it) },
            action = ImeAction.Done
        )

        SwitchLayout(
            modifier = Modifier.padding(bottom = 32.dp),
            text = R.string.round_up_tip,
            isChecked = tipViewModel.roundUp.value,
            onCheckupChanged = { tipViewModel.roundUpChanged(it) }
        )

        Text(
            text = stringResource(R.string.tip_amount, tipViewModel.tip.value),
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Preview(
    device = "id:pixel_9_pro",
    wallpaper = Wallpapers.NONE, showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
fun TipCalculatorLayoutPreview () {
    TipCalculatorScreen()
}