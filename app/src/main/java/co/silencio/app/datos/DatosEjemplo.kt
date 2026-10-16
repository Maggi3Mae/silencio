package co.silencio.app.datos

/**
 * Datos de ejemplo para la entrega 1 (esqueleto navegable).
 * En la entrega 2 se reemplazan por la base de datos local.
 */
data class ContactoReciente(
    val empresa: String,
    val detalle: String,
    val dia: String,
    val incumple: Boolean,
)

data class Incumplimiento(val titulo: String, val detalle: String)

data class EntradaHistorial(val descripcion: String, val hora: String)

object DatosEjemplo {
    const val CONTACTOS_MES = 23
    const val INCUMPLIMIENTOS_MES = 7
    const val EMPRESAS = 4
    const val PLAZOS_PENDIENTES = 2

    val recientes = listOf(
        ContactoReciente("Cobranzas XYZ", "Llamada en domingo", "dom", incumple = true),
        ContactoReciente("Telefonía ABC", "SMS pese al RNE", "sáb", incumple = true),
        ContactoReciente("Banco Ejemplo", "Correo · sin incumplimientos", "vie", incumple = false),
    )

    const val EMPRESA = "Cobranzas XYZ"
    const val EMPRESA_ORIGEN = "601 555 0142 · 6 contactos"
    const val PASO_ACTUAL = 2
    const val PASOS_TOTALES = 5
    const val NOMBRE_PASO = "Solicitud enviada"

    val incumplimientos = listOf(
        Incumplimiento("Llamada en domingo", "12 oct · 9:14 · horario"),
        Incumplimiento("Dos contactos el mismo día", "14 oct · 10:20 y 16:05 · frecuencia"),
        Incumplimiento("Llamada y SMS la misma semana", "13–15 oct · varios canales"),
    )

    val historial = listOf(
        EntradaHistorial("15 oct · SMS", "11:30"),
        EntradaHistorial("14 oct · Llamada", "16:05"),
        EntradaHistorial("14 oct · Llamada", "10:20"),
    )

    const val DIAS_RESTANTES = 11
    const val PLAZO_DETALLE = "enviada 14 oct · vence 30 oct"

    val solicitud = """
        Bogotá, 14 de octubre de 2026

        Señores
        Cobranzas XYZ

        Asunto: solicitud de supresión de mis datos personales (Ley 1581 de 2012)

        Yo, [TU NOMBRE], identificada con cédula [NÚMERO], solicito que eliminen mis datos de contacto de sus bases de datos y dejen de contactarme por cualquier canal.

        Anexo el registro de contactos recibidos, entre ellos una llamada el domingo 12 de octubre a las 9:14.
    """.trimIndent()
}
