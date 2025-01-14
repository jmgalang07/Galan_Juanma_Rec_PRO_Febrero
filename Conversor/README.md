# Conversor (XML, CSV, JSON)

## Autor
Juan Manuel Galán Gómez

## Versión
1.0

## Descripción
La aplicación desarrollada es un conversor de formatos de archivo (XML, JSON, y CSV) que permite realizar distintas operaciones mediante una interfaz de usuario por consola. El programa gestiona la lectura y conversión de archivos de un sistema de ficheros. Los usuarios podrán seleccionar una carpeta, leer un archivo y convertirlo a uno de los formatos mencionados. La aplicación tendrá las siguientes funcionalidades:

- Seleccionar una carpeta en el sistema de archivos.
- Leer un archivo de la carpeta seleccionada y almacenar su información.
- Convertir la información del archivo a CSV, JSON o XML.
- Salir del programa.

## Requerimientos

### Funcionales
1. Interfaz de Usuario por Consola: La aplicación interactúa con el usuario mediante la consola.

2. Menú Principal: El programa muestra un menú con las siguientes opciones:
* Seleccionar carpeta: Permite al usuario introducir una ruta de carpeta desde el teclado. El sistema verificará si la carpeta existe.
* Lectura de archivo: Permite al usuario ingresar el nombre de un archivo dentro de la carpeta seleccionada. El sistema comprobará si el archivo existe. El programa determinará el formato del archivo según su extensión y almacenará la información en las estructuras de datos correspondientes. La opción podrá ser utilizada múltiples veces durante la ejecución del programa, limpiando las estructuras de datos antes de cada nueva lectura.
* Conversión a: Permite al usuario elegir entre tres formatos de salida: CSV, JSON o XML. Luego, se pedirá un nombre para el archivo de salida, al que se le añadirá la extensión correspondiente. La información almacenada se exportará en el formato elegido. Esta opción solo estará disponible después de haber leído un archivo.
* Salir: Cierra la aplicación.

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
cd Galan_Juanma_Rec_PRO_Febrero/Conversor
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

