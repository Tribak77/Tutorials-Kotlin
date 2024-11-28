package com.example.tuto7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuto7.ui.theme.Tuto7Theme
//import com.example.todoapp.R // Assurez-vous d'importer correctement votre package

// Modèle de données représentant un élément de la liste
data class ListItem(val title: String, val imageRes: Int)

// Liste de données factices pour l'exemple
val sampleItems = listOf(
    ListItem("Tâche 1", R.drawable.ic_launcher_background),  // Remplacez par des icônes appropriées
    ListItem("Tâche 2", R.drawable.ic_launcher_background),
    ListItem("Tâche 3", R.drawable.ic_launcher_background)
)

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ListScreen(items = sampleItems)
            }
        }
    }
}

@Composable
fun ListScreen(items: List<ListItem>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(items) { item ->
            ListItemRow(item = item)
            Divider() // Séparateur entre les éléments
        }
    }
}

@Composable
fun ListItemRow(item: ListItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Action à exécuter lors du clic */ }
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        // Affiche l'image
        val image: Painter = painterResource(id = item.imageRes)
        Image(
            painter = image,
            contentDescription = item.title,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))  // Espacement entre l'image et le texte
        // Affiche le texte
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListScreen() {
    MaterialTheme {
        ListScreen(items = sampleItems)
    }
}