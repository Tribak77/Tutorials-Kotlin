package com.example.tuto7

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

class Prototype1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteDeVisite()
        }
    }
}

@Composable
fun CarteDeVisite() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nom et profession
        Text(
            text = "Ayoub Tribak",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Développeur Android",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        val context = LocalContext.current
        val callIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:+33612345678")
        }
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:tribak@example.com")
        }
        val websiteIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://github.com/Tribak77/Tutorials-Kotlin")
        }
        ContactInfo(
            label = "Téléphone :",
            value = "+33 6 12 34 56 78",
            onClick = { context.startActivity(callIntent)  }
        )
        ContactInfo(
            label = "Email :",
            value = "johndoe@example.com",
            onClick = {  context.startActivity(emailIntent) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Bouton pour site web
        Button(onClick = { context.startActivity(websiteIntent) }) {
            Text("Visiter mon site")
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Text(text = "$label ", fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.Blue)
    }
}

@Preview(showBackground = true)
@Composable
fun CarteDeVisitePreview() {
    CarteDeVisite()
}