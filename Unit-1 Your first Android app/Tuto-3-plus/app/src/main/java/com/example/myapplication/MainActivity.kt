package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.data.EmptyGroup.data
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteractiveButtonsApp()
        }
    }
}

@Composable
fun InteractiveButtonsApp() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OpenWebsiteButton()
                SendEmailButton()
                DialPhoneNumberButton()
            }
        }
    }
}

@Composable
fun OpenWebsiteButton() {
    val contex = LocalContext.current
    Button(onClick = {
        val websiteIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://github.com/Tribak77"))
        contex.startActivity(websiteIntent)
    }) {
        Text("Ouvrir un site web")
    }
}

@Composable
fun SendEmailButton() {
    val contex = LocalContext.current
    Button(onClick = {
        val mailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data =  Uri.parse("mailto:test@example.com")
            putExtra(Intent.EXTRA_SUBJECT, "Sujet de l'email")
        }
        contex.startActivity(mailIntent)
    }) {
        Text("Envoyer un email")
    }
}

@Composable
fun DialPhoneNumberButton() {
    val contex = LocalContext.current
    Button(onClick = {
        val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+123456789"))
        contex.startActivity(phoneIntent)
    }) {
        Text("Appeler un numéro")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InteractiveButtonsApp()
}