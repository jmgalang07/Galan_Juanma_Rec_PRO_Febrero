import java.util.Scanner;

/**
 * Autor: Juan Manuel Galán Gómez
 *<br>
 * Versión: 1.0
 *<br>
 * Descripción: Este programa es un juego interactivo en consola donde el jugador puede elegir entre
 * jugar contra otro jugador o contra la inteligencia artificial (IA). El jugador tiene la posibilidad
 * de ver las instrucciones del juego, configurarlo y consultar los créditos.
 */
public class Main {

    public static void main(String[] args) {
        // Primero, creo las vistas necesarias para mostrar
        // el título, la bienvenida, las instrucciones, la configuración y los créditos.
        VistaTitulo vistaTitulo = new VistaTitulo();
        vistaTitulo.mostrarTitulo();

        VistaBienvenida vistaBienvenida = new VistaBienvenida();
        VistaInstrucciones vistaInstrucciones = new VistaInstrucciones();
        VistaConfiguracion vistaConfiguracion = new VistaConfiguracion();
        VistaCreditos vistaCreditos = new VistaCreditos();

        // Inicializo un objeto Scanner para leer las entradas del usuario desde la consola.
        Scanner sc = new Scanner(System.in);

        // Declaro unas variables para gestionar el flujo del menú
        boolean salir = false;
        int opcion;
        int opciones;

        // Comienzo un bucle para mostrar el menú principal y seguir ejecutando el programa
        do {
            vistaBienvenida.mostrarMenu();  // Muestro el menú de bienvenida

            try {
                // Leo una opción del usuario
                opcion = Integer.parseInt(sc.next());

                // Aquí hago una selección con base en la opción del menú
                switch (opcion) {
                    case 1:
                        // Si elijo la opción 1, es para seleccionar una modalidad de juego
                        boolean modalidadSeleccionada = false;
                        do {
                            // Muestra las opciones para seleccionar modalidad
                            System.out.println(" ");
                            System.out.println("\u001B[38;5;135m╔═════════════════════════════════════════╗");
                            System.out.println("║                MODALIDADES              ║");
                            System.out.println("║═════════════════════════════════════════║");
                            System.out.println("║ 1 - Jugar contra otro jugador           ║");
                            System.out.println("║ 2 - Jugar contra la IA                  ║");
                            System.out.println("║═════════════════════════════════════════║\033[0m");
                            System.out.println(" ");
                            System.out.print("\nSeleccione una modalidad (1-2): ");
                            System.out.println(" ");

                            try {
                                // Intento leer la modalidad seleccionada
                                opciones = Integer.parseInt(sc.next());
                                if (opciones == 1 || opciones == 2) {
                                    sc.nextLine(); // Limpiar el buffer de entrada

                                    // Si se selecciona modalidad 1, el juego será entre dos jugadores
                                    if (opciones == 1) {
                                        System.out.print("Nombre del Jugador 1: ");
                                        String jugador1 = sc.nextLine();
                                        System.out.print("Nombre del Jugador 2: ");
                                        String jugador2 = sc.nextLine();
                                        // Creo un controlador para el juego entre dos jugadores
                                        ControladorJuego controlador1 = new ControladorJuego(jugador1, jugador2, false);
                                        controlador1.iniciarJuego();
                                    } else {
                                        // Si se selecciona modalidad 2, el juego será contra la IA
                                        System.out.print("Nombre del Jugador: ");
                                        String jugador1 = sc.nextLine();
                                        // Creo un controlador para el juego contra la IA
                                        ControladorJuego controlador2 = new ControladorJuego(jugador1, "IA", true);
                                        controlador2.iniciarJuego();
                                    }
                                    modalidadSeleccionada = true; // Salgo del bucle interno después de seleccionar modalidad
                                } else {
                                    // Si la opción es incorrecta, pido al usuario que ingrese una opción válida
                                    System.out.println("ERROR: Debes ingresar solo 1 o 2.");
                                }
                            } catch (NumberFormatException e) {
                                // Si el usuario ingresa algo que no es un número válido, se muestra un error
                                System.out.println("ERROR: Debes ingresar un número entero válido (1 o 2).");
                            }
                        } while (!modalidadSeleccionada); // Continuo hasta que se seleccione una modalidad correctamente
                        break;

                    case 2:
                        // Si elijo la opción 2, es para configurar el juego
                        if (vistaConfiguracion.mostrarConfiguracion()) {
                            // Si la configuración se completa con éxito, muestro un mensaje de éxito
                            System.out.println("\u001B[92m - Configuración completada con éxito.\033[0m");
                        } else {
                            // Si no se pudo completar la configuración, muestro un mensaje de error
                            System.out.println("\u001B[91mNo se pudo completar la configuración. Intente nuevamente.\033[0m");
                        }
                        break;

                    case 3:
                        // Si elijo la opción 3, muestro las instrucciones del juego
                        System.out.println(vistaInstrucciones.mostrarInstrucciones());
                        System.out.println("Presiona ENTER para volver al menú...");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    case 4:
                        // Si elijo la opción 4, muestro los créditos del juego
                        System.out.println(vistaCreditos.mostrarCreditos());
                        System.out.println(" ");
                        System.out.println("Presiona ENTER para volver al menú...");
                        sc.nextLine();
                        sc.nextLine();
                        break;

                    case 5:
                        // Si elijo la opción 5, salgo del programa
                        System.out.println();
                        System.out.println("\u001B[92m╔═════════════════════════════════════════╗");
                        System.out.println("║          ¡ HASTA LA PRÓXIMA !           ║");
                        System.out.println("║═════════════════════════════════════════║\033[0m");
                        System.out.println();
                        salir = true; // Establezco la variable salir a true para salir del bucle
                        break;

                    default:
                        // Si el usuario ingresa una opción no válida, le aviso que debe intentar nuevamente
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                // Si el usuario ingresa algo que no es un número entero, se muestra un error
                System.out.println("ERROR: Debes ingresar un número entero válido.");
            }
        } while (!salir); // El bucle sigue hasta que la variable salir sea true
    }
}
