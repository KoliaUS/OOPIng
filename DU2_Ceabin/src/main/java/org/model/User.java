package org.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Observer,Observable {
    private String username;
    private List<User> friends;
    private List<Group> groups;
    private List<Post> posts;

    private Feed feed;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.feed = new Feed();
    }

    public String getUsername() {
        return username;
    }

    public List<User> getFriends() {
        return friends;
    }
    public void addPost(String text) {
        Post post = new Post(this, text);
        posts.add(post);
        addToFeed(post);
    }


    public void addToFeed(Post post) {
        post.setAddedToFeedBy(this);
        feed.addPost(post);
        updateFeed();
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void updateFeed() {
        feed.getPosts().clear();

        Set<Post> addedPosts = new HashSet<>();


        for (Post post : posts) {
            if (!addedPosts.contains(post)) {
                feed.addPost(post);
                addedPosts.add(post);
            }
        }


        for (User friend : friends) {
            for (Post post : friend.getPosts()) {
                if (!addedPosts.contains(post)) {
                    feed.addPost(post);
                    addedPosts.add(post);
                }
            }
        }


        for (Group group : groups) {
            for (Post post : group.getPosts()) {
                if (!addedPosts.contains(post)) {
                    feed.addPost(post);
                    addedPosts.add(post);
                }
            }
        }
    }


    public List<Post> getFeedPosts() {
        List<Post> allPosts = new ArrayList<>();

        allPosts.addAll(posts);

        for (User friend : friends) {
            allPosts.addAll(friend.getPosts());
        }

        for (Group group : groups) {
            allPosts.addAll(group.getPosts());
        }

        return allPosts;
    }


    public List<Group> getGroups() {
        return groups;
    }

    public void printFeed() {
        System.out.println("Feed uživatele " + this.getUsername() + ":");

        for (Post post : this.getFeedPosts()) {

            if (post.getAddedToGroupBy() != null) {
                System.out.println("Group: " + post.getAddedToGroupName());
            }

            String authorUsername = post.getAuthor().getUsername();
            String postText = post.getText();

            System.out.println(authorUsername + ": " + postText);
        }


        System.out.println();
    }


    @Override
    public void addFollow(User user) {
        friends.add(user);
        user.friends.add(this);
    }

    @Override
    public void notification(Post post) {
        post.setAddedToFeedBy(this);
        feed.addPost(post);
        updateFeed();
    }
}
