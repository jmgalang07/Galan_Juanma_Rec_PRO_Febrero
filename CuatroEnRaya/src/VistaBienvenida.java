/**
 * Clase que muestra el menú de opciones al usuario en la consola.
 */
public class VistaBienvenida {
    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println("\033[1;34m╔═════════════════════════════════════════╗");
        System.out.println("║           Menú de opciones              ║");
        System.out.println("║═════════════════════════════════════════║");
        System.out.println("║ 1 - Elegir modalidad e iniciar          ║");
        System.out.println("║ 2 - Configuración                       ║");
        System.out.println("║ 3 - Instrucciones                       ║");
        System.out.println("║ 4 - Créditos                            ║");
        System.out.println("║ 5 - Salir                               ║");
        System.out.println("║═════════════════════════════════════════║\033[0m");
        System.out.println(" ");
        System.out.print("\nSeleccione una opción del menú (1-5): ");
        System.out.println(" ");
    }
}
