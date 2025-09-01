package com.functional.functional_01;

public class PureFunctions {
    /**
     * Aunque hoy conocemos a los metodos estaticos como metodos de clase o simplemente metodos estaticos,
     * en realidad un metodo puede ser considerado o visto como una función,
     * <p>
     *     Basandonos en nuestra definición de función, sabemos que para cada X genera una Y. En este caso,
     *     nuestra "x" es en realidad el par (x, y) y nuestra "y" será el resultado de sumarlas.
     *     <p>
     *         ¿Habrá algún cambio en el resultado si yo ejecuto 90 veces sum(3,5)?
     *         La respuesta es NO.
     *         Una función pura no depende de estados exteriores (propiedades, objetos, variables externas a su definición, etc.)
     *         ni ve afectado su resultado por agentes externos.
     */
    public static int sum(int x, int y) {
        return x + y;
    }

    static class Person {

        private double balance;

        public Person(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    /**
     * ¿Esta función se le puede considerar pura?
     */
    public static boolean hasAvailableFunds(double funds) {
        return funds > 0.0;
    }

    /**
     * La respuesta es si
     * porque la funcion revisa unicamente si un número es mayor a cero, no importa la referencia de donde venga
     * los fondos, mientras esos fondos sean menores o iguales a cero, la respuesta siempre será false.
     */
    public static  void main(String[] args) {
        Person joan = new Person(-20.00);

        /** Debería imprimir false, joan tiene saldo negativo y anda sin trabajo XD pipipipipipi*/
        System.out.println(hasAvailableFunds(joan.getBalance()));

        /** María si tiene cualto por lo cual debe devolver true*/
        Person maria = new Person(130.000);
        System.out.println(hasAvailableFunds(maria.getBalance()));
    }
}
