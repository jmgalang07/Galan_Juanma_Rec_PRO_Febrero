package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static File selectedFolder;
    private static File selectedFile;
    private static final DataStructure data = new DataStructure();

    public static void main(String[] args) {
        final String rojoBrillante = "\u001B[91m";
        final String amarilloBrillante = "\u001B[93m";
        final String verdeBrillante = "\u001B[92m";
        final String azulBrillante = "\u001B[94m";
        final String naranjaBrillante = "\u001B[38;5;208m";
        final String lilaBrillante = "\u001B[38;5;135m";

        System.out.println(rojoBrillante + "╔═════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(amarilloBrillante + "║   ██████  ██████  ██    ██  ██      ██  ██████  ███████  ██████  ██████  ███████    ║");
        System.out.println(verdeBrillante + "║   ██      ██  ██  ███   ██   ██    ██   ██      ██   ██  ██      ██  ██  ██   ██    ║");
        System.out.println(azulBrillante + "║   ██      ██  ██  ██ ██ ██    ██  ██    ████    ███████  ██████  ██  ██  ███████    ║");
        System.out.println(naranjaBrillante + "║   ██      ██  ██  ██   ███     ████     ██      ██ ██        ██  ██  ██  ██  ██     ║");
        System.out.println(lilaBrillante + "║   ██████  ██████  ██    ██      ██      ██████  ██   ██  ██████  ██████  ██   ██    ║");
        System.out.println(rojoBrillante + "╚═════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\033[0m"); // Restablecer colores



        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();
            int option = getOption(sc);

            switch (option) {
                case 1:
                    selectFolder(sc);
                    break;
                case 2:
                    readFile(sc);
                    break;
                case 3:
                    convertTo(sc);
                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("\u001B[92m╔═════════════════════════════════════════╗");
                    System.out.println("║       ¡ SALIENDO DEL CONVERSOR !        ║");
                    System.out.println("║═════════════════════════════════════════║\033[0m");
                    System.out.println(" ");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    // Muestra el menú
    private static void showMenu() {
        final String azulBrillante = "\u001B[94m";
        System.out.println("\n" + azulBrillante + "╔═════════════════════════════════════════╗");
        System.out.println("║              MENÚ PRINCIPAL             ║");
        System.out.println("║═════════════════════════════════════════║");
        System.out.println("║ 1 - Seleccionar carpeta                 ║");
        System.out.println("║ 2 - Leer archivo                        ║");
        System.out.println("║ 3 - Convertir a formato                 ║");
        System.out.println("║ 4 - Salir                               ║");
        System.out.println("║═════════════════════════════════════════║");
        System.out.print("\033[0mSelecciona una opción (1-4): ");
    }

    // Obtiene la opción seleccionada por el usuario
    private static int getOption(Scanner sc) {
        while (true) {
            try {
                int option = Integer.parseInt(sc.nextLine());
                if (option >= 1 && option <= 4) {
                    return option;
                } else {
                    System.out.println("Opción fuera de rango. Elige un número entre 1 y 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar un número entero válido.");
            }
        }
    }

    // Obtiene la opción seleccionada por el usuario (entre 1 y 3)
    private static int obtenerOpcionHastaTres(Scanner sc) {
        while (true) {
            try {
                int opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                } else {
                    System.out.println("Opción fuera de rango. Elige un número entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar un número entero válido.");
            }
        }
    }

    // Selecciona una carpeta
    private static void selectFolder(Scanner sc) {
        System.out.print("\nIntroduce la ruta de la carpeta: ");
        String folderPath = sc.nextLine();
        selectedFolder = new File(folderPath);

        if (selectedFolder.exists() && selectedFolder.isDirectory()) {
            System.out.println("Carpeta seleccionada: " + selectedFolder.getAbsolutePath());
            System.out.println("\u001B[93m╔═════════════════════════════════════════════════════╗");
            System.out.println("║                 Contenido de la carpeta             ║");
            System.out.println("╚═════════════════════════════════════════════════════╝");

            File[] files = selectedFolder.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String fileType = file.isDirectory() ? "\u001B[94m[Carpeta]" : "\u001B[92m[Archivo]";
                    System.out.println("\u001B[96m " + fileType + "  " + file.getName() + "  \u001B[0m ");
                }
            } else {
                System.out.println("La carpeta está vacía o no se pudo acceder a los archivos.");
            }
            System.out.println("\u001B[93m╚═════════════════════════════════════════════════════╝");

            // Agregar mensaje para presionar Enter
            System.out.print("\nPresiona Enter para continuar...");
            sc.nextLine(); // Espera que el usuario presione Enter
        } else {
            System.out.println("La ruta no es válida. Asegúrate de que la carpeta exista.");
        }
    }


    // Lee un archivo dentro de la carpeta seleccionada (selectedFolder)
    private static void readFile(Scanner sc) {
        if (selectedFolder == null) {
            System.out.println("Primero selecciona una carpeta.");
            return;
        }

        System.out.print("Introduce el nombre del archivo a leer: ");
        String fileName = sc.nextLine();
        selectedFile = new File(selectedFolder, fileName);

        if (selectedFile.exists()) {
            String extension = getFileExtension(selectedFile);
            switch (extension) {
                case "csv":
                    data.readCSV(selectedFile);
                    break;
                case "json":
                    data.readJSON(selectedFile);
                    break;
                case "xml":
                    data.readXML(selectedFile);
                    break;
                default:
                    System.out.println("Formato de archivo no soportado. Solo CSV, JSON o XML.");
                    return;
            }
            System.out.println("Archivo leído con éxito.");
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    // Realiza la conversión a CSV, JSON o XML
    private static void convertTo(Scanner sc) {
        if (selectedFile == null) {
            System.out.println("Primero lee un archivo.");
            return;
        }

        System.out.println("\nSelecciona el formato de salida:");
        System.out.println("1. CSV");
        System.out.println("2. JSON");
        System.out.println("3. XML");
        int formatOption = obtenerOpcionHastaTres(sc);

        System.out.print("Introduce el nombre del archivo de salida: ");
        String outputFileName = sc.nextLine();

        //Exportador de archivos
        switch (formatOption) {
            case 1:
                FileExporter.writeCSV(data, outputFileName);
                break;
            case 2:
                FileExporter.writeJSON(data, outputFileName);
                break;
            case 3:
                FileExporter.writeXML(data, outputFileName);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Obtiene la extensión de un archivo
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    }
}
