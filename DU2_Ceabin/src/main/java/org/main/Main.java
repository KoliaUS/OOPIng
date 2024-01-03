package org.main;

import org.model.*;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");

        network.registerUser(u1);
        network.registerUser(u2);
        network.registerUser(u3);
        network.registerUser(u4);

        u1.addFollow(u2);
        u1.addFollow(u3);
        u1.addFollow(u4);

        u2.addFollow(u3);
        u2.addFollow(u4);

        network.createGroup("Pejskaři");
        network.createGroup("Kočkaři");

        Group dogsGroup = network.groups.get(0);
        dogsGroup.addFollow(u3);
        dogsGroup.addFollow(u4);

        Group catsGroup = network.groups.get(1);
        catsGroup.addFollow(u1);
        catsGroup.addFollow(u2);

        u3.addPost("Muj prvni post");
        dogsGroup.addPost("Miluju psy!", u3);

        u1.addPost("Nazdar!");
        catsGroup.addPost("Kocky jsou top!", u2);


        u1.printFeed();
        u2.printFeed();
        u3.printFeed();
        u4.printFeed();

    }
}
