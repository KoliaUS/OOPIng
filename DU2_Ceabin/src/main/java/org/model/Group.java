package org.model;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> members;
    private List<Post> posts;

    public Group(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
        user.getGroups().add(this);
    }

    public void addPost(String text, User author) {
        Post post = new Post(author, text);
        posts.add(post);
        for (User member : members) {
            member.addToFeed(post);
        }
    }
    public void addPostToGroup(Post post) {
        post.setAddedToGroupBy(this);
        posts.add(post);
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }



    public List<User> getMembers() {
        return this.members;
    }
}
