package co.silencio.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.silencio.app.ui.pantallas.DocumentoPantalla
import co.silencio.app.ui.pantallas.EmpresaPantalla
import co.silencio.app.ui.pantallas.InicioPantalla
import co.silencio.app.ui.pantallas.RegistrarPantalla
import co.silencio.app.ui.theme.Colores
import co.silencio.app.ui.theme.TemaSilencio

private const val DURACION = 300 // milisegundos

private object Rutas {
    const val INICIO = "inicio"
    const val REGISTRAR = "registrar"
    const val EMPRESA = "empresa"
    const val DOCUMENTO = "documento"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Barras del sistema claras con íconos oscuros, sobre el fondo blanco.
        val blanco = Colores.Fondo.toArgb()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(blanco, blanco),
            navigationBarStyle = SystemBarStyle.light(blanco, blanco),
        )
        super.onCreate(savedInstanceState)

        setContent {
            TemaSilencio {
                val nav = rememberNavController()
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Colores.Fondo)
                        .safeDrawingPadding(),
                ) {
                    // Slide horizontal: lo nuevo entra por la derecha; al volver, todo se mueve al revés.
                    NavHost(
                        navController = nav,
                        startDestination = Rutas.INICIO,
                        enterTransition = { slideIntoContainer(SlideDirection.Start, tween(DURACION)) },
                        exitTransition = { slideOutOfContainer(SlideDirection.Start, tween(DURACION)) },
                        popEnterTransition = { slideIntoContainer(SlideDirection.End, tween(DURACION)) },
                        popExitTransition = { slideOutOfContainer(SlideDirection.End, tween(DURACION)) },
                    ) {
                        composable(Rutas.INICIO) {
                            InicioPantalla(
                                alRegistrar = { nav.navigate(Rutas.REGISTRAR) },
                                alAbrirEmpresa = { nav.navigate(Rutas.EMPRESA) },
                                alVerPlazos = { nav.navigate(Rutas.DOCUMENTO) },
                            )
                        }
                        composable(Rutas.REGISTRAR) {
                            RegistrarPantalla(
                                alVolver = { nav.popBackStack() },
                                alGuardar = {
                                    nav.navigate(Rutas.EMPRESA) { popUpTo(Rutas.INICIO) }
                                },
                            )
                        }
                        composable(Rutas.EMPRESA) {
                            EmpresaPantalla(
                                alVolver = { nav.popBackStack() },
                                alGenerarSolicitud = { nav.navigate(Rutas.DOCUMENTO) },
                                alGenerarQueja = { nav.navigate(Rutas.DOCUMENTO) },
                            )
                        }
                        composable(Rutas.DOCUMENTO) {
                            DocumentoPantalla(
                                alVolver = { nav.popBackStack() },
                                alMarcarEnviada = { nav.popBackStack(Rutas.INICIO, inclusive = false) },
                            )
                        }
                    }
                }
            }
        }
    }
}
