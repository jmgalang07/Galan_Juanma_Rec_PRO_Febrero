import java.io.FileWriter;
import java.io.IOException;

public class FileExporter {

    public static void writeCSV(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".csv")) {  // Usamos el FileWriter de java.io
            // Convertir la lista 'data' a formato CSV y escribir en el archivo
            writer.write("CSV data here");  // Ejemplo de escritura
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    public static void writeJSON(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".json")) {
            // Convertir la lista 'data' a formato JSON y escribir en el archivo
            writer.write("{ \"json\": \"data\" }");  // Ejemplo de escritura
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public static void writeXML(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".xml")) {
            // Convertir la lista 'data' a formato XML y escribir en el archivo
            writer.write("<xml><data>XML data here</data></xml>");  // Ejemplo de escritura
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo XML: " + e.getMessage());
        }
    }
}
