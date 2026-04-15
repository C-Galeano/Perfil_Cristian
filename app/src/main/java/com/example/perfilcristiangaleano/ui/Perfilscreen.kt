package com.example.perfilcristiangaleano.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.perfilcristiangaleano.R
import com.example.myapplication.viewmodel.PerfilViewModel

@Composable
fun PerfilScreen(viewModel: PerfilViewModel = viewModel()) {

    val perfil = viewModel.perfil

    LazyColumn(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {

        // ── CABECERA CON FOTO Y NOMBRE ────────────────────────────────────────
        item {
            Box(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .background(
                        Brush.Companion.verticalGradient(
                            colors = listOf(Color(0xFF1565C0), Color(0xFF42A5F5))
                        )
                    )
                    .padding(24.dp),
                contentAlignment = Alignment.Companion.Center
            ) {
                Column(horizontalAlignment = Alignment.Companion.CenterHorizontally) {

                    // foto de perfil desde drawable
                    Image(
                        painter = painterResource(id = R.drawable.profile_photo),
                        contentDescription = "Foto de perfil",
                        contentScale = ContentScale.Companion.Crop,
                        modifier = Modifier.Companion
                            .size(120.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.Companion.height(12.dp))

                    Text(
                        text = perfil.nombre,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Companion.Bold,
                        color = Color.Companion.White
                    )

                    Text(
                        text = perfil.programa,
                        fontSize = 14.sp,
                        color = Color.Companion.White.copy(alpha = 0.9f)
                    )

                    Text(
                        text = perfil.semestre,
                        fontSize = 13.sp,
                        color = Color.Companion.White.copy(alpha = 0.8f)
                    )
                }
            }
        }

        // ── DESCRIPCION PERSONAL ──────────────────────────────────────────────
        item {
            Card(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.Companion.padding(16.dp)) {
                    Text(
                        text = "Sobre mí",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Companion.Bold,
                        color = Color(0xFF1565C0)
                    )
                    Spacer(modifier = Modifier.Companion.height(8.dp))
                    Text(
                        text = perfil.descripcion,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Companion.Justify,
                        color = Color(0xFF424242)
                    )
                }
            }
        }

        // ── INFORMACION ADICIONAL (INTERACTIVIDAD) ────────────────────────────
        item {
            Card(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.Companion.padding(16.dp)) {

                    Row(
                        modifier = Modifier.Companion.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Companion.CenterVertically
                    ) {
                        Text(
                            text = "Información adicional",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Companion.Bold,
                            color = Color(0xFF1565C0)
                        )
                        // boton para mostrar u ocultar — requerimiento interactividad
                        Button(
                            onClick = { viewModel.toggleInfoAdicional() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1565C0)
                            )
                        ) {
                            Text(
                                text = if (viewModel.mostrarInfoAdicional) "Ocultar" else "Mostrar",
                                fontSize = 12.sp
                            )
                        }
                    }

                    // animacion de mostrar/ocultar
                    AnimatedVisibility(
                        visible = viewModel.mostrarInfoAdicional,
                        enter = expandVertically(),
                        exit = shrinkVertically()
                    ) {
                        Column(modifier = Modifier.Companion.padding(top = 8.dp)) {
                            InfoRow(
                                icon = Icons.Default.Person,
                                label = "Edad",
                                valor = "${perfil.edad} años"
                            )
                            InfoRow(
                                icon = Icons.Default.LocationOn,
                                label = "Ciudad",
                                valor = perfil.ciudad
                            )
                            InfoRow(
                                icon = Icons.Default.Email,
                                label = "Correo",
                                valor = perfil.correo
                            )
                        }
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.Companion.height(16.dp)) }

        // ── HOBBIES ───────────────────────────────────────────────────────────
        item {
            SeccionExpandible(
                titulo = "Hobbies",
                icono = Icons.Default.Favorite,
                items = perfil.hobbies,
                expandida = viewModel.seccionExpandida == "hobbies",
                onToggle = { viewModel.toggleSeccion("hobbies") }
            )
        }

        // ── PASATIEMPOS ───────────────────────────────────────────────────────
        item {
            SeccionExpandible(
                titulo = "Pasatiempos",
                icono = Icons.Default.Star,
                items = perfil.pasatiempos,
                expandida = viewModel.seccionExpandida == "pasatiempos",
                onToggle = { viewModel.toggleSeccion("pasatiempos") }
            )
        }

        // ── DEPORTES ──────────────────────────────────────────────────────────
        item {
            SeccionExpandible(
                titulo = "Deportes y actividad física",
                icono = Icons.Default.PlayArrow,
                items = perfil.deportes,
                expandida = viewModel.seccionExpandida == "deportes",
                onToggle = { viewModel.toggleSeccion("deportes") }
            )
        }

        // ── INTERESES ─────────────────────────────────────────────────────────
        item {
            SeccionExpandible(
                titulo = "Intereses personales",
                icono = Icons.Default.Info,
                items = perfil.intereses,
                expandida = viewModel.seccionExpandida == "intereses",
                onToggle = { viewModel.toggleSeccion("intereses") }
            )
        }

        item { Spacer(modifier = Modifier.Companion.height(24.dp)) }
    }
}

// ── COMPONENTE REUTILIZABLE: FILA DE INFORMACION ──────────────────────────────
@Composable
fun InfoRow(icon: ImageVector, label: String, valor: String) {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.Companion.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFF1565C0),
            modifier = Modifier.Companion.size(20.dp)
        )
        Spacer(modifier = Modifier.Companion.width(8.dp))
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Companion.SemiBold,
            fontSize = 14.sp,
            color = Color(0xFF424242)
        )
        Text(
            text = valor,
            fontSize = 14.sp,
            color = Color(0xFF616161)
        )
    }
}

// ── COMPONENTE REUTILIZABLE: SECCION EXPANDIBLE ───────────────────────────────
@Composable
fun SeccionExpandible(
    titulo: String,
    icono: ImageVector,
    items: List<String>,
    expandida: Boolean,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.Companion.padding(16.dp)) {

            // cabecera de la seccion — clic para expandir/colapsar
            Row(
                modifier = Modifier.Companion.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Companion.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.Companion.CenterVertically) {
                    Icon(
                        imageVector = icono,
                        contentDescription = titulo,
                        tint = Color(0xFF1565C0),
                        modifier = Modifier.Companion.size(22.dp)
                    )
                    Spacer(modifier = Modifier.Companion.width(8.dp))
                    Text(
                        text = titulo,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Companion.Bold,
                        color = Color(0xFF1565C0)
                    )
                }
                IconButton(onClick = onToggle) {
                    Icon(
                        imageVector = if (expandida) Icons.Default.KeyboardArrowUp
                        else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expandida) "Colapsar" else "Expandir",
                        tint = Color(0xFF1565C0)
                    )
                }
            }

            // lista de items con animacion
            AnimatedVisibility(
                visible = expandida,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(modifier = Modifier.Companion.padding(top = 8.dp)) {
                    items.forEach { item ->
                        Row(
                            modifier = Modifier.Companion
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.Companion.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier.Companion
                                    .size(8.dp)
                                    .background(Color(0xFF42A5F5), CircleShape)
                            )
                            Spacer(modifier = Modifier.Companion.width(10.dp))
                            Text(
                                text = item,
                                fontSize = 14.sp,
                                color = Color(0xFF424242)
                            )
                        }
                    }
                }
            }
        }
    }
}