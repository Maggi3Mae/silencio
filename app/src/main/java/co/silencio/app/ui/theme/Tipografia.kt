@file:OptIn(ExperimentalTextApi::class)

package co.silencio.app.ui.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import co.silencio.app.R

// Ambas fuentes son variables (un solo archivo con todos los pesos) y tienen licencia OFL.
private fun pesoVariable(recurso: Int, peso: Int) = Font(
    resId = recurso,
    weight = FontWeight(peso),
    variationSettings = FontVariation.Settings(FontVariation.weight(peso)),
)

val SpaceGrotesk = FontFamily(
    pesoVariable(R.font.space_grotesk, 400),
    pesoVariable(R.font.space_grotesk, 500),
    pesoVariable(R.font.space_grotesk, 700),
)

val JetBrainsMono = FontFamily(
    pesoVariable(R.font.jetbrains_mono, 400),
    pesoVariable(R.font.jetbrains_mono, 500),
)

object Tipos {
    val TituloGrande = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Bold,
        fontSize = 44.sp, lineHeight = 44.sp, letterSpacing = (-0.035).em, color = Colores.Texto,
    )
    val Titulo = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Bold,
        fontSize = 32.sp, lineHeight = 34.sp, letterSpacing = (-0.03).em, color = Colores.Texto,
    )
    val Numero = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Bold,
        fontSize = 32.sp, lineHeight = 32.sp, letterSpacing = (-0.03).em, color = Colores.Texto,
    )
    val Boton = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = Colores.Texto,
    )
    val BotonSecundario = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Colores.Texto,
    )
    val Item = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Medium, fontSize = 17.sp, color = Colores.Texto,
    )
    val ItemPequeno = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Medium, fontSize = 15.sp, color = Colores.Texto,
    )
    val Cuerpo = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 21.sp,
        color = Colores.Texto,
    )
    val Apoyo = TextStyle(
        fontFamily = SpaceGrotesk, fontWeight = FontWeight.Normal, fontSize = 13.sp, color = Colores.Secundario,
    )
    val Etiqueta = TextStyle(
        fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 12.sp, color = Colores.Secundario,
    )
    val Marca = TextStyle(
        fontFamily = JetBrainsMono, fontWeight = FontWeight.Medium, fontSize = 13.sp,
        letterSpacing = 0.12.em, color = Colores.Texto,
    )
    val Dato = TextStyle(
        fontFamily = JetBrainsMono, fontWeight = FontWeight.Normal, fontSize = 13.sp, color = Colores.Texto,
    )
}
