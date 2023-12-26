package org.model;

public class Post {
    private User author;
    private String text;
    private User addedToFeedBy;
    private Group addedToGroupBy;

    public Post(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }



    public void setAddedToFeedBy(User user) {
        this.addedToFeedBy = user;
    }




    public String getAddedToGroupName() {
        return this.addedToGroupBy != null ? addedToGroupBy.getName() : "None";
    }

    public void setAddedToGroupBy(Group group) {
        this.addedToGroupBy = group;
    }

    public Group getAddedToGroupBy() {
        return addedToGroupBy;
    }
}
