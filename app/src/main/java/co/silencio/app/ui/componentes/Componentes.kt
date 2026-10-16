package co.silencio.app.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.Tipos

/** Etiqueta numerada en monoespaciada, por ejemplo "01/Recientes". */
@Composable
fun EtiquetaSeccion(texto: String, modifier: Modifier = Modifier) {
    Text(texto, style = Tipos.Etiqueta, modifier = modifier.semantics { heading() })
}

/** Botón principal: relleno petróleo, texto blanco, 60dp de alto. */
@Composable
fun BotonPrincipal(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icono: ImageVector? = Iconos.Flecha,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Colores.Accion)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(texto, style = Tipos.Boton.copy(color = Colores.SobreAccion), modifier = Modifier.weight(1f))
        if (icono != null) Icon(icono, contentDescription = null, tint = Colores.SobreAccion)
    }
}

/** Botón secundario: solo contorno y texto en petróleo. */
@Composable
fun BotonSecundario(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    final: @Composable (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .height(52.dp)
            .background(Colores.Fondo)
            .border(1.5.dp, Colores.Accion)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (final == null) Arrangement.Center else Arrangement.SpaceBetween,
    ) {
        Text(texto, style = Tipos.BotonSecundario.copy(color = Colores.Accion))
        final?.invoke()
    }
}

/** Botón cuadrado de 44dp solo con ícono (atrás, menú). */
@Composable
fun BotonIcono(icono: ImageVector, descripcion: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .border(1.dp, Colores.Contorno)
            .clickable(role = Role.Button, onClick = onClick)
            .semantics { contentDescription = descripcion },
        contentAlignment = Alignment.Center,
    ) {
        Icon(icono, contentDescription = null, tint = Colores.Texto, modifier = Modifier.size(20.dp))
    }
}

/** Caja con contorno. Por defecto gris; con alerta = true, borde fucsia más grueso. */
@Composable
fun Caja(
    modifier: Modifier = Modifier,
    alerta: Boolean = false,
    relleno: Dp = 0.dp,
    contenido: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .border(if (alerta) 1.5.dp else 1.dp, if (alerta) Colores.Alerta else Colores.Contorno)
            .padding(relleno),
        content = contenido,
    )
}

/** Cuadrito de 10dp: fucsia relleno si hay incumplimiento, solo contorno si no. */
@Composable
fun Marca(incumple: Boolean, modifier: Modifier = Modifier) {
    val base = modifier.size(10.dp)
    Box(if (incumple) base.background(Colores.Alerta) else base.border(1.5.dp, Colores.Contorno))
}

@Composable
fun Divisor() {
    Box(Modifier.fillMaxWidth().height(1.dp).background(Colores.Divisor))
}

/** Grupo de opciones excluyentes (canal, tipo...). La elegida va rellena en petróleo. */
@Composable
fun Segmentado(
    opciones: List<String>,
    seleccion: String,
    onSeleccion: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth().selectableGroup(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        opciones.forEach { opcion ->
            val elegida = opcion == seleccion
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .background(if (elegida) Colores.Accion else Colores.Fondo)
                    .border(
                        if (elegida) 1.5.dp else 1.dp,
                        if (elegida) Colores.Accion else Colores.Contorno,
                    )
                    .selectable(selected = elegida, role = Role.RadioButton, onClick = { onSeleccion(opcion) }),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    opcion,
                    style = Tipos.Cuerpo.copy(
                        color = if (elegida) Colores.SobreAccion else Colores.Texto,
                        fontWeight = if (elegida) FontWeight.Bold else FontWeight.Normal,
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}

/** Campo de texto con etiqueta numerada encima. */
@Composable
fun Campo(
    etiqueta: String,
    valor: String,
    onCambio: (String) -> Unit,
    modifier: Modifier = Modifier,
    estilo: TextStyle = Tipos.Item.copy(fontWeight = FontWeight.Normal, fontSize = Tipos.Cuerpo.fontSize),
) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(etiqueta, style = Tipos.Etiqueta)
        BasicTextField(
            value = valor,
            onValueChange = onCambio,
            singleLine = true,
            textStyle = estilo,
            cursorBrush = SolidColor(Colores.Accion),
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = etiqueta.substringAfter("/") },
            decorationBox = { campo ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(1.dp, Colores.Contorno)
                        .padding(horizontal = 14.dp),
                    contentAlignment = Alignment.CenterStart,
                ) { campo() }
            },
        )
    }
}

/** Separador vertical flexible para empujar los botones al fondo. */
@Composable
fun ColumnScope.Empujar() = Spacer(Modifier.weight(1f))

@Composable
fun Espacio(alto: Dp) = Spacer(Modifier.height(alto))

@Composable
fun EspacioAncho(ancho: Dp) = Spacer(Modifier.width(ancho))
