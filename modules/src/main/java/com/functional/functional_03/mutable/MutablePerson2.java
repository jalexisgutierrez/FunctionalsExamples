package com.functional.functional_03.mutable;

import java.util.List;

/**
 * Clase mejorada.
 * Aquí obligamos a quien use esta clase a crear instancias usando el contructor.
 * Quitamos el setter para evitar que hagan modificaciones pelilosas...
 */
public class MutablePerson2 {

    private String firstName;
    private String lastName;

    private List<String> emails;

     public MutablePerson2(List<String> emails) {
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
        return emails;
    }

    @Override
    public String toString() {
        return "MutablePerson2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
