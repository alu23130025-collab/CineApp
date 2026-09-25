package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examen.ui.theme.ExamenTheme

data class Pelicula(
    val nombre: String,
    val imagen: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GaleriaCineScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GaleriaCineScreen(modifier: Modifier = Modifier) {

    // Lista con nombre + imagen
    val listaDePeliculas = listOf(
        Pelicula("Castillo Vagabundo", R.drawable.pelicula1),
        Pelicula("Maze Runner", R.drawable.pelicula2),
        Pelicula("Castillo Infinito", R.drawable.pelicula3),
        Pelicula("The Truman show", R.drawable.pelicula4),
        Pelicula("Get Out", R.drawable.pelicula5),
        Pelicula("Sexto Sentido", R.drawable.pelicula6),
        Pelicula("Shutter Island", R.drawable.pelicula7),



        )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Cartelera Cine - Torreón",
                style = MaterialTheme.typography.headlineSmall
            )
        }


        items(listaDePeliculas) { pelicula ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = pelicula.imagen),
                        contentDescription = pelicula.nombre,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))


                    Text(
                        text = pelicula.nombre,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}