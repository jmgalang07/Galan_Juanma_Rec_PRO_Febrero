/**
 * Clase que representa la lógica principal del juego.
 * Gestiona el tablero, los jugadores y el flujo de turnos.
 */
public class Juego {

    private final Tablero tablero; // Declaro un objeto de tipo Tablero para representar el tablero de juego
    private final Jugador jugador1; // Declaro un objeto de tipo Jugador para el jugador 1
    private final Jugador jugador2; // Declaro un objeto de tipo Jugador para el jugador 2
    private Jugador jugadorActual; // Declaro una referencia para el jugador que está jugando actualmente

    /**
     * Constructor de la clase Juego.
     * Inicializa el tablero y los jugadores con los nombres y la opción de jugar contra la IA.
     *
     * @param nombreJugador1 Nombre del primer jugador
     * @param nombreJugador2 Nombre del segundo jugador
     * @param contraIA Indica si el segundo jugador es la IA
     */
    public Juego(String nombreJugador1, String nombreJugador2, boolean contraIA) {
        this.tablero = new Tablero(); // Inicializo el tablero
        this.jugador1 = new Jugador(nombreJugador1, 'X'); // Inicializo el jugador 1 con su nombre y ficha
        this.jugador2 = contraIA ? new JugadorIA("IA", 'O') : new Jugador(nombreJugador2, 'O'); // Si es contra IA, asigno un JugadorIA, sino un Jugador normal
        this.jugadorActual = jugador1; // El jugador actual es el jugador 1 al principio
    }

    /**
     * Cambia el turno entre los jugadores.
     * Si el jugador actual es el jugador 1, pasa al jugador 2, y viceversa.
     */
    public void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    /**
     * Intenta colocar la ficha del jugador actual en la columna especificada.
     *
     * @param columna Columna donde se desea colocar la ficha
     * @return true si se ha podido colocar la ficha, false si no se ha podido
     */
    public boolean colocarFicha(int columna) {
        return tablero.colocarFicha(columna, jugadorActual.getFicha());
    }

    /**
     * Verifica si el jugador actual ha ganado.
     * Si es así, incrementa sus victorias y devuelve true.
     *
     * @return true si el jugador actual ha ganado, false en caso contrario
     */
    public boolean hayGanador() {
        if (tablero.comprobarVictoria(jugadorActual.getFicha())) {
            jugadorActual.incrementarVictorias(); // Incremento las victorias del jugador actual
            return true;
        }
        return false; // No hay ganador
    }

    /**
     * Obtiene el tablero del juego.
     *
     * @return El tablero actual del juego
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Obtiene el jugador que está jugando actualmente.
     *
     * @return El jugador actual
     */
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    /**
     * Obtiene el primer jugador.
     *
     * @return El primer jugador
     */
    public Jugador getJugador1() {
        return jugador1;
    }

    /**
     * Obtiene el segundo jugador.
     *
     * @return El segundo jugador
     */
    public Jugador getJugador2() {
        return jugador2;
    }
}
