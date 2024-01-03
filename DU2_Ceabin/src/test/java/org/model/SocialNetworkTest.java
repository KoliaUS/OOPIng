package org.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {
    SocialNetwork network = new SocialNetwork();

    User u1 = new User("u1");
    User u2 = new User("u2");
    User u3 = new User("u3");
    User u4 = new User("u4");
    @Test
    public void testSocialNetwork() {


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
        Group catsGroup = network.groups.get(1);


        dogsGroup.addFollow(u3);
        dogsGroup.addFollow(u4);

        catsGroup.addFollow(u1);
        catsGroup.addFollow(u2);

        u1.addPost("Nazdar!");
        catsGroup.addPost("Kocky jsou top!", u2);

        u3.addPost("Muj prvni post");
        dogsGroup.addPost("Miluju psy!", u3);


        //Kontrala zda je spravny pocet postu
        assertEquals(3, u1.getFeedPosts().size());
        assertEquals(3, u2.getFeedPosts().size());
        assertEquals(3, u3.getFeedPosts().size());
        assertEquals(2, u4.getFeedPosts().size());

        // Kontrola feedu, kazdy uzivatel vidi svoje posty a kamaradu/skupin
        assertTrue(u1.getFeedPosts().stream().anyMatch(post -> post.getText().equals("Nazdar!")));
        assertTrue(u2.getFeedPosts().stream().anyMatch(post -> post.getText().equals("Kocky jsou top!")));
        assertTrue(u3.getFeedPosts().stream().anyMatch(post -> post.getText().equals("Muj prvni post")));
        assertTrue(u3.getFeedPosts().stream().anyMatch(post -> post.getText().equals("Nazdar!")));
        assertTrue(u4.getFeedPosts().stream().anyMatch(post -> post.getText().equals("Miluju psy!")));



    }
}
