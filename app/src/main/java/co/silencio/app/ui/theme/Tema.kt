package co.silencio.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * Las pantallas usan Colores y Tipos directamente. MaterialTheme se configura solo para
 * que los efectos del sistema (selección de texto, ripple) usen la misma paleta, sin esquinas.
 */
@Composable
fun TemaSilencio(contenido: @Composable () -> Unit) {
    val esquemas = lightColorScheme(
        primary = Colores.Accion,
        onPrimary = Colores.SobreAccion,
        secondary = Colores.Accion,
        background = Colores.Fondo,
        onBackground = Colores.Texto,
        surface = Colores.Fondo,
        onSurface = Colores.Texto,
        error = Colores.Alerta,
        outline = Colores.Contorno,
    )
    val sinEsquinas = RoundedCornerShape(0.dp)
    MaterialTheme(
        colorScheme = esquemas,
        shapes = Shapes(
            extraSmall = sinEsquinas, small = sinEsquinas, medium = sinEsquinas,
            large = sinEsquinas, extraLarge = sinEsquinas,
        ),
        content = contenido,
    )
}
