/**
 * Clase que muestra los resultados de la partida y las estadísticas de ambos jugadores.
 */
public class VistaResultados {
    public void mostrarResultados(Jugador jugador1, Jugador jugador2, int partidasGanadasJ1, int partidasPerdidasJ1, int partidasEmpatadasJ1,
                                  int partidasGanadasJ2, int partidasPerdidasJ2, int partidasEmpatadasJ2) {

        // Imprimo los resultados de la partida
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║             RESULTADOS DE LA PARTIDA           ║");
        System.out.println("╠════════════════════════════════════════════════╣");

        // Verifico quién ganó o si hubo empate
        if (partidasGanadasJ1 > partidasGanadasJ2) {
            // Si el jugador 1 ha ganado más partidas, imprimo que el jugador 1 ganó la partida
            System.out.printf("║ %-46s ║%n", "¡ " + jugador1.getNombre() + " ha ganado la partida!");
        } else if (partidasGanadasJ2 > partidasGanadasJ1) {
            // Si el jugador 2 ha ganado más partidas, imprimo que el jugador 2 ganó la partida
            System.out.printf("║ %-46s ║%n", "¡ " + jugador2.getNombre() + " ha ganado la partida!");
        } else {
            // Si las partidas ganadas de ambos jugadores son iguales, imprimo que el juego terminó en empate
            System.out.printf("║ %-46s ║%n", "   ¡ Juego empatado !");
        }

        System.out.println("╠════════════════════════════════════════════════╣");
        // Muestro las estadísticas de partidas ganadas, perdidas y empatadas del jugador 1
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Ganadas (" + jugador1.getNombre() + "):", partidasGanadasJ1);
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Perdidas (" + jugador1.getNombre() + "):", partidasPerdidasJ1);
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Empatadas (" + jugador1.getNombre() + "):", partidasEmpatadasJ1);
        System.out.println("╠════════════════════════════════════════════════╣");

        // Muestro las estadísticas de partidas ganadas, perdidas y empatadas del jugador 2
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Ganadas (" + jugador2.getNombre() + "):", partidasGanadasJ2);
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Perdidas (" + jugador2.getNombre() + "):", partidasPerdidasJ2);
        System.out.printf("║ %-35s %8d   ║%n", "Partidas Empatadas (" + jugador2.getNombre() + "):", partidasEmpatadasJ2);
        System.out.println("╚════════════════════════════════════════════════╝");
    }
}
