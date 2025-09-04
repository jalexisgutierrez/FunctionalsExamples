package com.functional.functional_04;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorsAndBiFunctions {
    /**
     * Existen algunas simplificaciones de funciones que te ayudan a entender más
     * directamente que hacen o sobre que trabajan, un ejemplo es UnaryOperator
     */
    private static void unaries() {
        /** Aunque esta función luce muy parecida a una que ya usamos previamente,
         *  el tenerla como UnaryOperator nos deja en claro que es una operación que
         *  trabaja sobre un tipo y nos retorna el mismo tipo.
         */
        UnaryOperator<Integer> square = x -> x * x;
        UnaryOperator<String> quote = s -> "\"" + s + "\"";

        quote.apply("Programming is the art of doing one thing at a time");

    }

    /**
     * Pero a veces, las operaciones simples como una suma requieren de dos parametros...
     * ¿Cómo podríamos definir una función que toma dos parametros sin complicarnos la life?
     * BiFunction!!!
     */
    public static void twiceTheFun() {
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;

        BiFunction<String, Integer, String> leftPad = (s, i) -> String.format("%" + i + "s", s);

        System.out.println(leftPad.apply("Hello", 10));

        //Pero si los parametros son del mismo tipo y el resultado es del mismo tipo,
        // podemos usar operators!!
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
    }
}
