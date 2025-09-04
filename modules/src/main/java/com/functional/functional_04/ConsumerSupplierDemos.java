package com.functional.functional_04;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsumerSupplierDemos {
    /**
     * Con un consumer podemos generar una función simple que toma un dato y no regresa ningun valor
     * El ejemplo más común es tomar un valor e imprimirlo por pantalla, o en nuestro ejemplo
     * tomar un dato y almacenarlo en un archivo y una base de datos.
     */
    private static void persistAccount(Account account) {
        Consumer<Account> toFile = acnt -> saveToFile(acnt);

        Consumer<Account> toDB = acnt -> getDataBaseConnection().insert(acnt);

        //saveAccountTo no le interesa lo que el consumer haga, simplemente necesita
        //una manera de pasarle el dato para almacenarlo.
        saveAccountTo(account, toFile);
        saveAccountTo(account, toDB);
    }

    private static void saveAccountTo(Account account, Consumer<Account> saveFunction) {
        //Ejecutar validaciones antes de almacenar
        //Después almacenamos sin preocuparnos como
        saveFunction.accept(account);
    }

    /**
     * Un Supplier es una función que sabe como conseguir datos.
     * Este tipo de funciones se utiliza para principalmente cuando tenemos secuencias
     * o requerimos de algún proceso más que un simple constructor para generar un dato.
     *
     * No existe una regla o condición de si el Supplier debe generar un nuevo objeto
     * o si puede devolver siempre el mismo o generar alguno de manera aleatoria.
     */
    private void supplierDemo() {
        Supplier<Double> numberSupplier = () -> Math.random();

        Supplier<DataBaseExecutor> dbSupplier = () -> getDataBaseConnection();

        Function<String, Integer> dbFunction = sId -> dbSupplier.get().select(sId);
    }

    private static void saveToFile(Account account) {

    }

    private static DataBaseExecutor getDataBaseConnection() {
        return null;
    }

    private class Account {

        private final String id;
        private final double balance;

        public Account(String id, double balance) {
            this.id = id;
            this.balance = balance;
        }
    }

    private interface DataBaseExecutor {

        <T> void insert(T instance);

        <T> T select(String id);
    }
}
