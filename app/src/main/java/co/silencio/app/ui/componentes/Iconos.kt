package co.silencio.app.ui.componentes

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

/** Íconos de trazo propios (24x24), para no depender de librerías de íconos. */
object Iconos {
    private fun icono(nombre: String, trazo: PathBuilder.() -> Unit) =
        ImageVector.Builder(
            name = nombre, defaultWidth = 24.dp, defaultHeight = 24.dp,
            viewportWidth = 24f, viewportHeight = 24f,
        ).path(
            stroke = SolidColor(Color.Black),
            strokeLineWidth = 1.8f,
            strokeLineCap = StrokeCap.Square,
            strokeLineJoin = StrokeJoin.Miter,
            pathBuilder = trazo,
        ).build()

    val Mas = icono("mas") {
        moveTo(12f, 5f); lineTo(12f, 19f)
        moveTo(5f, 12f); lineTo(19f, 12f)
    }

    val Flecha = icono("flecha") {
        moveTo(5f, 12f); lineTo(19f, 12f)
        moveTo(13f, 6f); lineTo(19f, 12f); lineTo(13f, 18f)
    }

    val Atras = icono("atras") {
        moveTo(15f, 5f); lineTo(8f, 12f); lineTo(15f, 19f)
    }

    val Menu = icono("menu") {
        moveTo(4f, 7f); lineTo(20f, 7f)
        moveTo(4f, 12f); lineTo(20f, 12f)
        moveTo(4f, 17f); lineTo(20f, 17f)
    }

    val Check = icono("check") {
        moveTo(5f, 12f); lineTo(10f, 17f); lineTo(19f, 7f)
    }
}
