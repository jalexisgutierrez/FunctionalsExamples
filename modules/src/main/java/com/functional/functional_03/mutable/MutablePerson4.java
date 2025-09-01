package com.functional.functional_03.mutable;


import java.util.LinkedList;
import java.util.List;

public class MutablePerson4 extends MutablePerson3{

    public MutablePerson4(List<String> emails) {
        super(emails);
    }

    @Override
    public List<String> getEmails() {
        List<String> spammyEmails = new LinkedList<>();
        spammyEmails.add("BancoHacker@xd.com");
        spammyEmails.add("tehackeoElD1@mail.com");
        return spammyEmails;
    }

}
