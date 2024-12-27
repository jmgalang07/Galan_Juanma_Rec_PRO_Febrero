/**
 * La clase Jugador representa a un jugador en el juego.
 * Cada jugador tiene un nombre, una ficha (carácter que representa su marca en el tablero)
 * y un contador de victorias.
 */
public class Jugador {

    private final String nombre;
    private final char ficha;
    private int victorias;

    /**
     * Constructor de la clase Jugador.
     * Inicializa el nombre y la ficha del jugador, y establece las victorias a 0.
     *
     * @param nombre Nombre del jugador
     * @param ficha Ficha del jugador
     */
    public Jugador(String nombre, char ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
        this.victorias = 0;
    }

    /**
     * Obtiene el número de victorias del jugador.
     *
     * @return Número de victorias del jugador
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * Incrementa el contador de victorias del jugador en 1.
     */
    public void incrementarVictorias() {
        this.victorias++;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return Nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la ficha del jugador.
     *
     * @return Ficha del jugador
     */
    public char getFicha() {
        return ficha;
    }
}
