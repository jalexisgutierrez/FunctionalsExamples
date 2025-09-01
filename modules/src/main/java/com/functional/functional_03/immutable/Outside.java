package com.functional.functional_03.immutable;

import java.util.LinkedList;
import java.util.List;

public class Outside {
    public static void main(String[] args) {
        String firstName = "Joan";
        String lastName = "GG";

        List<String> emails = new LinkedList<>();
        emails.add("jalexisgutierrez@mail.com");

        ImmutablePerson joan = new ImmutablePerson(firstName, lastName,emails);

        System.out.println(joan);
        badIntentionedMethod(joan);
        System.out.println(joan);

    }

    /**
     * No importa que el metodo intente modificar a la persona, la persona esta diseñada
     * para no recibir modificaciones.
     */
    static void badIntentionedMethod(ImmutablePerson person) {
        List<String> emails = person.getEmails();
        emails.clear();
        emails.add("imnotthebadguy@mail.com");
    }
}
