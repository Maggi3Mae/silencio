# Silencio

App Android open source, sin IA, para registrar las llamadas, SMS y correos no deseados que recibes en Colombia, detectar cuándo una empresa incumple la Ley 2300 de 2023 ("Dejen de fregar") o tu inscripción en el Registro de Números Excluidos (RNE), y generar los documentos para reclamar.

Todos los datos se guardan solo en tu celular.

> Estado: **entrega 1 — esqueleto navegable**. Las pantallas usan datos de ejemplo; todavía no guarda nada ni aplica reglas.

## Requisitos

- Android Studio (cualquier versión reciente)
- JDK 17 (viene incluido con Android Studio)
- Un celular con Android 10 o superior

## Compilar y probar

1. Clona el repositorio y ábrelo en Android Studio con **File › Open**, eligiendo la carpeta del proyecto.
2. Espera a que termine la sincronización de Gradle (la primera vez descarga dependencias).
3. En el celular, activa las **Opciones de desarrollador** y la **Depuración USB**, y conéctalo al computador.
4. Elige tu celular en la barra superior y pulsa **Run ▶**.

También puedes generar el APK desde la terminal:

```bash
./gradlew assembleDebug
```

El archivo queda en `app/build/outputs/apk/debug/app-debug.apk`.

## Estructura

```
app/src/main/java/co/silencio/app/
├── MainActivity.kt           Navegación entre pantallas
├── datos/DatosEjemplo.kt     Datos de ejemplo (se reemplazan en la entrega 2)
└── ui/
    ├── theme/                Colores, tipografía y tema
    ├── componentes/          Botones, cajas, campos, íconos
    └── pantallas/            Inicio, Registrar, Empresa, Documento
```

## Diseño

- Fondo blanco, esquinas rectas.
- Petróleo `#0E7C7B` para acciones y fucsia `#E6007E` solo para incumplimientos.
- Tipografías Space Grotesk y JetBrains Mono (licencia OFL, ver `licencias/`).
- Todos los colores cumplen contraste WCAG AA contra el fondo blanco.

## Hoja de ruta

1. ✅ Esqueleto navegable
2. Datos reales: configuración, registro de contactos, empresas, respaldo
3. Motor de reglas: festivos, horario, frecuencia, RNE, reincidencia
4. Detección de llamadas: notificación al colgar y lista de llamadas recientes
5. Documentos y plazos
6. Publicación en GitHub Releases y F-Droid
