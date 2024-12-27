import java.util.Scanner;

/**
 * Esta clase se encarga de gestionar la vista de configuración del juego.
 * Permite configurar los colores de los jugadores, el número de partidas
 * a jugar y el orden de salida de los jugadores.
 */
public class VistaConfiguracion {
    private String colorJugador1;
    private String colorJugador2;
    private int ordenSalida;

    /**
     * Muestra el menú de configuración, permite al usuario seleccionar
     * los colores de los jugadores, el número de partidas y el orden de salida.
     *
     * @return true si la configuración se ha realizado correctamente.
     */
    public boolean mostrarConfiguracion() {
        Scanner sc = new Scanner(System.in);

        // Muestra el encabezado de configuración
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                 Configuración                  ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        // Configurar colores de los jugadores
        do {
            System.out.print("Seleccione el color del Jugador 1 (Rojo/Amarillo): ");
            colorJugador1 = sc.nextLine().trim();  // Obtengo la entrada y elimino espacios adicionales

            // Verifico que el color ingresado sea válido
            while (!colorJugador1.equalsIgnoreCase("Rojo") && !colorJugador1.equalsIgnoreCase("Amarillo")) {
                System.out.println("ERROR: Solo se puede seleccionar 'Rojo' o 'Amarillo'.");
                System.out.print("Seleccione el color del Jugador 1 (Rojo/Amarillo): ");
                colorJugador1 = sc.nextLine().trim();  // Vuelvo a pedir el color
            }

            // Asigno el color al jugador 1 según la elección
            colorJugador1 = colorJugador1.equalsIgnoreCase("Rojo") ? "\u001B[91m" : "\u001B[93m";

            System.out.print("Seleccione el color del Jugador 2 (Rojo/Amarillo): ");
            colorJugador2 = sc.nextLine().trim();  // Obtengo la entrada y elimino espacios adicionales

            // Verifico que el color ingresado sea válido
            while (!colorJugador2.equalsIgnoreCase("Rojo") && !colorJugador2.equalsIgnoreCase("Amarillo")) {
                System.out.println("ERROR: Solo se puede seleccionar 'Rojo' o 'Amarillo'.");
                System.out.print("Seleccione el color del Jugador 2 (Rojo/Amarillo): ");
                colorJugador2 = sc.nextLine().trim();  // Vuelvo a pedir el color
            }

            // Asigno el color al jugador 2 según la elección
            colorJugador2 = colorJugador2.equalsIgnoreCase("Rojo") ? "\u001B[91m" : "\u001B[93m";

            // Verifico que los colores no sean iguales
            if (colorJugador1.equals(colorJugador2)) {
                System.out.println("ERROR: Ambos jugadores no pueden tener el mismo color. Intente de nuevo.");
            }
        } while (colorJugador1.equals(colorJugador2)); // Repite si los colores son iguales

        // Configurar número de partidas
        System.out.print("Ingrese el número de partidas que se jugarán: ");
        int numeroPartidas;
        while (true) {
            try {
                // Intento leer un número entero
                numeroPartidas = Integer.parseInt(sc.nextLine());
                if (numeroPartidas > 0) break; // Acepto solo números mayores que 0
                System.out.print("Por favor, ingrese un número válido mayor que 0: ");
            } catch (NumberFormatException e) {
                // Si ocurre una excepción, pido que ingrese un número válido
                System.out.print("ERROR: Ingrese un número válido: ");
            }
        }

        // Configurar orden de salida
        System.out.println("Seleccione el orden de salida: ");
        System.out.println("1. Aleatorio");
        System.out.println("2. Sale Ganador");
        System.out.println("3. Sale Perdedor");
        System.out.println("4. Sale Siempre Jugador 1");
        System.out.print("Ingrese la opción (1-4): ");
        while (true) {
            try {
                // Intento leer la opción del orden de salida
                ordenSalida = Integer.parseInt(sc.nextLine());
                if (ordenSalida >= 1 && ordenSalida <= 4) break; // Acepto opciones entre 1 y 4
                System.out.print("Por favor, ingrese una opción válida (1-4): ");
            } catch (NumberFormatException e) {
                // Si ocurre una excepción, pido que ingrese una opción válida
                System.out.print("ERROR: Ingrese un número válido: ");
            }
        }

        // Muestra un resumen con la configuración
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           Configuración Guardada               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        // Muestro el color de los jugadores y el número de partidas
        System.out.println("        Jugador 1 Color: " + colorJugador1 + (colorJugador1.equals("\u001B[91m") ? "Rojo" : "Amarillo") + "\033[0m");
        System.out.println("        Jugador 2 Color: " + colorJugador2 + (colorJugador2.equals("\u001B[91m") ? "Rojo" : "Amarillo") + "\033[0m");
        System.out.println("        Número de partidas: " + numeroPartidas);
        System.out.println("        Orden de salida: " + obtenerTextoOrdenSalida());
        System.out.println("╚════════════════════════════════════════════════╝");
        return true;
    }

    /**
     * Método privado que devuelve el texto que describe el orden de salida.
     *
     * @return El texto correspondiente al orden de salida seleccionado.
     */
    private String obtenerTextoOrdenSalida() {
        return switch (ordenSalida) {
            case 1 -> "Aleatorio";
            case 2 -> "Sale Ganador";
            case 3 -> "Sale Perdedor";
            case 4 -> "Sale Siempre Jugador 1";
            default -> "Desconocido";
        };
    }

    /**
     * Obtiene el color del Jugador 1.
     *
     * @return El color del Jugador 1 en formato ANSI.
     */
    public String getColorJugador1() {
        return colorJugador1;
    }

    /**
     * Obtiene el color del Jugador 2.
     *
     * @return El color del Jugador 2 en formato ANSI.
     */
    public String getColorJugador2() {
        return colorJugador2;
    }
}
