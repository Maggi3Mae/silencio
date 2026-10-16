package co.silencio.app.ui.pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import co.silencio.app.datos.DatosEjemplo
import co.silencio.app.ui.componentes.BotonIcono
import co.silencio.app.ui.componentes.BotonPrincipal
import co.silencio.app.ui.componentes.BotonSecundario
import co.silencio.app.ui.componentes.Caja
import co.silencio.app.ui.componentes.Divisor
import co.silencio.app.ui.componentes.EtiquetaSeccion
import co.silencio.app.ui.componentes.Espacio
import co.silencio.app.ui.componentes.Iconos
import co.silencio.app.ui.componentes.Marca
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.Tipos

@Composable
fun InicioPantalla(
    alRegistrar: () -> Unit,
    alAbrirEmpresa: () -> Unit,
    alVerPlazos: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
        ) {
            Row(
                Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("SILENCIO", style = Tipos.Marca)
                BotonIcono(Iconos.Menu, "Menú", onClick = {})
            }

            Espacio(36.dp)
            EtiquetaSeccion("01/Octubre")
            Espacio(10.dp)
            Text("Que dejen\nde fregar.", style = Tipos.TituloGrande, modifier = Modifier.semantics { heading() })

            Espacio(32.dp)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Resumen(DatosEjemplo.CONTACTOS_MES, "contactos", alerta = false, Modifier.weight(1f))
                Resumen(DatosEjemplo.INCUMPLIMIENTOS_MES, "incumplim.", alerta = true, Modifier.weight(1f))
                Resumen(DatosEjemplo.EMPRESAS, "empresas", alerta = false, Modifier.weight(1f))
            }

            Espacio(40.dp)
            EtiquetaSeccion("02/Recientes")
            Espacio(8.dp)
            Caja(Modifier.fillMaxWidth()) {
                DatosEjemplo.recientes.forEachIndexed { i, c ->
                    if (i > 0) Divisor()
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable(role = Role.Button, onClick = alAbrirEmpresa)
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                    ) {
                        Marca(c.incumple)
                        Column(Modifier.weight(1f)) {
                            Text(c.empresa, style = Tipos.Item)
                            Text(c.detalle, style = Tipos.Apoyo, modifier = Modifier.padding(top = 2.dp))
                        }
                        Text(c.dia, style = Tipos.Etiqueta)
                    }
                }
            }
            Espacio(24.dp)
        }

        Column(
            Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            BotonPrincipal("Registrar contacto", alRegistrar, icono = Iconos.Mas)
            BotonSecundario("Ver plazos pendientes", alVerPlazos, Modifier.fillMaxWidth()) {
                Text("${DatosEjemplo.PLAZOS_PENDIENTES}", style = Tipos.Dato.copy(color = Colores.Accion))
            }
        }
    }
}

@Composable
private fun Resumen(valor: Int, etiqueta: String, alerta: Boolean, modifier: Modifier) {
    Column(
        modifier
            .border(if (alerta) 1.5.dp else 1.dp, if (alerta) Colores.Alerta else Colores.Contorno)
            .padding(horizontal = 12.dp, vertical = 14.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            if (alerta) Marca(incumple = true)
            Text("$valor", style = Tipos.Numero)
        }
        Text(etiqueta, style = Tipos.Etiqueta.copy(fontSize = Tipos.Etiqueta.fontSize * 0.92f), modifier = Modifier.padding(top = 8.dp))
    }
}
