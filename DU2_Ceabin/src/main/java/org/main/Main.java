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

        u1.addFriend(u2);
        u1.addFriend(u3);
        u1.addFriend(u4);

        u2.addFriend(u3);
        u2.addFriend(u4);

        network.createGroup("Pejskaři");
        network.createGroup("Kočkaři");

        Group dogsGroup = network.groups.get(0);
        dogsGroup.addMember(u3);
        dogsGroup.addMember(u4);

        Group catsGroup = network.groups.get(1);
        catsGroup.addMember(u1);
        catsGroup.addMember(u2);

        u3.addPost("Nazdar!", u3);
        dogsGroup.addPost("Miluju pejsky", u3);

        u1.addPost("Ahoj vsem!", u1);
        catsGroup.addPost("Kocky jsou top", u1);

        u2.addPost("F", u2);
        catsGroup.addPost("Cats!!!!", u2);


        u1.printFeed();
        u2.printFeed();
        u3.printFeed();
        u4.printFeed();




    }
}
