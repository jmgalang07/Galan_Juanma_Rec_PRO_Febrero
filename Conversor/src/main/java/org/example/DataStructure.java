/**
 * Clase DataStructure que permite leer datos desde diferentes formatos de archivo (CSV, JSON, XML)
 * y almacenarlos en una lista de mapas para su procesamiento.
 */
package org.example;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.*;

public class DataStructure {
    private final List<Map<String, String>> data = new ArrayList<>();

    /**
     * Lee un archivo CSV y almacena los datos en la estructura interna.
     *
     * @param file el archivo CSV a leer.
     */
    public void readCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Antes de comenzar, limpio los datos existentes para asegurarme de que la lista esté vacía
            data.clear();

            // Leo la primera línea del archivo, que contiene los encabezados, y los divido por comas
            String line;
            String[] headers = br.readLine().split(",");

            // Ahora proceso cada línea del archivo después de los encabezados
            while ((line = br.readLine()) != null) {
                // Divido la línea en valores usando la coma como separador
                String[] values = line.split(",");

                // Creo un mapa para almacenar la relación entre encabezado y valor
                Map<String, String> entry = new HashMap<>();

                // Recorro los encabezados y asigno cada valor correspondiente
                for (int i = 0; i < headers.length; i++) {
                    entry.put(headers[i], values[i]);
                }

                // Agrego el mapa creado a la lista de datos
                data.add(entry);
            }

            // Confirmo que el archivo se leyó correctamente
            System.out.println("Archivo CSV leído correctamente.");
        } catch (IOException e) {
            // Capturo y muestro cualquier error que ocurra al leer el archivo
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo JSON y almacena los datos en la estructura interna.
     *
     * @param file el archivo JSON a leer.
     */
    public void readJSON(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Antes de leer el archivo, limpio los datos almacenados previamente para evitar mezclar datos antiguos con nuevos
            data.clear();

            // Uso un StringBuilder para leer todo el contenido del archivo JSON línea por línea
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                // Voy acumulando cada línea en el StringBuilder
                jsonContent.append(line);
            }

            // Una vez que tengo el contenido completo del archivo, lo convierto a un JSONArray
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Recorro cada objeto dentro del JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                // Obtengo el objeto JSON actual
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Creo un mapa para almacenar las claves y valores del objeto JSON
                Map<String, String> entry = new HashMap<>();

                // Recorro cada clave en el objeto JSON y las agrego al mapa como pares clave-valor
                for (String key : jsonObject.keySet()) {
                    entry.put(key, jsonObject.get(key).toString()); // Convierto el valor a String para asegurar compatibilidad
                }

                // Agrego el mapa resultante a mi lista de datos
                data.add(entry);
            }

            // Confirmo que la operación se completó exitosamente
            System.out.println("Archivo JSON leído correctamente.");
        } catch (IOException | JSONException e) {
            // Manejo cualquier error que ocurra al leer o procesar el archivo JSON
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo XML y almacena los datos en la estructura interna.
     *
     * @param file el archivo XML a leer.
     */
    public void readXML(File file) {
        try {
            // Antes de comenzar, limpio los datos almacenados previamente para evitar conflictos con datos antiguos
            data.clear();

            // Configuro el DocumentBuilderFactory para crear un analizador de documentos XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Analizo el archivo XML para convertirlo en un objeto Document
            Document doc = builder.parse(file);

            // Obtengo todos los nodos con la etiqueta "producto"
            NodeList nodeList = doc.getElementsByTagName("producto");

            // Recorro cada nodo en el NodeList
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Convierto el nodo actual en un Element
                Element element = (Element) nodeList.item(i);

                // Creo un mapa para almacenar las claves y valores de este elemento
                Map<String, String> entry = new HashMap<>();

                // Obtengo los nodos hijos de este elemento
                NodeList children = element.getChildNodes();

                // Recorro cada nodo hijo
                for (int j = 0; j < children.getLength(); j++) {
                    // Verifico si el nodo hijo es un Element
                    if (children.item(j) instanceof Element) {
                        // Agrego el nombre del nodo y su contenido al mapa
                        entry.put(children.item(j).getNodeName(), children.item(j).getTextContent());
                    }
                }

                // Agrego el mapa creado a mi lista de datos
                data.add(entry);
            }

            // Confirmo que el archivo XML se procesó correctamente
            System.out.println("Archivo XML leído correctamente.");
        } catch (Exception e) {
            // Manejo cualquier error que ocurra durante la lectura o el procesamiento del archivo XML
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

    /**
     * Obtiene los datos almacenados en la estructura interna.
     *
     * @return una lista de mapas que representa los datos leídos.
     */
    public List<Map<String, String>> getData() {
        // Devuelvo la lista de mapas que contiene los datos procesados
        return data;
    }
}
