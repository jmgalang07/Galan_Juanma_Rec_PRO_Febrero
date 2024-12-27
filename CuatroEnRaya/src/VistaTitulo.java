/**
 * Clase que muestra el título del juego con un diseño colorido en consola.
 */
public class VistaTitulo {
    public void mostrarTitulo() {
        final String rojoBrillante = "\u001B[91m";
        final String amarilloBrillante = "\u001B[93m";
        final String verdeBrillante = "\u001B[92m";
        final String azulBrillante = "\u001B[94m";
        final String naranjaBrillante = "\u001B[38;5;208m";
        final String lilaBrillante = "\u001B[38;5;135m";

        System.out.println("\033[1;34m");
        System.out.println(rojoBrillante + "╔══════════════════════════════════════════════════════════════════╗");
        System.out.println(amarilloBrillante + "║  ██   ██     ██████  ██    ██     ██████  ██████  █   █  ██████  ║");
        System.out.println(verdeBrillante + "║  ██   ██     ██      ███   ██     ██  ██  ██  ██  ██ ██  ██  ██  ║");
        System.out.println(azulBrillante + "║  ███████     ███     ██ ██ ██     ██████  ██████   ███   ██████  ║");
        System.out.println(naranjaBrillante + "║       ██     ██      ██  ████     ██ █    ██  ██    █    ██  ██  ║");
        System.out.println(lilaBrillante + "║       ██     ██████  ██    ██     ██  ██  ██  ██    █    ██  ██  ║");
        System.out.println(rojoBrillante + "╚══════════════════════════════════════════════════════════════════╝");
        System.out.println("\033[0m");
    }
}
