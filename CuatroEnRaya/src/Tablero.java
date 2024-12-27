/**
 * La clase Tablero representa el tablero de juego para un juego como Conecta 4.
 * Proporciona métodos para inicializar el tablero, colocar fichas, verificar victorias
 * y determinar si el tablero está lleno.
 */
public class Tablero {

    private final char[][] tablero; // Declaro una matriz para representar el tablero de juego
    private static final int FILAS = 6; // Defino el número de filas del tablero
    private static final int COLUMNAS = 7; // Defino el número de columnas del tablero

    /**
     * Constructor de la clase Tablero.
     * Inicializa el tablero con las dimensiones predeterminadas y coloca un guion ('-') en cada celda.
     */
    public Tablero() {
        this.tablero = new char[FILAS][COLUMNAS]; // Inicializo el tablero con las dimensiones FILAS x COLUMNAS

        // Inicializo todas las celdas del tablero con el valor '-' que indica que están vacías
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    /**
     * Coloca una ficha en la columna especificada.
     * Empieza desde la fila más baja disponible y coloca la ficha allí.
     *
     * @param columna La columna en la que colocar la ficha
     * @param ficha La ficha que se desea colocar
     * @return true si se ha colocado la ficha con éxito, false si no hay espacio disponible
     */
    public boolean colocarFicha(int columna, char ficha) {
        // Intento colocar la ficha en la columna desde la fila más baja hacia arriba
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][columna] == '-') { // Si la celda está vacía
                tablero[i][columna] = ficha; // Coloco la ficha
                return true; // Ficha colocada con éxito
            }
        }
        return false; // No hay espacio disponible en la columna
    }

    /**
     * Verifica si la fila superior del tablero está llena.
     *
     * @return true si el tablero está lleno (sin espacio en la fila superior), false si hay espacio
     */
    public boolean estaLleno() {
        // Verifico si hay algún guion en la fila superior (indica que hay espacio)
        for (int j = 0; j < COLUMNAS; j++) {
            if (tablero[0][j] == '-') { // Si hay algún guion, el tablero no está lleno
                return false;
            }
        }
        return true; // Si no hay guiones, el tablero está lleno
    }

    /**
     * Comprueba si hay una victoria en el tablero para la ficha especificada.
     * Se comprueban las victorias en las direcciones horizontal, vertical y diagonal.
     *
     * @param ficha La ficha que se va a comprobar si tiene una victoria
     * @return true si se ha detectado una victoria, false si no hay victoria
     */
    public boolean comprobarVictoria(char ficha) {
        // Comprobar victoria horizontal
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS - 3; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila][columna + 1] == ficha &&
                        tablero[fila][columna + 2] == ficha &&
                        tablero[fila][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar victoria vertical
        for (int columna = 0; columna < COLUMNAS; columna++) {
            for (int fila = 0; fila < FILAS - 3; fila++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna] == ficha &&
                        tablero[fila + 2][columna] == ficha &&
                        tablero[fila + 3][columna] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar victoria diagonal (de izquierda a derecha)
        for (int fila = 0; fila < FILAS - 3; fila++) {
            for (int columna = 0; columna < COLUMNAS - 3; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna + 1] == ficha &&
                        tablero[fila + 2][columna + 2] == ficha &&
                        tablero[fila + 3][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar victoria diagonal (de derecha a izquierda)
        for (int fila = 0; fila < FILAS - 3; fila++) {
            for (int columna = 3; columna < COLUMNAS; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna - 1] == ficha &&
                        tablero[fila + 2][columna - 2] == ficha &&
                        tablero[fila + 3][columna - 3] == ficha) {
                    return true;
                }
            }
        }
        return false; // No hay victoria
    }

    /**
     * Muestra el tablero en la consola.
     * Imprime el tablero en un formato legible.
     */
    public void mostrarTablero() {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " "); // Imprimo cada celda del tablero
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}
