/**
 * Clase que muestra las instrucciones del juego.
 * Contiene un método que devuelve una cadena con las instrucciones formateadas.
 */
public class VistaInstrucciones {
    public String mostrarInstrucciones() {
        return "\u001B[35m╔══════════════════════════════════════════════════════════╗\n" + // Color rosa
                "║                         INSTRUCCIONES                    ║\n" +
                "║══════════════════════════════════════════════════════════║\n" +
                "║ 1. El juego consiste en colocar fichas                   ║\n" +
                "║    de manera estratégica para formar una                 ║\n" +
                "║    línea de 4 fichas consecutivas.                       ║\n" +
                "║ 2. El jugador que logre alinear 4 fichas                 ║\n" +
                "║    en horizontal, vertical o diagonal gana.              ║\n" +
                "║ 3. Los jugadores se turnan para colocar                  ║\n" +
                "║    sus fichas en las columnas del tablero.               ║\n" +
                "║ 4. El juego puede jugarse contra otro jugador            ║\n" +
                "║    o contra la inteligencia artificial (IA).             ║\n" +
                "║══════════════════════════════════════════════════════════║\n" +
                "\033[0m";
    }
}
