import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar la lógica del juego y la interacción con el usuario.
 * Controla el flujo del juego, el cambio de turnos, la colocación de fichas y la verificación del ganador.
 */
public class ControladorJuego {
    private final Juego juego; // Declaro un objeto Juego que gestiona la lógica del juego

    /**
     * Constructor que inicializa el juego con los nombres de los jugadores y si se juega contra la IA.
     *
     * @param nombreJugador1 El nombre del primer jugador.
     * @param nombreJugador2 El nombre del segundo jugador.
     * @param contraIA Un booleano que indica si el juego es contra la IA (true) o entre dos jugadores humanos (false).
     */
    public ControladorJuego(String nombreJugador1, String nombreJugador2, boolean contraIA) {
        // En el constructor, inicializo el juego con los nombres de los jugadores y si se juega contra la IA
        this.juego = new Juego(nombreJugador1, nombreJugador2, contraIA);
    }

    /**
     * Método que inicia el juego y gestiona el flujo principal del juego.
     * Permite a los jugadores hacer su jugada y controla las condiciones de victoria, empate o fin del juego.
     */
    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in); // Creo un objeto Scanner para leer la entrada del usuario
        boolean jugando = true; // Variable que controla si el juego sigue en curso

        // Creo los jugadores con el color configurado (X para jugador1, O para jugador2)
        Jugador jugador1 = new Jugador(juego.getJugador1().getNombre(), 'X');
        Jugador jugador2 = new Jugador(juego.getJugador2().getNombre(), 'O');

        // Inicializo variables para llevar el marcador de las partidas ganadas, perdidas y empatadas
        int partidasGanadasJ1 = 0;
        int partidasPerdidasJ1 = 0;
        int partidasEmpatadasJ1 = 0;
        int partidasGanadasJ2 = 0;
        int partidasPerdidasJ2 = 0;
        int partidasEmpatadasJ2 = 0;

        // Inicio el bucle principal del juego
        while (jugando) {
            // Muestra el turno del jugador actual
            System.out.println("Turno de " + juego.getJugadorActual().getNombre() + " ( " + juego.getJugadorActual().getFicha() + " )");
            juego.getTablero().mostrarTablero(); // Muestra el tablero de juego

            int columna = -1; // Declaro la variable para almacenar la columna donde se va a colocar la ficha

            // Si el jugador actual es la IA, dejo que la IA elija la columna
            if (juego.getJugadorActual() instanceof JugadorIA) {
                columna = ((JugadorIA) juego.getJugadorActual()).elegirColumna(juego.getTablero());
            } else {
                // Si el jugador es humano, pido que elija una columna
                boolean entradaValida = false;
                while (!entradaValida) {
                    try {
                        // Solicito al jugador que ingrese una columna
                        System.out.print("Elige una columna (1-7): ");
                        columna = Integer.parseInt(sc.nextLine()) - 1; // Restamos 1 porque las columnas son de 1 a 7, pero en el arreglo van de 0 a 6

                        // Verifico que la columna esté dentro del rango válido
                        if (columna >= 0 && columna < 7) {
                            entradaValida = true;
                        } else {
                            System.out.println("ERROR: Introduce un número del 1 al 7.");
                        }
                    } catch (NumberFormatException e) {
                        // Si el jugador ingresa algo que no es un número, le pido que ingrese un número válido
                        System.out.println("ERROR: Debes ingresar un número válido del 1 al 7.");
                    }
                }
            }

            // Intento colocar la ficha del jugador en la columna seleccionada
            if (juego.colocarFicha(columna)) {
                // Si el jugador actual ha ganado, actualizo el marcador y muestro los resultados
                if (juego.hayGanador()) {
                    juego.getTablero().mostrarTablero(); // Muestra el tablero con la jugada final

                    // Actualizo el marcador dependiendo de quién haya ganado
                    if (juego.getJugadorActual() == jugador1) {
                        partidasGanadasJ1++; // Incremento las victorias del jugador 1
                        partidasPerdidasJ2++; // Incremento las derrotas del jugador 2
                    } else {
                        partidasGanadasJ2++; // Incremento las victorias del jugador 2
                        partidasPerdidasJ1++; // Incremento las derrotas del jugador 1
                    }

                    // Muestra los resultados de la partida usando la clase VistaResultados
                    VistaResultados vistaResultados = new VistaResultados();
                    vistaResultados.mostrarResultados(jugador1, jugador2, partidasGanadasJ1, partidasPerdidasJ1, partidasEmpatadasJ1,
                            partidasGanadasJ2, partidasPerdidasJ2, partidasEmpatadasJ2);

                    System.out.println("Presiona ENTER para volver al menú...");
                    sc.nextLine();
                    jugando = false; // Termino el juego
                } else if (juego.getTablero().estaLleno()) { // Verifico si el tablero está lleno y es un empate
                    juego.getTablero().mostrarTablero(); // Muestra el tablero

                    partidasEmpatadasJ1++; // Incremento los empates
                    partidasEmpatadasJ2++; // Incremento los empates

                    // Muestra los resultados del empate
                    VistaResultados vistaResultados = new VistaResultados();
                    vistaResultados.mostrarResultados(jugador1, jugador2, partidasGanadasJ1, partidasPerdidasJ1, partidasEmpatadasJ1,
                            partidasGanadasJ2, partidasPerdidasJ2, partidasEmpatadasJ2);

                    System.out.println("Presiona ENTER para volver al menú...");
                    sc.nextLine();
                    jugando = false; // Termino el juego
                } else {
                    // Si no hay ganador y el tablero no está lleno, cambio de turno
                    juego.cambiarTurno();
                }
            } else {
                // Si la columna está llena, le indico al jugador que elija otra
                System.out.println("Columna llena. Intente de nuevo.");
            }
        }
    }
}
