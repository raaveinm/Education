package com.raaveinm.learning

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.raaveinm.learning.ui.screen.TipCalculatorScreen
import com.raaveinm.learning.ui.theme.LearningTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun calculateTwentyPercent() {
        composeTestRule.setContent {
            LearningTheme {
                TipCalculatorScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("100")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(20)
        val expectedText = composeTestRule.activity.getString(R.string.tip_amount, expectedTip)
        composeTestRule.onNodeWithText(expectedText).assertExists()
    }
}