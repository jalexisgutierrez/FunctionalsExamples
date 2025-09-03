package com.functional.functional_04;

import com.functional.util.Utils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    /**
     * La interface Function trabaja sobre generics, siendo el primero el tipo de entrada
     * y el segundo el resultado de ejecutar esa función
     */
    private static <TYPE, RESULT> void metodoDeEjemplo() {
        //Podemos crear instancias bajo demanda...
        Function<TYPE, RESULT> someFun = new Function<TYPE, RESULT>() {
            /**
             * El único método que hay que implementar es el método apply.
             * Este método tomara el TYPE y debe generar un RESULT
             */
            @Override
            public RESULT apply(TYPE type) {
                return null;
            }
        };

        //Luego invocar el método apply con parametros del tipo correspondiente...
        someFun.apply(null);
    }

    /**
     * Vamos a ver un ejemplo pequeño sobre una función que nos retorna si un número es par o no
     */
    private static void FunctionExamples() {
        Function<Integer, Boolean> isEven = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) {
                return integer % 2 == 0;
            }
        };

        isEven.apply(2);//si es(True)
        isEven.apply(25);//nonas(False)
    }

    // El proceso es muy similar a tener definidos métodos o instancias anónimas como al ordenar número.
    private static void sortNumber(List<Integer> number) {
        //Aquí generamos una instancia anónima de comparator
        number.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    /**
     * También podemos crear clases más complejas que implementen esta interface...
     */
    class FunctionBy2 implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x* 2;
        }
    }

    /**
     * Y después usar esas instancias...
     * hasta ahora nada nuevo o realmente funcional...
     * en realidad esto es solo lo que ya conocemos de usar interfaces y OOP
     */
    private static void userBy2(FunctionBy2 by2) {
        int y = by2.apply(5);
    }

    /**
     * Lo interesante viene cuando entendemos que una función es un tipo...
     * (mantengamos con funciones y enteros por ahora)
     */
    private static void functionsAreTypes() {
        /**
         * Si una función es un tipo, también podemos usarla con generics.
         * Por ejemplo, devolver una función como resultado de ejecutar una función...
         *
         * Es algo parecido a obtener una sublista de una lista:
         * ->> List<X> sub = list.sublist(0, 5);
         */
        Function<Integer, Function<Integer, Integer>> multiply =
                new Function<Integer, Function<Integer, Integer>>() {
                    @Override
                    public Function<Integer, Integer> apply(Integer x) {
                        //Creamos una nueva función y la retornamos
                        return new Function<Integer, Integer>() {
                            @Override
                            public Integer apply(Integer y) {
                                return x * y;
                            }
                        };
                    }
                };
        //Usando nuestra nueva función
        multiply.apply(5).apply(4); // Resultado: 20

        // O podemos crear funciones derivadas de la primera función
        Function<Integer, Integer> multiplyBy3 = multiply.apply(3);
        multiplyBy3.apply(2);//Resultado: 6
    }

    /**
     * Pero la sintaxis de crear instancias de interfaces es demasiado extensa y complicada de leer...
     * usaremos la nueva sintaxis de java 8 para funciones
     * (Explicaremos todas las sintaxis y las diferencias más adelante)
     */
    private static void syntaxFixing() {
        Function<Integer, Integer> multiplyBy5 = x -> x * 5;

        //Con esto nos ahorramos crear una clase que implemente la interfaz
        //Crear funciones se hace más simple
        multiplyBy5.apply(10); //Resultado una 50tona

        //Incluso para funciones que retornan funciones (high order functions)
        Function<Integer, Function<Integer, Integer>> multiplyXByY = x -> y -> x * y;

        //Sabemos que al mandar a llamar al método apply obtendremos una nueva función...
        Function<Integer, Integer> multiply2ByY = multiplyXByY.apply(2);

        multiply2ByY.apply(7); //Resultado -> 14

        //O podemos seguir llamando al resultado directamente
        multiplyXByY.apply(9).apply(8);// 72
    }

    /**
     * Lo bueno empieza no cuando la definimos...
     * empieza cuando las empezamos a pasar como parametros y recibir como resultados...
     */
    private static void funWithFuns() {
        List<Integer> myNumbers = Utils.getListOf(1, 2, 3, 4, 5, 6);

        //Función que eleva un número al cuadrado
        Function<Integer, Integer> square = x -> x * x;

        //Función que eleva el número al cubo
        Function<Integer, Integer> cube = x -> x * x * x;

        //Función que convierte un entero en negativo
        Function<Integer, Integer> toNegative =  x -> -1 * x;

        applyMathToList(myNumbers, square); // [1, 4, 9, 16, 25, 36]
        applyMathToList(myNumbers, cube); // [1, 8, 27, 64, 125, 216]
        applyMathToList(myNumbers, toNegative); // [-1, -2, -3, -4, -5, -6]
    }

    /**
     * Podemos decir que algúnos métodos son funciones, en este caso, este metodo es una
     * función de orden mayor que toma como parametro otra función y la usa para operar la lista
     */
    private static List<Integer> applyMathToList(
            List<Integer> items,
            Function<Integer, Integer> operation
    ) {
        List<Integer> resultItems = new LinkedList<>();
        for(Integer x : items) {
            resultItems.add(operation.apply(x));
        }
        return resultItems;
    }

    /**
     * Incluso podríamos hacer cosas más interesantes como aplicar muchas funciones sobre un dato
     */
    private static String transformText(String text) {
        List<Function<String, String>> transformation = new LinkedList<>();

        transformation.add(s -> s.toUpperCase());
        transformation.add(s -> s.replaceAll("SI", "TI"));
        transformation.add(s -> s.replaceAll("RO", "YO"));
        transformation.add(s -> s.replaceAll("O", "OooO"));

        String result = text;
        for(Function<String, String> function : transformation) {
            result = function.apply(result);
        }
        return result;
    }

    private static void runTransform() {
        System.out.println(transformText("Hello"));
        System.out.println(transformText("world"));
        System.out.println(transformText("Claro que si ronco"));
    }

    public static void main(String[] args) {
        runTransform();
    }
}
