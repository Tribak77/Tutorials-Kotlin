package com.example.tuto7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Champ de saisie
        var amountInput by remember { mutableStateOf("") }
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Montant de l'addition") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Slider
        var tipPercentage by remember { mutableStateOf(15f) }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Pourcentage : ${tipPercentage.toInt()}%")
            Slider(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                valueRange = 0f..30f,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Résultats
        val amount = amountInput.toFloatOrNull() ?: 0f
        val tipAmount = (amount * tipPercentage / 100)
        val totalAmount = amount + tipAmount

        Text("Pourboire : %.2f MAD".format(tipAmount))
        Text("Total : %.2f MAD".format(totalAmount))
    }
}


@Preview(showBackground = true)
@Composable
fun TipCalculatorAppPreview() {
    TipCalculatorApp()
}