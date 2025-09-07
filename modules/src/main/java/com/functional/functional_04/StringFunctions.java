package com.functional.functional_04;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {

        UnaryOperator<String> quote = text ->  "\"" + text + "\"";

        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola Estudiante de la universidad de la vida"));

        System.out.println(addMark.apply("Holis"));

        BiFunction<String, Integer, String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Java", 10));
    }
}
