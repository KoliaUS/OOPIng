package org.example.model;

import java.util.List;

public class Eshop {
    private List<Sklad> zbozi;
    private List<User> users;

    public Eshop(List<Sklad> zbozi, List<User> users) {
        this.zbozi = zbozi;
        this.users = users;
    }

    public List<Sklad> getZbozi() {
        return zbozi;
    }

    public List<User> getUsers() {
        return users;
    }
    public void addToKosik(String user)
    {

        Kosik kosik = new Kosik(this, user);


    }

}
