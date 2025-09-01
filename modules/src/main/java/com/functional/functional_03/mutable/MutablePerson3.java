package com.functional.functional_03.mutable;

import java.util.List;
/**
 * Más mejoras. Ahora nuestra lista de emails es final. Eso nos garantiza que nadie sobreescribe
 * el valor de la propiedad y una vez creado siempre será la misma lista
 */
public class MutablePerson3 {
    private String firstName;
    private String lastName;

    private final List<String> emails;

    public MutablePerson3(List<String> emails) {
        this.emails = emails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getEmails() {
        return (emails);
    }

    @Override
    public String toString() {
        return "MutablePerson3{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
