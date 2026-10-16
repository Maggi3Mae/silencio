package co.silencio.app.ui.pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.silencio.app.ui.componentes.BotonIcono
import co.silencio.app.ui.componentes.BotonPrincipal
import co.silencio.app.ui.componentes.Campo
import co.silencio.app.ui.componentes.Espacio
import co.silencio.app.ui.componentes.EtiquetaSeccion
import co.silencio.app.ui.componentes.Iconos
import co.silencio.app.ui.componentes.Marca
import co.silencio.app.ui.componentes.Segmentado
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.Tipos
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

private val ES_CO = Locale.forLanguageTag("es-CO")
private val FORMATO_FECHA = DateTimeFormatter.ofPattern("EEE d MMM", ES_CO) // "vie 16 oct"
private val FORMATO_HORA = DateTimeFormatter.ofPattern("H:mm", ES_CO)

@Composable
fun RegistrarPantalla(alVolver: () -> Unit, alGuardar: () -> Unit) {
    // Fecha y hora arrancan con el momento actual; el resto vacío. Se guardan de verdad en la entrega 2.
    val ahora = remember { LocalDateTime.now() }
    var empresa by rememberSaveable { mutableStateOf("") }
    var origen by rememberSaveable { mutableStateOf("") }
    var canal by rememberSaveable { mutableStateOf("Llamada") }
    var tipo by rememberSaveable { mutableStateOf("Cobranza") }
    var fecha by rememberSaveable { mutableStateOf(ahora.format(FORMATO_FECHA).replace(".", "")) }
    var hora by rememberSaveable { mutableStateOf(ahora.format(FORMATO_HORA)) }
    var autorizacion by rememberSaveable { mutableStateOf("No sé") }

    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
        ) {
            Row(
                Modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                BotonIcono(Iconos.Atras, "Volver", alVolver)
                Text("Nuevo contacto", style = Tipos.Etiqueta)
            }

            Espacio(20.dp)
            Text("¿Quién te\ncontactó?", style = Tipos.Titulo, modifier = Modifier.semantics { heading() })
            Espacio(22.dp)

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Campo("01/Empresa", empresa, { empresa = it }, guia = "Nombre de la empresa")
                Campo(
                    "02/Número o correo", origen, { origen = it },
                    guia = "Número o correo de origen",
                    estilo = Tipos.Dato.copy(fontSize = 15.sp),
                )

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    EtiquetaSeccion("03/Canal")
                    Segmentado(listOf("Llamada", "SMS", "WhatsApp", "Correo"), canal, { canal = it })
                }
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    EtiquetaSeccion("04/Tipo")
                    Segmentado(listOf("Cobranza", "Publicidad"), tipo, { tipo = it })
                }

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Campo("05/Fecha", fecha, { fecha = it }, Modifier.weight(1f), estilo = Tipos.Dato.copy(fontSize = 14.sp))
                    Campo("06/Hora", hora, { hora = it }, Modifier.weight(1f), estilo = Tipos.Dato.copy(fontSize = 14.sp))
                }

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    EtiquetaSeccion("07/¿Le diste autorización?")
                    Segmentado(listOf("Sí", "No", "No sé"), autorizacion, { autorizacion = it })
                }
            }
            Espacio(20.dp)
        }

        // Aviso de ejemplo. El motor de reglas real llega en la entrega 3.
        Row(
            Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .border(1.5.dp, Colores.Alerta)
                .padding(horizontal = 14.dp, vertical = 12.dp)
                .semantics { liveRegion = LiveRegionMode.Polite },
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Marca(incumple = true, Modifier.padding(top = 4.dp))
            Column {
                Text(
                    "1 INCUMPLIMIENTO DETECTADO",
                    style = Tipos.Etiqueta.copy(color = Colores.AlertaTexto, fontWeight = FontWeight.Medium, fontSize = 11.sp),
                )
                Text("Cobranza en domingo (Ley 2300)", style = Tipos.ItemPequeno)
            }
        }

        BotonPrincipal(
            "Guardar",
            alGuardar,
            Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 24.dp),
        )
    }
}
