package org.example.model;

import java.util.List;

public class Kosik {
    private List<Sklad> zbozi;
    private User user;

    public Kosik(List<Sklad> zbozi, User user) {
        this.zbozi = zbozi;
        this.user = user;
    }

    public Kosik(Eshop eshop, String user) {
    }

    public List<Sklad> getZbozi() {
        return zbozi;
    }

    public User getUser() {
        return user;
    }
}

