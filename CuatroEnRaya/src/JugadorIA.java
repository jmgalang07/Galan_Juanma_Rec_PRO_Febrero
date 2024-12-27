import java.util.Random;

/**
 * Representa a un jugador controlado por la IA.
 * Hereda de la clase Jugador y tiene la capacidad de elegir una columna aleatoria para colocar su ficha.
 */
public class JugadorIA extends Jugador {

    /**
     * Constructor de la clase JugadorIA.
     * Inicializa el nombre y la ficha del jugador IA.
     *
     * @param nombre Nombre del jugador IA
     * @param ficha Ficha del jugador IA
     */
    public JugadorIA(String nombre, char ficha) {
        super(nombre, ficha);
    }

    /**
     * Elige una columna aleatoria en el tablero para colocar la ficha del jugador IA.
     *
     * @param tablero El tablero de juego donde se coloca la ficha
     * @return La columna seleccionada aleatoriamente (entre 0 y 6)
     */
    public int elegirColumna(Tablero tablero) {
        Random random = new Random();
        return random.nextInt(7); // Devuelve una columna aleatoria entre 0 y 6
    }
}
