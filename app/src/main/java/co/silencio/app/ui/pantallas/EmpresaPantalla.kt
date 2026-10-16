package co.silencio.app.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.silencio.app.datos.DatosEjemplo
import co.silencio.app.ui.componentes.BotonIcono
import co.silencio.app.ui.componentes.BotonPrincipal
import co.silencio.app.ui.componentes.BotonSecundario
import co.silencio.app.ui.componentes.Caja
import co.silencio.app.ui.componentes.Divisor
import co.silencio.app.ui.componentes.Espacio
import co.silencio.app.ui.componentes.EtiquetaSeccion
import co.silencio.app.ui.componentes.Iconos
import co.silencio.app.ui.componentes.Marca
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.Tipos

@Composable
fun EmpresaPantalla(
    alVolver: () -> Unit,
    alGenerarSolicitud: () -> Unit,
    alGenerarQueja: () -> Unit,
) {
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
                Text("Empresa · cobranza", style = Tipos.Etiqueta)
            }

            Espacio(20.dp)
            Text(
                DatosEjemplo.EMPRESA,
                style = Tipos.Titulo.copy(fontSize = 34.sp, lineHeight = 36.sp),
                modifier = Modifier.semantics { heading() },
            )
            Text(DatosEjemplo.EMPRESA_ORIGEN, style = Tipos.Etiqueta, modifier = Modifier.padding(top = 8.dp))

            Espacio(22.dp)
            Caja(Modifier.fillMaxWidth(), relleno = 14.dp) {
                EtiquetaSeccion("01/Estado del caso")
                Espacio(10.dp)
                Row(
                    Modifier.semantics {
                        contentDescription =
                            "Paso ${DatosEjemplo.PASO_ACTUAL} de ${DatosEjemplo.PASOS_TOTALES}"
                    },
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    repeat(DatosEjemplo.PASOS_TOTALES) { i ->
                        val hecho = i < DatosEjemplo.PASO_ACTUAL
                        val base = Modifier.weight(1f).height(8.dp)
                        Box(if (hecho) base.background(Colores.Accion) else base.border(1.dp, Colores.Contorno))
                    }
                }
                Row(
                    Modifier.fillMaxWidth().padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(DatosEjemplo.NOMBRE_PASO, style = Tipos.ItemPequeno)
                    Text(
                        "paso ${DatosEjemplo.PASO_ACTUAL} de ${DatosEjemplo.PASOS_TOTALES}",
                        style = Tipos.Etiqueta,
                    )
                }
            }

            Espacio(22.dp)
            EtiquetaSeccion("02/Incumplimientos · ${DatosEjemplo.incumplimientos.size}")
            Espacio(8.dp)
            Caja(Modifier.fillMaxWidth(), alerta = true) {
                DatosEjemplo.incumplimientos.forEachIndexed { i, inc ->
                    if (i > 0) Divisor()
                    Row(
                        Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Marca(incumple = true, Modifier.padding(top = 5.dp))
                        Column {
                            Text(inc.titulo, style = Tipos.ItemPequeno)
                            Text(
                                inc.detalle,
                                style = Tipos.Etiqueta.copy(fontSize = 11.sp),
                                modifier = Modifier.padding(top = 3.dp),
                            )
                        }
                    }
                }
            }

            Espacio(22.dp)
            EtiquetaSeccion("03/Historial")
            Espacio(4.dp)
            DatosEjemplo.historial.forEachIndexed { i, h ->
                if (i > 0) Divisor()
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(h.descripcion, style = Tipos.Dato.copy(fontSize = 12.sp))
                    Text(h.hora, style = Tipos.Etiqueta)
                }
            }
            Espacio(20.dp)
        }

        Column(
            Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            BotonPrincipal("Generar solicitud de supresión", alGenerarSolicitud)
            BotonSecundario("Borrador de queja ante la SIC", alGenerarQueja, Modifier.fillMaxWidth()) {
                Icon(Iconos.Flecha, contentDescription = null, tint = Colores.Accion)
            }
        }
    }
}
