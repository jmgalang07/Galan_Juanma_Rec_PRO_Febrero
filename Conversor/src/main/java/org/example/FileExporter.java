/**
 * Clase FileExporter para exportar datos en diferentes formatos (CSV, JSON, XML).
 * Utiliza una estructura de datos genérica representada por {@link DataStructure}.
 */
package org.example;

import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileExporter {

    /**
     * Exporta los datos almacenados en la estructura interna a un archivo CSV.
     *
     * @param data            la estructura de datos que contiene los datos a exportar.
     * @param outputFileName  el nombre del archivo de salida (sin extensión).
     */
    public static void writeCSV(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".csv")) {
            // Obtengo los datos desde la estructura interna
            List<Map<String, String>> dataList = data.getData();

            // Verifico que haya datos en la lista antes de escribir
            if (!dataList.isEmpty()) {
                // Escribo los encabezados utilizando las claves del primer mapa
                Map<String, String> firstEntry = dataList.get(0);
                writer.write(String.join(",", firstEntry.keySet()) + "\n");

                // Escribo cada entrada de datos como una fila en el archivo CSV
                for (Map<String, String> entry : dataList) {
                    // Verifico si algún valor es null y lo reemplazo con una cadena vacía
                    writer.write(String.join(",", entry.values().stream()
                            .map(value -> value == null ? "" : value) // Manejo de valores nulos
                            .toArray(String[]::new)) + "\n");
                }

                // Confirmo que el archivo fue exportado correctamente
                System.out.println("Archivo CSV exportado correctamente.");
            }
        } catch (IOException e) {
            // Manejo de errores si ocurre un problema al escribir el archivo
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Exporta los datos almacenados en la estructura interna a un archivo JSON.
     *
     * @param data            la estructura de datos que contiene los datos a exportar.
     * @param outputFileName  el nombre del archivo de salida (sin extensión).
     */
    public static void writeJSON(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".json")) {
            JSONArray jsonArray = new JSONArray();

            // Obtengo los datos desde la estructura interna
            List<Map<String, String>> dataList = data.getData();

            // Recorro cada mapa de la lista de datos
            for (Map<String, String> entry : dataList) {
                // Convierto cada entrada en un JSONObject y lo añado al JSONArray
                JSONObject jsonObject = new JSONObject(entry);
                jsonArray.put(jsonObject);
            }

            // Escribo el JSONArray como texto JSON al archivo con una indentación de 4 espacios
            writer.write(jsonArray.toString(4));

            // Confirmo que el archivo fue exportado correctamente
            System.out.println("Archivo JSON exportado correctamente.");
        } catch (IOException e) {
            // Manejo de errores si ocurre un problema al escribir el archivo
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }


    /**
     * Exporta los datos almacenados en la estructura interna a un archivo XML.
     *
     * @param data            la estructura de datos que contiene los datos a exportar.
     * @param outputFileName  el nombre del archivo de salida (sin extensión).
     */
    public static void writeXML(DataStructure data, String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName + ".xml")) {
            // Escribo la etiqueta raíz inicial para el archivo XML
            writer.write("<data>\n");

            // Obtengo la lista de datos desde la estructura interna
            List<Map<String, String>> dataList = data.getData();

            // Recorro cada mapa en la lista de datos
            for (Map<String, String> entry : dataList) {
                // Inicio una nueva entrada XML representando un registro
                writer.write("  <record>\n");

                // Escribo cada campo del mapa como un elemento XML
                for (Map.Entry<String, String> field : entry.entrySet()) {
                    writer.write("    <" + field.getKey() + ">" +
                            field.getValue() +
                            "</" + field.getKey() + ">\n");
                }

                // Cierro la etiqueta del registro
                writer.write("  </record>\n");
            }

            // Escribo la etiqueta raíz de cierre
            writer.write("</data>\n");

            // Confirmo que el archivo fue exportado correctamente
            System.out.println("Archivo XML exportado correctamente.");
        } catch (IOException e) {
            // Manejo de errores si ocurre un problema al escribir el archivo
            System.out.println("Error al escribir el archivo XML: " + e.getMessage());
        }
    }
}
