package co.silencio.app.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Paleta "Petróleo y fucsia" sobre fondo blanco.
 * Contraste contra el blanco (WCAG):
 *  - Texto 0B1F1F: ~17:1 · Secundario 4D5E5E: ~6.6:1
 *  - Acción 0E7C7B con texto blanco: ~5.1:1 (AA)
 *  - Alerta E6007E como forma: ~4.5:1 · AlertaTexto B8005F: ~6.4:1
 *  - Contorno 8A8A86: ~3.4:1 (mínimo 3:1 para bordes de controles)
 *  - Divisor E3E8E8: solo decorativo, nunca como único límite de un control.
 */
object Colores {
    val Fondo = Color(0xFFFFFFFF)
    val Texto = Color(0xFF0B1F1F)
    val Secundario = Color(0xFF4D5E5E)
    val Guia = Color(0xFF687474) // texto guía de campos vacíos, ~4.8:1
    val Contorno = Color(0xFF8A8A86)
    val Divisor = Color(0xFFE3E8E8)
    val Accion = Color(0xFF0E7C7B)
    val SobreAccion = Color(0xFFFFFFFF)
    val Alerta = Color(0xFFE6007E)
    val AlertaTexto = Color(0xFFB8005F)
}
