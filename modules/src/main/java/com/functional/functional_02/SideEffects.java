package com.functional.functional_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SideEffects {
    /**
     * Función impura, el resultado de ejecutarla puede ser observado desde fuera del código.
     * Por ejemplo en una consola
     */
    static void helloWorld() {
        System.out.println("Hola mi papacho");
    }

    /**
     * Función impura, depende de la existencia y el estado de un archivo,
     * eso provoca que sea no determinista
     * ¿Qué sucede si esta función se ejecuta en mi computadora y en tu computadora?
     * - ¿Podemos determinar la salida de ambos casos?
     * - ¿Cómo nos aseguramos que nadie más esté modificando el archivo?
     */
    static boolean containsMexico(File file) {
        try(BufferedReader bfReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bfReader.readLine()) != null) {
                if(line.contains("Mexico")) {
                    return true;
                }
            }
        } catch (IOException ignored) {
            return false;
        }
        return false;
    }

    /**
     * Función impura. Aunque el código no está implementado, con entender lo que hace
     * sabemos que es no determinista y que no podemos garantizar los resultados para un cierto parametro
     */
    static String getLastNameForGiveName(String name) {
        /**
         * Obtener una conexión a la base de datos
         * Ejecutar una query en la base de datos
         * Revisar los resultados de la query
         * retornar el valor del lastName o un valor por default en caso de ausencia
         */
        return "";
    }
}
