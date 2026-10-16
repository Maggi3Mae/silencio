package co.silencio.app.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import co.silencio.app.R

// Un archivo fijo por peso (generados a partir de las fuentes variables originales, licencia OFL).
// Así Android aplica siempre el peso correcto.
val SpaceGrotesk = FontFamily(
    Font(R.font.space_grotesk_regular, FontWeight.Normal),
    Font(R.font.space_grotesk_medium, FontWeight.Medium),
    Font(R.font.space_grotesk_bold, FontWeight.Bold),
)

val JetBrainsMono = FontFamily(
    Font(R.font.jetbrains_mono_regular, FontWeight.Normal),
    Font(R.font.jetbrains_mono_medium, FontWeight.Medium),
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
