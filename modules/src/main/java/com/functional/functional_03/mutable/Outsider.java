package com.functional.functional_03.mutable;

import java.util.LinkedList;
import java.util.List;

public class Outsider {
    public static void main(String[] args) {

        List<String> joanEmails = new LinkedList<>();
        joanEmails.add("joan@mail.com");

        MutablePerson joan = new MutablePerson();
        joan.setEmails(joanEmails);
        joan.setFirstName("Joan");
        joan.setLastName("GG");

        //Veamos un poco lo peliloso que son las clases mutables
        System.out.println(joan);
        badFunction(joan);
        System.out.println(joan);
        System.out.println("///////////////////////");

        MutablePerson2 joan2 = new MutablePerson2(joanEmails);
        System.out.println(joan2);
        otherBadFunction(joan2);
        System.out.println(joan2);
        System.out.println("//////////////////////");

        MutablePerson3 joan3 = new MutablePerson3(joanEmails);
        System.out.println(joan3);
        otherBadFunctionPart3(joan3);
        System.out.println(joan3);

        System.out.println("////////////////////");

        MutablePerson3 joan4 = new MutablePerson4(joanEmails);
        System.out.println(joan4);
    }

    /**
     * Este método modifica la lista mediante un setter.
     * Tener el setter es peligroso
     */
    static void badFunction(MutablePerson person) {
        List<String> emails = new LinkedList<>();
        emails.add("miraesteemote@mail.com");
        person.setEmails(emails);
    }

    /**
     * Este método toma el objeto devuelto por el getter...
     * pero el objeto es mutable, así que podemos modificarlo sin restricciones...
     */
    static void otherBadFunction(MutablePerson2 person) {
        List<String> emails = person.getEmails();
        emails.clear();
        emails.add("nohabraslinksdepaginasnopor@mail.com");
    }

    static void otherBadFunctionPart3(MutablePerson3 person) {
        List<String> spammyEmails = new LinkedList<>();
        spammyEmails.add("buenosdiasamigazo@mail.com");
        spammyEmails.add("eeeerdiablo@mail.com");

        List<String> emails = person.getEmails();
        emails.clear();

        emails.add("nopodesxd@mail.com");
        emails.addAll(spammyEmails);
    }
}
