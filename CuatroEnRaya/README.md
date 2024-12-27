# Cuatro en Raya con IA y Entorno Gráfico

## Autor
Juan Manuel Galán Gómez

## Versión
1.0

## Descripción
La aplicación es un juego interactivo de "Cuatro en Raya" en el que los jugadores pueden competir entre sí o contra una inteligencia artificial (IA). El juego incluye dos modalidades de juego:
- Contra otro humano.
- Contra la IA, donde uno de los jugadores será gestionado por el sistema.

La aplicación permite configurar el juego, elegir colores de los jugadores, el número de partidas, y el orden de salida, entre otras opciones.

## Requerimientos

### Funcionales
1. **Reglas del Juego**: La aplicación sigue las reglas del juego "Conecta 4" tal como se detallan en Wikipedia.
2. **Modalidades de Juego**:
    - **Contra la IA**: Un jugador será controlado por la inteligencia artificial.
    - **Contra Humano**: Dos jugadores humanos se turnarán para colocar fichas.
3. **Vistas del Juego**:
    - **Bienvenida**: Menú principal con las opciones:
        - Elegir modalidad.
        - Iniciar juego.
        - Configuración.
        - Créditos.
    - **Instrucciones**: Información sobre cómo jugar.
    - **Configuración**: Personalización de la partida, como color de jugadores, número de partidas, y orden de salida.
    - **Juego**: Tablero de juego interactivo.
    - **Resultados**: Marcador y victorias de los jugadores.
    - **Créditos**: Información sobre el autor.

### Técnicos
- **Lenguaje**: La aplicación está programada en Java, versión 20 o superior.
- **Compatibilidad**: Compatible con cualquier sistema operativo.
- **Interfaz Gráfica**: Puede desarrollarse usando:
    - Consola de texto.
    - JavaFX.
    - SWING.

## Instrucciones de configuración y ejecución

### 1. Clonar el Repositorio

Primero, clona el repositorio en tu máquina local. Abre una terminal (cmd en Windows o Terminal en macOS/Linux) y ejecuta el siguiente comando:

```bash
git clone https://github.com/jmgalang07/Galan_Juanma_Rec_PRO_Febrero.git
```

### 2. Navegar al Proyecto
Accede al directorio CuatroEnRaya donde se encuentra el proyecto:
```bash
cd Galan_Juanma_Rec_PRO_Febrero/CuatroEnRaya
```

### 3.  Compilar los Archivos
Los archivos fuente de Java se encuentran en la carpeta src. Para compilar el proyecto, navega a esa carpeta y usa el comando javac:
```bash
cd src
javac Main.java
```

### 4.  Ejecutar la Aplicación
Una vez compilado el proyecto, puedes ejecutar la aplicación con el siguiente comando:
```bash
java Main
```

