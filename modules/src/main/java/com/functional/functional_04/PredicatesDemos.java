package com.functional.functional_04;

import java.util.function.*;

public class PredicatesDemos {
    /**
     * Pero definir funciones no lo es todo, también podemos definir otro tipo de funciones
     * que nos sirvan para definir criterios y validaciones: Predicados
     */
    private static void checkPassword(String password) {
        Predicate<String> isAllWhite = s -> s.trim().isEmpty();
        Predicate<String> hasGoodLength = s -> s.length() > 8;
        Predicate<String> hasAtLeastOneNumber = s -> s.matches("\\d+");
        Predicate<String> hasAnUpperCaseLetter = s -> s.matches("[A-Z]+");

        Predicate<String> isAValidPassword = s ->
                !isAllWhite.test(s)
                && hasGoodLength.test(s)
                && hasAtLeastOneNumber.test(s)
                && hasAnUpperCaseLetter.test(s);

        isAValidPassword.test(password);
    }

    /**
     * La interfaz Predicate te ayuda con las validaciones de objetos complejos,
     * para algunos datos ya definidos en el lenguaje, existen sus equivalentes
     */
    private static void validations() {
        IntPredicate intPredicate;
        DoublePredicate doublePredicate;
        LongPredicate longPredicate;

        /**
         * y si se necesita hacer alguna validación más compleja de dos elementos como comparar
         * que un dato sea más grande que otro
         */
        BiPredicate<String, String> isXLargerThanY = (x, y) -> x.length() > y.length();

        isXLargerThanY.test("Lobo", "Perrito");
    }
}
