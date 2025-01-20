package com.example.folkedex.ui.settings

import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.folkedex.R
import com.example.folkedex.data.FavoritesHelper
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    val favoriteManager = remember { FavoritesHelper(context) }
    val scope = rememberCoroutineScope()
    var showConfirmationDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Settings for FolkeDex", style = MaterialTheme.typography.headlineLarge) },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Transparent)
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.flogo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .offset(x = 120.dp, y = (-50).dp)
                        .alpha(0.2f),
                    contentScale = ContentScale.Fit
                )


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(
                        onClick = {
                            scope.launch {
                                val message = exportFavoritesToFile(context, favoriteManager.getFavorites().toList())
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "Export Favorites",
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center
                        )
                    }


                    Button(
                        onClick = { showConfirmationDialog.value = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF44336),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "Reset Favorites",
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                if (showConfirmationDialog.value) {
                    AlertDialog(
                        onDismissRequest = { showConfirmationDialog.value = false },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    favoriteManager.clearFavorites()
                                    showConfirmationDialog.value = false
                                    Toast.makeText(context, "Favorites cleared!", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Text("Confirm", color = Color.Red)
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showConfirmationDialog.value = false }) {
                                Text("Cancel")
                            }
                        },
                        title = { Text("Reset your favorites") },
                        text = { Text("Are you sure you want to reset all your favorites? This action cannot be undone.") }
                    )
                }
            }
        }
    )
}

// Helper function to export favorites to a file
fun exportFavoritesToFile(context: Context, favorites: List<String>): String {
    if (favorites.isEmpty()) {
        return "You have no favorites to export."
    }

    val exportDir = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "Folkedex")
    if (!exportDir.exists()) {
        exportDir.mkdirs()
    }

    val exportFile = File(exportDir, "favorites.txt")
    FileOutputStream(exportFile).use { output ->
        favorites.forEach { favorite ->
            output.write("$favorite\n".toByteArray())
        }
    }

    return "Favorites exported to: ${exportFile.absolutePath}"
}
