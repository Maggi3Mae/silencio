package co.silencio.app.ui.pantallas

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.silencio.app.datos.DatosEjemplo
import co.silencio.app.ui.componentes.BotonIcono
import co.silencio.app.ui.componentes.BotonPrincipal
import co.silencio.app.ui.componentes.BotonSecundario
import co.silencio.app.ui.componentes.Caja
import co.silencio.app.ui.componentes.Espacio
import co.silencio.app.ui.componentes.EtiquetaSeccion
import co.silencio.app.ui.componentes.Iconos
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.Tipos

@Composable
fun DocumentoPantalla(alVolver: () -> Unit, alMarcarEnviada: () -> Unit) {
    val portapapeles = LocalClipboardManager.current
    val contexto = LocalContext.current

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
                Text(DatosEjemplo.EMPRESA, style = Tipos.Etiqueta)
            }

            Espacio(20.dp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .border(1.5.dp, Colores.Accion),
            ) {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .background(Colores.Accion)
                        .padding(horizontal = 18.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        "${DatosEjemplo.DIAS_RESTANTES}",
                        style = Tipos.TituloGrande.copy(color = Colores.SobreAccion),
                    )
                }
                Column(Modifier.padding(horizontal = 14.dp, vertical = 12.dp)) {
                    Text("días hábiles para que respondan", style = Tipos.ItemPequeno)
                    Text(
                        DatosEjemplo.PLAZO_DETALLE,
                        style = Tipos.Etiqueta.copy(fontSize = 11.sp),
                        modifier = Modifier.padding(top = 4.dp),
                    )
                }
            }

            Espacio(24.dp)
            EtiquetaSeccion("01/Solicitud de supresión de datos")
            Espacio(8.dp)
            Caja(Modifier.fillMaxWidth(), relleno = 20.dp) {
                Text(DatosEjemplo.solicitud, style = Tipos.Cuerpo.copy(fontSize = 13.sp, lineHeight = 20.sp))
            }
            Espacio(20.dp)
        }

        Row(
            Modifier.padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            BotonSecundario(
                "Copiar texto",
                onClick = {
                    portapapeles.setText(AnnotatedString(DatosEjemplo.solicitud))
                    Toast.makeText(contexto, "Texto copiado", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.weight(1f),
            )
            BotonSecundario(
                "Descargar PDF",
                // El PDF real llega en la entrega 5.
                onClick = { Toast.makeText(contexto, "Disponible en la entrega 5", Toast.LENGTH_SHORT).show() },
                modifier = Modifier.weight(1f),
            )
        }
        BotonPrincipal(
            "Marcar como enviada",
            alMarcarEnviada,
            Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 24.dp),
            icono = Iconos.Check,
        )
    }
}
