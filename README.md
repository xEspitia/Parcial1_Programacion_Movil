# BrainBattles 2 🧠

BrainBattles 2 es una aplicación de trivia interactiva desarrollada en Android que pone a prueba tus conocimientos en diferentes categorías como historia, ciencia, geografía, arte, literatura y música.

## Características ✨

- Interfaz moderna y atractiva usando Jetpack Compose
- Múltiples categorías de preguntas
- Sistema de puntuación en tiempo real
- Personalización del color de fondo
- Navegación intuitiva entre pantallas
- Persistencia de datos usando DataStore

## Requisitos Previos 📋

- Android Studio Hedgehog | 2023.1.1 o superior
- JDK 17 o superior
- Android SDK 34 (Android 14.0) o superior
- Gradle 8.0 o superior

## Instalación 🚀

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/BrainBattles2.git
```

2. Abre el proyecto en Android Studio:
   - Abre Android Studio
   - Selecciona "Open an existing Android Studio project"
   - Navega hasta la carpeta del proyecto y selecciónala

3. Sincroniza el proyecto:
   - Espera a que Android Studio sincronice el proyecto
   - Si aparece un mensaje para actualizar el Gradle, haz clic en "Update"

4. Ejecuta la aplicación:
   - Conecta un dispositivo Android o inicia un emulador
   - Haz clic en el botón "Run" (ícono de play verde) en la barra de herramientas
   - Selecciona el dispositivo donde quieres instalar la aplicación

## Estructura del Proyecto 📁

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/espi/brainbattles2/
│   │   │   ├── model/           # Modelos de datos
│   │   │   ├── navigation/      # Configuración de navegación
│   │   │   ├── ui/             # Componentes de la interfaz
│   │   │   ├── viewmodel/      # ViewModels
│   │   │   └── MainActivity.kt # Punto de entrada
│   │   └── res/                # Recursos
│   └── test/                   # Pruebas unitarias
└── build.gradle.kts            # Configuración de Gradle
```

## Tecnologías Utilizadas 🛠️

- Kotlin
- Jetpack Compose
- Navigation Component
- ViewModel
- LiveData
- DataStore
- Material Design 3

## Uso de la Aplicación 🎮

1. **Pantalla de Inicio**
   - Presiona "¡Comenzar Juego!" para iniciar una nueva partida
   - Accede a la configuración usando el ícono de engranaje

2. **Juego**
   - Responde las preguntas seleccionando una de las opciones
   - Gana puntos por cada respuesta correcta
   - El juego termina cuando respondes todas las preguntas

3. **Configuración**
   - Personaliza el color de fondo de la aplicación
   - Los cambios se guardan automáticamente

## Contribuir 🤝

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. Haz un fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia 📄

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Contacto 📧

Tu Nombre - [@tu_twitter](https://twitter.com/tu_twitter)

Link del Proyecto: [https://github.com/tu-usuario/BrainBattles2](https://github.com/tu-usuario/BrainBattles2) 