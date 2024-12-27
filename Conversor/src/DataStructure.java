import java.io.*;
import java.util.*;

public class DataStructure {
    private List<String> data = new ArrayList<>();

    // Método para leer archivos CSV
    public void readCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line); // Cada línea del archivo se añade a la lista
            }
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    // Método para leer archivos JSON (ejemplo simplificado)
    public void readJSON(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder jsonContent = new StringBuilder();
            while ((line = br.readLine()) != null) {
                jsonContent.append(line); // Leer todo el contenido del archivo JSON
            }
            // Aquí podrías agregar la lógica para convertir jsonContent a objetos adecuados
            data.add(jsonContent.toString());
            System.out.println("Archivo JSON leído correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    // Método para leer archivos XML (ejemplo simplificado)
    public void readXML(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder xmlContent = new StringBuilder();
            while ((line = br.readLine()) != null) {
                xmlContent.append(line); // Leer todo el contenido del archivo XML
            }
            // Aquí podrías agregar la lógica para convertir xmlContent a objetos adecuados
            data.add(xmlContent.toString());
            System.out.println("Archivo XML leído correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

    // Método para obtener los datos
    public List<String> getData() {
        return data;
    }
}
