package com.functional.functional_03.immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase final de nuestro dineño
 *
 * Cuenta con más de una mejora
 *
 * 1) Es final, así nadie puede extender de ella. No más suplantaciones.
 * 2) Las propiedades son finales, una vez creado un objeto no puede mutar.
 * 3) El constructor exige todas las propiedades para generar un objeto
 * (podría incluso generarse un builder derivado de este constructor).
 * 4) ¡Cuando se accede a los emails, se genera una copia! ¡No se encia la lista mutable!
 */
public final class ImmutablePerson {

    private final String firstName;
    private final String lastName;

    private final List<String> emails;

    public ImmutablePerson(String firstName, String lastName, List<String> emails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = emails;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public final List<String> getEmails() {
        return new LinkedList<>(emails);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
