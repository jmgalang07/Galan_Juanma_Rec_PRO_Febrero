/**
 * Clase que muestra los créditos del programa.
 * Contiene un método que devuelve una cadena con los créditos formateados.
 */
public class VistaCreditos {
    public String mostrarCreditos() {
        return "\u001B[93m╔═════════════════════════════════════════════════════════╗\n" + // Color amarillo
                "║                         CRÉDITOS                        ║\n" +
                "║═════════════════════════════════════════════════════════║\n" +
                "║ Programado por: Juan Manuel Galán Gómez   2º DAW A      ║\n" +
                "║ Desarrollado como parte de un proyecto de programación  ║\n" +
                "║ ¡ Gracias por jugar !                                   ║\n" +
                "║═════════════════════════════════════════════════════════║\033[0m";
    }
}
