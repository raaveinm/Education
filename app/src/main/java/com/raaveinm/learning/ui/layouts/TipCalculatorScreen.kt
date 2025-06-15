package com.raaveinm.learning.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.raaveinm.learning.ui.viewmodel.TipCalculatorViewModel

@Composable
fun TipCalculatorScreen (
    modifier: Modifier = Modifier,
    tipViewModel: TipCalculatorViewModel = viewModel()
){
    val billAmount: String = stringResource(R.string.bill_amount)

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
            onValueChange = { tipViewModel.onAmountInputChanged(it) },
            label = billAmount
        )

        Text(
            text = stringResource(R.string.tip_amount, tipViewModel.tip.value),
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Preview(device = "id:pixel_5",
    wallpaper = Wallpapers.NONE, showBackground = true, showSystemUi = false
)
@Composable
fun TipCalculatorLayoutPreview () {
    TipCalculatorScreen()
}