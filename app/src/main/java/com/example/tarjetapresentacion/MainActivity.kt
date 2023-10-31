package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetapresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetapresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val imageFondo = painterResource(id = R.drawable.fondo)
    val imageFotoPerfil = painterResource(id = R.drawable.imagenperfilpixel1)
    val imageNombre = painterResource(id = R.drawable.nombrevictor)
    val imageTelefono = painterResource(id = R.drawable.telefono)
    val imageCorreo = painterResource(id = R.drawable.correo)
    val imageArtStation = painterResource(id = R.drawable.artstation)
    val imageInstagram = painterResource(id = R.drawable.instagram)
    val imageQrCv = painterResource(id = R.drawable.qrcv)

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = imageFondo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imageFotoPerfil,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Image(
                painter = imageNombre,
                contentDescription = null,
                modifier = modifier
                    .width(300.dp)
                    .height(100.dp)
                    .offset(y = (-22).dp)
            )

            ContactInfoRow(imageTelefono, imageCorreo)

            ContactInfoRow(imageArtStation, imageInstagram)

            BotonTextoImagen(imageQrCv,modifier = Modifier
                .offset(y = (-20).dp))
        }
    }
}

@Composable
fun ContactInfoRow(imageLeft: Painter, imageRight: Painter) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ContactInfo(image = imageLeft)
        ContactInfo(image = imageRight)
    }
}

@Composable
fun ContactInfo(image: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(180.dp, 80.dp)
                .offset(y = (-10).dp)
        )
    }
}

@Composable
fun BotonTextoImagen(image: Painter, modifier: Modifier = Modifier) {
    var showImage by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showImage) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        } else {
            Text(
                text = "Técnico Superior en Animación 3D, Juegos y Entornos Interactivos.\n\n" +
                        "Tecnico Superior en Desarrollo de Aplicaciones Multiplataforma.",
                fontSize = 20.sp,
                textAlign = TextAlign.Justify,
                color = Color.Yellow,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showImage = !showImage }

        ) {
            Text(text = if (showImage) "Curriculum Vitae" else "Títulos",
                color = Color.Black
                )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetapresentacionTheme {
        Greeting()
    }
}