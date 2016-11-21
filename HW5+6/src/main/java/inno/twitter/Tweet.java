package inno.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {

    private long id;

    private String message;

    private Date createdAt;

    private List<Comment> comments = new ArrayList<Comment>();

    private int maxSizeComments = 5;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public boolean addComment(String commentMessage) {
        if (comments.size() == maxSizeComments) return false;
        Comment comment = new Comment();
        comment.setMessage(commentMessage);
        comment.setCreatedAt(new Date());
        return comments.add(comment);
    }

    public int getMaxSizeComments() {
        return maxSizeComments;
    }

    public void setMaxSizeComments(int maxSizeComments) {
        this.maxSizeComments = maxSizeComments;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
