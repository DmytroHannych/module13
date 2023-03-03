package module13;

public class Comment {
    int postId;
    int id;
    String name;
    String email;
    String body;

    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
